/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.dto;

import java.util.List;

public class LibroDigitalDTO extends LibroDTO {

    public String url;

    public LibroDigitalDTO(String isbn, String titulo, double precio, 
                           String nitEditorial, List<Long> autoresIds,
                           String url) {
        super(isbn, titulo, precio, nitEditorial, autoresIds);
        this.url = url;
    }
}

