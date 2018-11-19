/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mongodb;
import com.mycompany.illudmanagement.modelo.Livro;
import com.mycompany.illudmanagement.modelo.conversorMongo.conversorLivros;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class LivrosDAOMongo extends DAODocumentos<Livro> {
    
    @Override
    protected String getDocumentId(Livro e) {
        return Integer.toString(e.getCodigo());
    }
    
    @Override
    protected Document transformarDocumento(Livro e) {
        return new conversorLivros().converterDocumento(e);
    }

    @Override
    protected Livro transformarRegistro(Document doc) {
        return new conversorLivros().converterRegistro(doc);
    }

    @Override
    public Livro buscarNome(Livro t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}