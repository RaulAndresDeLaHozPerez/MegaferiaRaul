/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

import java.util.List;

public class AudioLibro extends Libro {

    private Narrador narrador;

    public AudioLibro(String isbn, String titulo, double precio,
                      Editorial editorial, List<Autor> autores,
                      Narrador narrador) {
        super(isbn, titulo, precio, editorial, autores);
        this.narrador = narrador;
    }

    public Narrador getNarrador() {
        return narrador;
    }
}




