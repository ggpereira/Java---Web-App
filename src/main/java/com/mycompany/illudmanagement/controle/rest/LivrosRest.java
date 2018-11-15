package com.mycompany.illudmanagement.controle.rest;

import com.mycompany.illudmanagement.controle.Armazenamento;
import com.mycompany.illudmanagement.modelo.Livro;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/livros")
public class LivrosRest {
    
    @GET
    @Path("/getLivros")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Livro> getLivros() {
        Collection<Livro> livros = Armazenamento.buscarTodos();
        
        return livros;
    }
    
    @POST
    @Path("/getAtualizaDado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAtualizaLivro(Livro livro){
        String result = "{\"Atualizado\":\""+ livro +"\"}";
        Armazenamento.atualizarLivro(livro);
        return Response.status(201).entity(result).build();
    }
    
    @POST
    @Path("/deletaLivro")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletaLivro(Livro livro){
        String result = "Deletado " + livro;
        Armazenamento.deletarLivro(livro);
        return Response.status(201).entity(result).build();
    }
    
    @GET
    @Path("{livroNome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLivroNome(@PathParam("livroNome") String livroNome) {
        Livro lv_param = new Livro();
        lv_param.setTitulo(livroNome);
        Livro resp_livro = Armazenamento.buscarLivroNome(lv_param);
        Response response = Response.ok(resp_livro).build();
        
        return response;
    }
    
    @POST
    @Path("/postLivros")
    public Response postGravarLivro(Livro livro) {
        String result = "Gravado: " + livro;
        Armazenamento.inserirLivro(livro);
        return Response.status(201).entity(result).build();
    }
    
    @GET
    @Path("/storageMode")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStorageMode() {
        return "{\"DbMode\":\""+Armazenamento.storage_mode +"\"}";
    }
}
