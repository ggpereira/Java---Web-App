/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.mysql.daos;
import persistencia.mysql.Registros;
import modelo.Livro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;
import modelo.Editora;
import modelo.Autor;

/**
 *
 * @author gabriel gomes
 */

public class LivrosDAO extends Registros<Livro> {
    public LivrosDAO(){
        setSqlInsercao("INSERT INTO books(barcode, title, _year, author_id) VALUES(?, ?, ?, ?, ?)");
        setSqlAtualiza("UPDATE books SET title = ?, publisher_id = ? WHERE book_code = ?");
        setSqlExclusao("DELETE FROM books WHERE book_code = ?");
        setSqlBusca("SELECT * FROM books WHERE book_code = ?");
        setSqlBuscaTodos("SELECT * FROM books");
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Livro l) throws SQLException{
        ps.setInt(1, l.getBarcode());
        ps.setString(2, l.getTitulo());
        ps.setInt(3, l.getAno());
        ps.setInt(4, l.getEditora().getId());
        ps.setInt(5, l.getAutor().getId());
    }
    
    @Override
    protected void preencherAlteracao(PreparedStatement ps, Livro l) throws SQLException {
        ps.setString(1, l.getTitulo());
        ps.setInt(2, l.getEditora().getId());
        ps.setInt(3, l.getCodigo());
    }
    
    
    @Override
    protected void preencherExclusao(PreparedStatement ps, Livro l) throws SQLException {
        ps.setInt(1, l.getCodigo());
        
    }
    
    @Override
    protected void preencherBusca(PreparedStatement ps, Livro l) throws SQLException {
        ps.setInt(1, l.getCodigo());
    }
    
    @Override
    protected Livro preencher(ResultSet rs) throws SQLException {
        Livro tempLivro = new Livro();
        
        tempLivro.setCodigo(rs.getInt("book_code"));
        tempLivro.setBarcode(rs.getInt("barcode"));
        tempLivro.setAno(rs.getInt("_year"));
        tempLivro.setTitulo(rs.getString("title"));
        
        //Preenche com editora correspondente ao livro
        EditorasDAO eDao = new EditorasDAO();
        Editora e = new Editora();
        e.setId(rs.getInt("publisher_id"));
        e = eDao.buscar(e);
        
        //Preenche autor
        AutoresDAO aDao = new AutoresDAO();
        Autor a = new Autor();
        a.setId(rs.getInt("author_id"));
        a = aDao.buscar(a);
        
        tempLivro.setAutor(a);
        tempLivro.setEditora(e);
        
        return tempLivro;
    }
    
    @Override
    protected Collection<Livro> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Livro> livros = new ArrayList<Livro>();
        
        while(rs.next()){
            Livro tempLivro = new Livro();
            tempLivro.setCodigo(rs.getInt("book_code"));
            tempLivro.setBarcode(rs.getInt("barcode"));
            tempLivro.setAno(rs.getInt("_year"));
            tempLivro.setTitulo(rs.getString("title"));
            
            //Preenche com editora correspondente ao livro
            EditorasDAO eDao = new EditorasDAO();
            Editora e = new Editora();
            e.setId(rs.getInt("publisher_id"));
            e = eDao.buscar(e);
        
            //Preenche autor
            AutoresDAO aDao = new AutoresDAO();
            Autor a = new Autor();
            a.setId(rs.getInt("author_id"));
            a = aDao.buscar(a);
        
            tempLivro.setAutor(a);
            tempLivro.setEditora(e);
            
            livros.add(tempLivro);
        }
       
        return livros;
    }
}
