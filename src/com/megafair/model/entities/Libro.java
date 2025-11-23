/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

import java.util.List;

public abstract class Libro {

    protected String isbn;
    protected String titulo;
    protected double precio;
    protected Editorial editorial;
    protected List<Autor> autores;

    public Libro(String isbn, String titulo, double precio,
                 Editorial editorial, List<Autor> autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autores = autores;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public Editorial getEditorial() { return editorial; }
    public List<Autor> getAutores() { return autores; }
}


