/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mysql.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.mycompany.illudmanagement.persistencia.mysql.Registros;
import com.mycompany.illudmanagement.modelo.Autor;

/**
 *
 * @author gabri
 */
public class AutoresDAO extends Registros<Autor> {
    public AutoresDAO(){
        setSqlInsercao("INSERT INTO author(author_name, nacionality) VALUES(?, ?)");
        setSqlAtualiza("UPDATE author SET author_name = ?, nacionality = ? WHERE author_id = ?");
        setSqlExclusao("DELETE FROM author WHERE author_id = ?");
        setSqlBusca("SELECT * FROM author WHERE author_id = ?");
        setSqlBuscaTodos("SELECT * FROM author");
        setSqlBuscaNome("SELECT * FROM author WHERE author_name = ?");
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Autor a) throws SQLException{
        ps.setString(1, a.getNome());
        ps.setString(2, a.getNacionalidade());
    }
    
    @Override
    protected void preencherAlteracao(PreparedStatement ps, Autor a) throws SQLException {
        ps.setString(1, a.getNome());
        ps.setString(2, a.getNacionalidade());
        ps.setInt(3, a.getId());
    }
    
    
    @Override
    protected void preencherExclusao(PreparedStatement ps, Autor a) throws SQLException {
       ps.setInt(1, a.getId());
        
    }
    
    @Override
    protected void preencherBusca(PreparedStatement ps, Autor a) throws SQLException {
        ps.setInt(1, a.getId());
    }
    
    @Override
    protected void preencherBuscaNome(PreparedStatement ps, Autor a) throws SQLException {
        ps.setString(1, a.getNome());
    }
    
    @Override
    protected Autor preencher(ResultSet rs) throws SQLException {
        Autor tempAutor = null;
        
        while(rs.next()){
            tempAutor = new Autor();
            tempAutor.setId(rs.getInt("author_id"));
            tempAutor.setNacionalidade(rs.getString("nacionality"));
            tempAutor.setNome(rs.getString("author_name"));
        }
        
        return tempAutor;
    }
    
    @Override
    protected Collection<Autor> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Autor> tempAutores = new ArrayList<Autor>();
        
        while(rs.next()){
            Autor tempAutor = new Autor();
            tempAutor.setId(rs.getInt("author_id"));
            tempAutor.setNacionalidade(rs.getString("nacionality"));
            tempAutor.setNome(rs.getString(rs.getString("author_name")));
            tempAutores.add(tempAutor);
        }
        
        return tempAutores;
    }
}
