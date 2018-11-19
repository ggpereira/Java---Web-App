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
    @Path("/postAtualizaDado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAtualizaLivro(Livro livro){
        String result = "{\"Atualizado\":\""+ livro +"\"}";
        Armazenamento.atualizarLivro(livro);
        return Response.status(201).entity(result).build();
    }
    
    @POST
    @Path("/deletaLivro/{livroId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletaLivro(@PathParam("livroId") String livroCodigo){
            String result = "{\"Deletado\":\""+ livroCodigo +"\"}";
            Livro livro = new Livro();
            livro.setCodigo(livroCodigo);
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
        
        System.out.println(livro);
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
    
    @GET
    @Path("/busca/{livroId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLivroId(@PathParam("livroId") String livroId) {
        Livro lv_param = new Livro();
        lv_param.setCodigo(livroId);
        Livro resp_livro = Armazenamento.buscarLivroId(lv_param);
        Response response = Response.ok(resp_livro).build();
        return response;
    }
    
    @POST
    @Path("/switchdb/{dbmode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response switchDatabase(@PathParam("dbmode") String dbmode) {        
        String result ="{\"DbMode\":\""+ Armazenamento.toggleStorageMode(dbmode) +"\"}";
        Response response = Response.ok(result).build();
        return response;
    }
}
