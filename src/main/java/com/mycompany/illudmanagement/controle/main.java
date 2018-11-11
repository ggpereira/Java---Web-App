/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;
import com.mycompany.illudmanagement.modelo.Autor;
import com.mycompany.illudmanagement.persistencia.mysql.daos.AutoresDAO;

/**
 *
 * @author gabri
 */
public class main {
    public static void main(String[] args) {
        Autor a = new Autor();
        a.setNacionalidade("Brasil");
        a.setNome("Stark");
        
        AutoresDAO adao = new AutoresDAO();
        int valor = adao.inserir(a);
        
        System.out.println("Valor da chave gerada " + valor);
        
    }
}
