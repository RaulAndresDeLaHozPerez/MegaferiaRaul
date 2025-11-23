/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.entities.Persona;
import com.megafair.model.entities.Narrador;
import com.megafair.model.entities.LibroImpreso;
import com.megafair.model.entities.LibroDigital;
import com.megafair.model.entities.Libro;
import com.megafair.model.entities.Editorial;
import com.megafair.model.entities.Autor;
import com.megafair.model.entities.Audiolibro;
import com.megafair.model.repositories.EditorialRepository;
import com.megafair.model.repositories.LibroRepository;
import com.megafair.model.repository.PersonaRepository;
import com.megafair.util.*;
import java.util.*;

public class LibroController {

    private final LibroRepository libroRepo;
    private final PersonaRepository personaRepo;
    private final EditorialRepository editorialRepo;

    public LibroController(LibroRepository libroRepo, PersonaRepository personaRepo, EditorialRepository editorialRepo) {
        this.libroRepo = libroRepo;
        this.personaRepo = personaRepo;
        this.editorialRepo = editorialRepo;
    }

    private List<Autor> obtenerAutores(List<Long> ids) {
        List<Autor> autores = new ArrayList<>();
        Set<Long> usados = new HashSet<>();

        for (Long id : ids) {
            Persona p = personaRepo.getById(id);
            if (p == null || !(p instanceof Autor)) return null;
            if (usados.contains(id)) return null;
            usados.add(id);
            autores.add((Autor) p);
        }
        return autores;
    }

    public Response<Libro> crearLibroImpreso(String isbn, String titulo, double valor, List<Long> idsAutores, String nitEditorial, int paginas) {

        if (!Validator.validIsbn(isbn))
            return new Response<>(Response.ERROR, "ISBN inválido", null);

        if (!Validator.notEmpty(titulo))
            return new Response<>(Response.ERROR, "Título vacío", null);

        if (!Validator.positive(valor))
            return new Response<>(Response.ERROR, "Valor inválido", null);

        if (libroRepo.exists(isbn))
            return new Response<>(Response.ERROR, "ISBN duplicado", null);

        Editorial editorial = editorialRepo.getByNit(nitEditorial);
        if (editorial == null)
            return new Response<>(Response.ERROR, "Editorial inválida", null);

        List<Autor> autores = obtenerAutores(idsAutores);
        if (autores == null)
            return new Response<>(Response.ERROR, "Autores inválidos o repetidos", null);

        LibroImpreso libro = new LibroImpreso(isbn, titulo, valor, autores, editorial, paginas);
        libroRepo.add(libro);

        return new Response<>(Response.OK, "Libro impreso creado", libro.clone());
    }

    public Response<Libro> crearLibroDigital(String isbn, String titulo, double valor, List<Long> idsAutores, String nitEditorial, String enlace) {

        if (!Validator.validIsbn(isbn))
            return new Response<>(Response.ERROR, "ISBN inválido", null);

        if (!Validator.notEmpty(titulo))
            return new Response<>(Response.ERROR, "Título vacío", null);

        if (!Validator.positive(valor))
            return new Response<>(Response.ERROR, "Valor inválido", null);

        if (libroRepo.exists(isbn))
            return new Response<>(Response.ERROR, "ISBN duplicado", null);

        Editorial editorial = editorialRepo.getByNit(nitEditorial);
        if (editorial == null)
            return new Response<>(Response.ERROR, "Editorial inválida", null);

        List<Autor> autores = obtenerAutores(idsAutores);
        if (autores == null)
            return new Response<>(Response.ERROR, "Autores inválidos", null);

        LibroDigital libro = new LibroDigital(isbn, titulo, valor, autores, editorial, enlace);
        libroRepo.add(libro);

        return new Response<>(Response.OK, "Libro digital creado", libro.clone());
    }

    public Response<Libro> crearAudiolibro(String isbn, String titulo, double valor, List<Long> idsAutores, String nitEditorial, long idNarrador, double duracion) {

        if (!Validator.validIsbn(isbn))
            return new Response<>(Response.ERROR, "ISBN inválido", null);

        if (!Validator.notEmpty(titulo))
            return new Response<>(Response.ERROR, "Título vacío", null);

        if (!Validator.positive(valor))
            return new Response<>(Response.ERROR, "Valor inválido", null);

        if (libroRepo.exists(isbn))
            return new Response<>(Response.ERROR, "ISBN duplicado", null);

        Editorial editorial = editorialRepo.getByNit(nitEditorial);
        if (editorial == null)
            return new Response<>(Response.ERROR, "Editorial inválida", null);

        List<Autor> autores = obtenerAutores(idsAutores);
        if (autores == null)
            return new Response<>(Response.ERROR, "Autores inválidos", null);

        if (!Validator.positive(duracion))
            return new Response<>(Response.ERROR, "Duración inválida", null);

        Persona p = personaRepo.getById(idNarrador);
        if (p == null || !(p instanceof Narrador))
            return new Response<>(Response.ERROR, "Narrador inválido", null);

        Narrador narrador = (Narrador) p;

        Audiolibro libro = new Audiolibro(isbn, titulo, valor, autores, editorial, narrador, duracion);
        libroRepo.add(libro);

        return new Response<>(Response.OK, "Audiolibro creado", libro.clone());
    }

    public Response<List<Libro>> obtenerLibros() {
        return new Response<>(Response.OK, "OK", libroRepo.getAllOrdered());
    }
}


