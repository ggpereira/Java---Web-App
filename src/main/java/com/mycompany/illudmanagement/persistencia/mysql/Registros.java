/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.mysql;

import persistencia.Registro;
import persistencia.DAO;
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
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void inserir(T t){
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlInsercao());
            preencherInsercao(ps, t);
            ps.execute();
            ps.close();
            conexao.close();
        } catch(SQLException e){
            System.out.println("Erro ao inserir objeto!");
            e.printStackTrace();
        }
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

    protected abstract T preencher(ResultSet rs) throws SQLException;

    protected abstract Collection<T> preencherColecao(ResultSet rs) throws SQLException;
}
