/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.dto;

import java.util.List;

public class LibroImpresoDTO extends LibroDTO {

    public int paginas;

    public LibroImpresoDTO(String isbn, String titulo, double precio, 
                           String nitEditorial, List<Long> autoresIds,
                           int paginas) {
        super(isbn, titulo, precio, nitEditorial, autoresIds);
        this.paginas = paginas;
    }
}

