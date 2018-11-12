/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.controle;

import com.mycompany.illudmanagement.modelo.*;

import com.mycompany.illudmanagement.persistencia.mysql.daos.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel gomes
 */


public class InsertLivroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Autor aut = new Autor();
        aut.setNome(request.getParameter("author").toLowerCase());
        aut.setNacionalidade(request.getParameter("nacionalidade"));
        
        Editora edit = new Editora();
        edit.setNome(request.getParameter("publisher_name").toLowerCase());
        edit.setRua(request.getParameter("street_name").toLowerCase());
        edit.setEstado(request.getParameter("state_name").toLowerCase());
        edit.setPais(request.getParameter("country").toLowerCase());
        
        Livro liv = new Livro();
        liv.setTitulo(request.getParameter("title").toLowerCase());
        liv.setBarcode(request.getParameter("barcode").toLowerCase());
        liv.setAno(Integer.parseInt(request.getParameter("year")));
        liv.setAutor(aut);
        liv.setEditora(edit);
        
        Armazenamento.inserirLivro(liv);
        
        response.sendRedirect("index.jsp");
    }

   
}
