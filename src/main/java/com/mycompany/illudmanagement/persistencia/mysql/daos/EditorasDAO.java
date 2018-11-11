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
import com.mycompany.illudmanagement.modelo.Editora;
/**
 *
 * @author gabriel gomes
 */

public class EditorasDAO extends Registros<Editora>{
    public EditorasDAO(){
        setSqlInsercao("INSERT INTO publisher(publisher_name, street_name, state_name, country_name) VALUES(?, ?, ?, ?)");
        setSqlAtualiza("UPDATE publisher SET publisher_name = ? street_name = ? state_name = ?, country_name = ? WHERE publisher_id = ?");
        setSqlExclusao("DELETE FROM publisher WHERE publisher_id = ?");
        setSqlBusca("SELECT * FROM publisher WHERE publisher_id = ?");
        setSqlBuscaTodos("SELECT * FROM publisher");
        setSqlBuscaNome("SELECT * FROM publisher WHERE publisher_name = ?");
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Editora e) throws SQLException{
        ps.setString(1, e.getNome());
        ps.setString(2, e.getRua());
        ps.setString(3, e.getEstado());
        ps.setString(4, e.getPais());
    }
    
    @Override
    protected void preencherAlteracao(PreparedStatement ps, Editora e) throws SQLException {
        ps.setString(1, e.getNome());
        ps.setString(2, e.getRua());
        ps.setString(3, e.getEstado());
        ps.setString(4, e.getPais());
    }
    
    
    @Override
    protected void preencherExclusao(PreparedStatement ps, Editora e) throws SQLException {
        ps.setInt(1, e.getId());
        
    }
    
    @Override
    protected void preencherBusca(PreparedStatement ps, Editora e) throws SQLException {
        ps.setInt(1, e.getId());
    }
    
    @Override
    protected Editora preencher(ResultSet rs) throws SQLException {
        Editora tempEditora = new Editora();
        tempEditora.setNome(rs.getString("publisher_name"));
        tempEditora.setId(rs.getInt("publisher_id"));
        tempEditora.setRua(rs.getString("street_name"));
        tempEditora.setEstado(rs.getString("state_name"));
        tempEditora.setPais(rs.getString("country_name"));
        return tempEditora;
    }
    
    @Override
    protected void preencherBuscaNome(PreparedStatement ps, Editora e) throws SQLException {
        ps.setString(1, e.getNome());
    }
    
    @Override
    protected Collection<Editora> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Editora> editoras = new ArrayList<Editora>();
        while(rs.next()){
            Editora tempEditora = new Editora();
            tempEditora.setNome(rs.getString("publisher_name"));
            tempEditora.setId(rs.getInt("publisher_id"));
            tempEditora.setRua(rs.getString("street_name"));
            tempEditora.setEstado(rs.getString("state_name"));
            tempEditora.setPais(rs.getString("country_name"));
            editoras.add(tempEditora);
        }
        
        return editoras;
    }
}
