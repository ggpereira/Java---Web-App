/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo.conversorMongo;

import com.google.gson.Gson;
import com.mycompany.illudmanagement.modelo.Autor;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class conversorAutores {
    public Document converterDocumento(Autor a){
        Gson gson = new Gson();
        Document doc = Document.parse(gson.toJson(a));
        return doc;
    }
    
    public Autor converterRegistro(Document doc){
        Autor a =  new Autor();
        if(doc.get("id") != null)
            a.setId((int) doc.get("id"));
        a.setNome((String) doc.get("nome"));
        a.setNacionalidade((String) doc.get("nacionalidade"));
        return a;
    }
}
