/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;
import com.mycompany.illudmanagement.modelo.*;
import com.mycompany.illudmanagement.persistencia.mysql.daos.*;
import java.util.Collection;

/**
 *
 * @author gabri
 */
public class Armazenamento {
    public static String storage_mode = "mysql";
    public static LivrosDAO livrosDAOmysql = new LivrosDAO(); 
    // public static mongodb ....... 
    
    public static void inserirLivro(Livro liv) {
        if(storage_mode == "mysql") {
            livrosDAOmysql.inserir(liv);
        } else {
            //aqui vai o insert do mongodb
        }
    }
    
    public static Collection<Livro> buscarTodos() {
        if(storage_mode == "mysql") {
            return livrosDAOmysql.buscarTodos();
        } else {
            //aqui vai o buscar do mongodb
            return null;
        }
    }
    
    public static void toggleStorageMode(String mode) {
        
        //default
        if(!"mysql".equals(mode) && !"mongodb".equals(mode)) {
            storage_mode = "mysql";
           
        } else {
            storage_mode = mode;
        } 
            
    }
    
    
}
