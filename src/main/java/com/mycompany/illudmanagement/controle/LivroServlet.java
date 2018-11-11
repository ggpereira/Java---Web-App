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
        aut.setNome(request.getParameter("author"));
        aut.setNacionalidade(request.getParameter("nacionalidade"));
        
        Editora edit = new Editora();
        edit.setNome(request.getParameter("publisher_name"));
        edit.setRua(request.getParameter("street_name"));
        edit.setEstado(request.getParameter("state_name"));
        edit.setPais(request.getParameter("country"));
        
        Livro liv = new Livro();
        liv.setTitulo(request.getParameter("title"));
        liv.setBarcode(Integer.parseInt(request.getParameter("barcode")));
        liv.setAno(Integer.parseInt(request.getParameter("year")));
        liv.setAutor(aut);
        liv.setEditora(edit);
        
        LivrosDAO lDao = new LivrosDAO();
        AutoresDAO aDao = new AutoresDAO();
        EditorasDAO eDao = new EditorasDAO();
        
        aDao.inserir(aut);
        
        System.out.println("Titulo: " + liv.getTitulo());
        System.out.println("Autor: " + liv.getAutor().getNome());
        System.out.println("Editora: " + liv.getEditora().getNome());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

   
}
