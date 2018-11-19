/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class ConexaoMONGODB {
    private static MongoClient mongoClient;
    private static ConexaoMONGODB instancia;
    
    private ConexaoMONGODB() {
        
    }
    
    public static synchronized ConexaoMONGODB getInstancia() {
        if (instancia == null)
            instancia = new ConexaoMONGODB();
        return instancia;
    }
    
    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = new MongoClient(new MongoClientURI(MONGOdb.URL_CONEXAO));
        }
        return mongoClient;
    }

    public static MongoDatabase getDB() {
        return getMongoClient().getDatabase(MONGOdb.DATABASE);
    }
    
    public static MongoCollection<Document> getUserCollection() {
        return getDB().getCollection(MONGOdb.COLLECTION);
    }
}
