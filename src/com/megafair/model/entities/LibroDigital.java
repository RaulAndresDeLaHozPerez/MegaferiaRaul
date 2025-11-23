/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

import java.util.List;

public class LibroDigital extends Libro {

    private String url;

    public LibroDigital(String isbn, String titulo, double precio,
                        Editorial editorial, List<Autor> autores,
                        String url) {
        super(isbn, titulo, precio, editorial, autores);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}



