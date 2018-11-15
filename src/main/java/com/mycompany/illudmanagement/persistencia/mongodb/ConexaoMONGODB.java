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
import java.net.UnknownHostException;
import org.bson.Document;

/**
 *
 * @author Otavio
 */
public class ConexaoMONGODB {
    private static MongoClient mongoClient;
    
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
