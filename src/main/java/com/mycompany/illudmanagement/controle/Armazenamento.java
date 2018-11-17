/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;
import com.mycompany.illudmanagement.modelo.*;
import com.mycompany.illudmanagement.persistencia.mysql.daos.*;
import java.util.Collection;
import com.mycompany.illudmanagement.persistencia.DAO;

/**
 *
 * @author gabri
 */
public class Armazenamento {
    public static DAO daoLivros = new LivrosDAO();
    public static String storage_mode = "mysql";
    
    public static void inserirLivro(Livro liv) {
       daoLivros.inserir(liv);
    }
    
    public static Collection<Livro> buscarTodos() {
        return daoLivros.buscarTodos();
    }
    
    public static void atualizarLivro(Livro liv) {
        daoLivros.modificar(liv);
    }
    
    public static void deletarLivro(Livro liv) {
        daoLivros.deletar(liv);
    }
    
    public static Livro buscarLivroId(Livro liv) {
        return (Livro)daoLivros.buscar(liv);
    }
    
    public static Livro buscarLivroNome(Livro liv) {
        return (Livro)daoLivros.buscarNome(liv);
    }
    
    public static String toggleStorageMode(String mode) {

        switch(mode) {
            case "mysql": 
                daoLivros = new LivrosDAO();
                storage_mode = "mysql";
                break;
            case "mongodb": 
                //daoLivros = new Mongo
                storage_mode = "mongodb";
                break;
            default:
                System.out.println("Tentativa de opção incorreta");
        }
        return storage_mode;    
    }
    
    
}
