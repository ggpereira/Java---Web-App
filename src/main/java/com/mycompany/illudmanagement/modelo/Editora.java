/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo;
import com.mycompany.illudmanagement.persistencia.Registro;

/**
 *
 * @author gabriel gomes
 */
public class Editora extends Registro {
    private int id;
    private String nome;
    private String rua;
    private String cidade;
    private String pais;
    
    public Editora(){} //Construtor padrão
    
    public Editora(String nome, String rua, String cidade, String pais){
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
