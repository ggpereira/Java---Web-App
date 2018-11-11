/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gabriel gomes
 */
public class Conexao {
    public static String status = "Não conectado";
    
    public static java.sql.Connection getConexao(){
        Connection conexao = null;
        
        try{
            Class.forName(MYSQLdb.JDBC_DRIVER);
            System.out.println("Conectando em.... " + MYSQLdb.URL_CONEXAO);
            conexao = DriverManager.getConnection(MYSQLdb.URL_CONEXAO, MYSQLdb.USUARIO, MYSQLdb.SENHA);
            
            if(conexao != null){
                status = ("STATUS---->Conexão bem sucedida!");
            } else {
                status = ("STATUS---->Ocorreu uma falha ao conectar!");
            }
        }catch(ClassNotFoundException e){
            System.out.println("O driver JDBC " + MYSQLdb.JDBC_DRIVER + " Não foi encontrado");
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a conexão com o banco de dados");
            System.out.println(e);
        }
        return conexao;
    }
    
    public static String conexaoStatus(){
        return status;
    }
    
    public static boolean fecharConexao() {
        try{
            getConexao().close();
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public static java.sql.Connection reiniciarConexao() {
        fecharConexao();
        
        return getConexao();
    }
}
