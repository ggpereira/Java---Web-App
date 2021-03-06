/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mysql;

import com.mycompany.illudmanagement.persistencia.Registro;
import com.mycompany.illudmanagement.persistencia.DAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;

/**
 *
 * @author gabriel gomes
 * @param <T>
 */
public abstract class Registros <T extends Registro> implements DAO<T>{
    private String sqlInsercao;
    private String sqlAtualiza;
    private String sqlExclusao;
    private String sqlBusca;
    private String sqlBuscaTodos;
    private String sqlBuscaNome;

    public void setSqlInsercao(String sqlInsercao) {
        this.sqlInsercao = sqlInsercao;
    }

    public void setSqlAtualiza(String sqlAtualiza) {
        this.sqlAtualiza = sqlAtualiza;
    }

    public void setSqlExclusao(String sqlExclusao) {
        this.sqlExclusao = sqlExclusao;
    }

    public void setSqlBusca(String sqlBusca) {
        this.sqlBusca = sqlBusca;
    }

    public void setSqlBuscaTodos(String sqlBuscaTodos) {
        this.sqlBuscaTodos = sqlBuscaTodos;
    }
    
    public void setSqlBuscaNome(String sqlBuscaNome) {
        this.sqlBuscaNome = sqlBuscaNome;
    }

    public String getSqlInsercao() {
        return sqlInsercao;
    }

    public String getSqlAtualiza() {
        return sqlAtualiza;
    }

    public String getSqlExclusao() {
        return sqlExclusao;
    }

    public String getSqlBusca() {
        return sqlBusca;
    }

    public String getSqlBuscaTodos() {
        return sqlBuscaTodos;
    }
    
    public String getSqlBuscaNome() {
        return sqlBuscaNome;
    }
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public int inserir(T t){
        int chave = -1;
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlInsercao(), Statement.RETURN_GENERATED_KEYS);
            preencherInsercao(ps, t);
            ps.execute();
            
            ResultSet chaveGerada = ps.getGeneratedKeys();
            while(chaveGerada.next()) {
                chave = chaveGerada.getInt(1);
            }
            
            ps.close();
            conexao.close();
        } catch(SQLException e){
            System.out.println("Erro ao inserir objeto!");
            e.printStackTrace();
        }
        
        return chave;
    }
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void deletar(T t){
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlExclusao());
            preencherExclusao(ps, t);
            ps.execute();
            ps.close();
            conexao.close();
        } catch(SQLException e){
            System.out.println("Erro ao deletar objeto!");
            e.printStackTrace();
        }
    }
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void modificar(T t) {
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlAtualiza());
            preencherAlteracao(ps, t);
            ps.execute();
            conexao.close();
        } catch(SQLException e) {
            System.out.println("Erro ao modificar objeto!");
            e.printStackTrace();
        }
    }
    
    @Override
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace"})
    public T buscar(T t) {
        Connection conexao = Conexao.getConexao();
        T tempObj = null;
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlBusca());
            preencherBusca(ps, t);
            ResultSet rs = ps.executeQuery();
            tempObj = preencher(rs);
            rs.close();
            ps.close();
            conexao.close();
        } catch(SQLException e) {
            System.out.println("Erro ao buscar objeto!");
            e.printStackTrace();
        }
        
        return tempObj;
    }
    
    public T buscarNome(T t) {
        Connection conexao = Conexao.getConexao();
        T tempObj = null;
        
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlBuscaNome());
            preencherBuscaNome(ps, t);
            ResultSet rs = ps.executeQuery();
            tempObj = preencher(rs);
            rs.close();
            ps.close();
            conexao.close();
        } catch(SQLException e) {
            System.out.println("Erro ao buscar objeto!");
            e.printStackTrace();
        }
        
        return tempObj;
    }
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Collection<T> buscarTodos() {
        Connection conexao = Conexao.getConexao();
        try{
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery(getSqlBuscaTodos());
            Collection<T> registros = preencherColecao(rs);
            rs.close();
            conexao.close();
            return registros;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    protected abstract void preencherInsercao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherAlteracao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherExclusao(PreparedStatement ps, T t) throws SQLException;
    
    protected abstract void preencherBusca(PreparedStatement ps, T t) throws SQLException;
    
    protected abstract void preencherBuscaNome(PreparedStatement ps, T t) throws SQLException;

    protected abstract T preencher(ResultSet rs) throws SQLException;

    protected abstract Collection<T> preencherColecao(ResultSet rs) throws SQLException;
}  
