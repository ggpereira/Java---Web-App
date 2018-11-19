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
        Document aut = (Document) doc.get("autor");
        Autor a =  new Autor();
        a.setNome((String) aut.get("nome"));
        a.setNacionalidade((String) aut.get("nacionalidade"));
        return a;
    }
}
