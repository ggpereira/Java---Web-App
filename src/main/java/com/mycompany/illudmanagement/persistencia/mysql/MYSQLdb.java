/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia.mysql;

/**
 *
 * @author gabriel gomes
 */
public class MYSQLdb {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String USUARIO = "root";
    static final String SENHA = "1234";
    static final String SERVER_NAME = "localhost";
    static final String DATABASE = "illud_prototype";
    static final String TIMEZONE = "?useTimezone=true&serverTimezone=UTC";
    static final String SLL = "&useSSL=false";
    static final String URL_CONEXAO = "jdbc:mysql://" + SERVER_NAME + "/" + DATABASE + TIMEZONE + SLL;
}
