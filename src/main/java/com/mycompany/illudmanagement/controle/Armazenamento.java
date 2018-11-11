/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;
import com.mycompany.illudmanagement.modelo.*;
import com.mycompany.illudmanagement.persistencia.mysql.daos.*;

/**
 *
 * @author gabri
 */
public class Armazenamento {
    public static String storage_mode = "mysql";
    public static LivrosDAO LivrosDAOmysql = new LivrosDAO(); 
    // public static mongodb ....... 
    
    public static void inserirLivro(Livro liv) {
        if(storage_mode == "mysql") {
            
        } else {
            
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
