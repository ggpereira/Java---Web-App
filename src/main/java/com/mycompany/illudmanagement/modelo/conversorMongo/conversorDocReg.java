/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo.conversorMongo;

import org.bson.Document;

/**
 *
 * @author Otavio
 * @param <T>
 */
public abstract class conversorDocReg<T> {
    public abstract T converterModelo(Document doc);
    public abstract Document converterDocumento(T t);
}
