/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.illudmanagement.modelo;
import persistencia.Registro;

/**
 *
 * @author gabriel gomes 
 */
public class Livro extends Registro{
    private int codigo;
    private String titulo;
    private int barcode;
    private int ano;
    private Editora editora = new Editora();
    private Autor autor = new Autor();
    
    public Livro(){} //construtor padrão
    public Livro(String titulo, int barcode, int ano, Editora editora, Autor autor){
        this.titulo = titulo;
        this.barcode = barcode;
        this.ano = ano;
        this.editora = editora;
        this.autor = autor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public Autor getAutor() {
        return autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getBarcode() {
        return barcode;
    }

    public int getAno() {
        return ano;
    }

    public Editora getEditora() {
        return editora;
    }
}
