/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.dto;

import java.util.List;

public class LibroDTO {
    public String isbn;
    public String titulo;
    public double precio;
    public String nitEditorial;
    public List<Long> autoresIds;   // IDs de autores

    public LibroDTO(String isbn, String titulo, double precio, 
                    String nitEditorial, List<Long> autoresIds) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.nitEditorial = nitEditorial;
        this.autoresIds = autoresIds;
    }
}

