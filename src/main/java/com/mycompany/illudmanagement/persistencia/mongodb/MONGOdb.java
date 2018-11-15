/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mongodb;

/**
 *
 * @author Otavio
 */
public class MONGOdb {
    
    static final String SERVER_NAME = "localhost";
    static final String DATABASE = "illud_prototype";
    static final String TIMEZONE = "?useTimezone=true&serverTimezone=UTC";
    static final String URL_CONEXAO = "mongodb://" + SERVER_NAME + "/" + DATABASE + TIMEZONE;
    static final String COLLECTION = "books";
}
