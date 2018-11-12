
package com.mycompany.illudmanagement.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.ArrayList;
import com.mycompany.illudmanagement.modelo.Livro;

/**
 *
 * @author gabriel gomes
 */
public class ListarLivroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Collection<Livro> livros = new ArrayList<Livro>();
        livros = Armazenamento.buscarTodos();
        
        request.setAttribute("livros", livros);
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
