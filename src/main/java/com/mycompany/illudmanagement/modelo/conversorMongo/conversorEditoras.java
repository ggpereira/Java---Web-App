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
        Document edit = (Document) doc.get("editora");
        Editora e =  new Editora();
        e.setNome((String) edit.get("nome"));
        e.setRua((String) edit.get("rua"));
        e.setCidade((String) edit.get("cidade"));
        e.setPais((String) edit.get("pais"));
        return e;
    }
}
