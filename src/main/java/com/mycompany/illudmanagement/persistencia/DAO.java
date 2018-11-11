/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.persistencia;

import java.util.Collection;

/**
 *
 * @author gabriel gomes
 * @param <T>
 */
public interface DAO <T extends Registro>{
     void inserir(T t);
     void deletar(T t);
     void modificar(T t);
     T buscar(T t);
     Collection<T> buscarTodos();
}
