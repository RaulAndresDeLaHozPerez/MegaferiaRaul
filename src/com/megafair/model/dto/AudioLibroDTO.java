/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.dto;

import java.util.List;

public class AudioLibroDTO extends LibroDTO {

    public long idNarrador;

    public AudioLibroDTO(String isbn, String titulo, double precio, 
                         String nitEditorial, List<Long> autoresIds,
                         long idNarrador) {
        super(isbn, titulo, precio, nitEditorial, autoresIds);
        this.idNarrador = idNarrador;
    }
}

