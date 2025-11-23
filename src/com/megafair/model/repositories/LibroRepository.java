/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.repositories;
import com.megafair.model.entities.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LibroRepository {

    private final Map<String, Libro> libros = new TreeMap<>();

    public boolean exists(String isbn) {
        return libros.containsKey(isbn);
    }

    public void save(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    public Libro find(String isbn) {
        return libros.get(isbn);
    }

    public List<Libro> getAll() {
        return new ArrayList<>(libros.values());
    }
}



