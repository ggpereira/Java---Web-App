/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;

import com.mycompany.illudmanagement.modelo.Autor;
import com.mycompany.illudmanagement.modelo.Editora;
import com.mycompany.illudmanagement.modelo.Livro;

import com.mycompany.illudmanagement.persistencia.mysql.daos.AutoresDAO;
import com.mycompany.illudmanagement.persistencia.mysql.daos.EditorasDAO;
import com.mycompany.illudmanagement.persistencia.mysql.daos.LivrosDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel gomes
 */

@WebServlet(name="LivroServlet", urlPatterns={"/LivroServlet"})
public class LivroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Autor aut = new Autor();
        
        
    }

   
}
