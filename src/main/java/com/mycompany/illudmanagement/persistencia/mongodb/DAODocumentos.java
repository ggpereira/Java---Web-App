/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mongodb;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mycompany.illudmanagement.persistencia.Registro;
import com.mycompany.illudmanagement.persistencia.DAO;

/**
 *
 * @author Otavio
 * @param <T>
 */
public abstract class DAODocumentos <T extends Registro> implements DAO<T> {
   
    private final MongoCollection<Document> collection;

    public DAODocumentos() {
        this.collection = ConexaoMONGODB.getUserCollection();
    }

    /**
     *
     * @param t
     * @return 
     */
    @SuppressWarnings("CallToPrintStackTrace")
    @Override
    public int inserir(T t) {
        Document doc = transformarDocumento(t);
        collection.insertOne(doc);
        return 1;
    }

    @Override
    public void modificar(T t) {
        Document doc = transformarDocumento(t);
        String documentId = getDocumentId(t);
        collection.updateOne(eq( "_id", new ObjectId(documentId)), new Document("$set", doc));
    }

    @Override
    public void deletar(T t) {
        String documentId = getDocumentId(t);
        collection.deleteOne( eq("_id",  new ObjectId(documentId)) );       
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public T buscar(T t) {
        Collection<T> registros = new ArrayList<>();
        String documentId = getDocumentId(t);
        for (Document cur : collection.find( eq("_id", new ObjectId(documentId))) )
            registros.add( transformarRegistro(cur) );
        return (T) registros;
    }

    public T buscar(String id) {
        T registro = null;
        for (Document cur : collection.find( eq("_id", new ObjectId(id)) ))
            registro = transformarRegistro(cur);
        return registro;
    }

    @Override
    public Collection<T> buscarTodos() {
        Collection<T> registros = new ArrayList<>();
        for (Document cur : collection.find())
            registros.add( transformarRegistro(cur) );
        return registros;
    }

    protected abstract String getDocumentId(T t);
    protected abstract Document transformarDocumento(T t);
    protected abstract T transformarRegistro(Document doc);
}
