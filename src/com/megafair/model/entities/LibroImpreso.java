/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

import java.util.List;

public class LibroImpreso extends Libro {

    private int paginas;

    public LibroImpreso(String isbn, String titulo, double precio,
                        Editorial editorial, List<Autor> autores,
                        int paginas) {
        super(isbn, titulo, precio, editorial, autores);
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }
}



