/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo.conversorMongo;

import com.google.gson.Gson;
import com.mycompany.illudmanagement.modelo.Editora;
import com.mycompany.illudmanagement.modelo.Livro;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class conversorEditoras {
    public Document converterDocumento(Livro l){
        Gson gson = new Gson();
        Document doc = Document.parse(gson.toJson(l));
        return doc;
    }
    
    public Editora converterRegistro(Document doc){
        Editora e =  new Editora();
        if(doc.get("id") != null)
            e.setId((int)doc.get("id"));
        e.setNome((String) doc.get("nome"));
        e.setRua((String) doc.get("rua"));
        e.setEstado((String) doc.get("estado"));
        e.setPais((String) doc.get("pais"));
        return e;
    }
}
