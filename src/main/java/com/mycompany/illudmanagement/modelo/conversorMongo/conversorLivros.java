/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo.conversorMongo;
import com.google.gson.Gson;
import com.mycompany.illudmanagement.modelo.Livro;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class conversorLivros {

    public Document converterDocumento(Livro l){
        Gson gson = new Gson();
        Document doc = Document.parse(gson.toJson(l));
        return doc;
    }
    
    public Livro converterRegistro(Document doc){
        Livro l =  new Livro();
        if(doc.get("codigo") != null)
            l.setCodigo((int) doc.get("codigo"));
        l.setTitulo((String) doc.get("titulo"));
        l.setBarcode((String) doc.get("barcode"));
        l.setAno((int) doc.get("ano"));
        l.setEditora(new conversorEditoras().converterRegistro(doc));
        l.setAutor(new conversorAutores().converterRegistro(doc));
        return l;
    }
}
