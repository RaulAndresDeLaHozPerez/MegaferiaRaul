/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.entities.Persona;
import com.megafair.model.entities.Libro;
import com.megafair.model.entities.Autor;
import com.megafair.model.repositories.LibroRepository;
import com.megafair.model.repository.PersonaRepository;
import com.megafair.util.*;
import java.util.*;

public class ConsultaController {

    private final LibroRepository libroRepo;
    private final PersonaRepository personaRepo;

    public ConsultaController(LibroRepository libroRepo, PersonaRepository personaRepo) {
        this.libroRepo = libroRepo;
        this.personaRepo = personaRepo;
    }

    public Response<List<Libro>> buscarPorAutor(long idAutor) {
        Persona p = personaRepo.getById(idAutor);
        if (p == null || !(p instanceof Autor))
            return new Response<>(Response.ERROR, "Autor inválido", null);

        List<Libro> resultado = libroRepo.buscarPorAutor(idAutor);
        return new Response<>(Response.OK, "OK", resultado);
    }

    public Response<List<Libro>> buscarPorFormato(String formato) {
        List<Libro> r = libroRepo.buscarPorFormato(formato);
        return new Response<>(Response.OK, "OK", r);
    }

    public Response<List<Autor>> autoresConMasEditoriales() {
        List<Autor> r = libroRepo.autoresConMasEditoriales();
        return new Response<>(Response.OK, "OK", r);
    }
}

