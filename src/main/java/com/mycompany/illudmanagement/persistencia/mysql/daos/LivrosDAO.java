/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mysql.daos;
import com.mycompany.illudmanagement.persistencia.mysql.Registros;
import com.mycompany.illudmanagement.modelo.Livro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;
import com.mycompany.illudmanagement.modelo.Editora;
import com.mycompany.illudmanagement.modelo.Autor;

/**
 *
 * @author gabriel gomes
 */

public class LivrosDAO extends Registros<Livro> {
    public LivrosDAO(){
        setSqlInsercao("INSERT INTO books(barcode, title, _year, author_id, publisher_id) VALUES(?, ?, ?, ?, ?)");
        setSqlAtualiza("UPDATE books SET barcode = ?, title = ? , _year = ?, author_id = ?, publisher_id = ? WHERE book_code = ?");
        setSqlExclusao("DELETE FROM books WHERE book_code = ?");
        setSqlBusca("SELECT * FROM books WHERE book_code = ?");
        setSqlBuscaTodos("SELECT * FROM books");
        setSqlBuscaNome("SELECT * FROM books WHERE title = ?");
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Livro l) throws SQLException{
        ps.setString(1, l.getBarcode());
        ps.setString(2, l.getTitulo());
        ps.setInt(3, l.getAno());
        ps.setInt(4,   insAutor(l.getAutor()));
        ps.setInt(5, insEditora(l.getEditora()));
    }
    
    @Override
    protected void preencherAlteracao(PreparedStatement ps, Livro l) throws SQLException {
        ps.setString(1, l.getBarcode());
        ps.setString(2, l.getTitulo());
        ps.setInt(3, l.getAno());
        ps.setInt(4, updateAutor(l.getAutor()));
        ps.setInt(5, updateEditora(l.getEditora()));
        ps.setInt(6, Integer.parseInt(l.getCodigo()));
    }
    
    
    @Override
    protected void preencherExclusao(PreparedStatement ps, Livro l) throws SQLException {
        ps.setInt(1, Integer.parseInt(l.getCodigo()));
        
    }
    
    @Override
    protected void preencherBusca(PreparedStatement ps, Livro l) throws SQLException {
        ps.setInt(1, Integer.parseInt(l.getCodigo()));
    }
    
    @Override
    protected Livro preencher(ResultSet rs) throws SQLException {
        Livro tempLivro = null;
        
        while(rs.next()){
            tempLivro = new Livro();
            tempLivro.setCodigo(rs.getString("book_code"));
            tempLivro.setBarcode(rs.getString("barcode"));
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
        }
        
        return tempLivro;
    }
    
    @Override 
    protected void preencherBuscaNome(PreparedStatement ps, Livro l) throws SQLException {
        ps.setString(1, l.getTitulo());
    }
    
    @Override
    protected Collection<Livro> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Livro> livros = new ArrayList<Livro>();
        
        while(rs.next()){
            Livro tempLivro = new Livro();
            tempLivro.setCodigo(rs.getString("book_code"));
            tempLivro.setBarcode(rs.getString("barcode"));
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
    
    public int insAutor(Autor a) {
        AutoresDAO autorDAO = new AutoresDAO();
       
        a.setId(autorDAO.inserir(a));
        
        return a.getId();
    }
    
    public int insEditora(Editora e) {
        EditorasDAO editoraDAO = new EditorasDAO();
       
        e.setId(editoraDAO.inserir(e));
            
        return e.getId();
    }
    
    
    public int updateAutor(Autor a) {
        AutoresDAO autorDAO = new AutoresDAO();
        Autor tempAutor = autorDAO.buscarNome(a);
        
        autorDAO.modificar(a);
       
        
        return a.getId();
    }
    
    public int updateEditora(Editora e) {
        EditorasDAO editoraDAO = new EditorasDAO();
       
        editoraDAO.modificar(e);
        
        return e.getId();
    }
}
