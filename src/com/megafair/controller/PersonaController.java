/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.entities.Persona;
import com.megafair.model.entities.Narrador;
import com.megafair.model.entities.Gerente;
import com.megafair.model.entities.Autor;
import com.megafair.model.repository.PersonaRepository;
import com.megafair.util.*;
import java.util.List;

public class PersonaController {

    private final PersonaRepository personaRepo;

    public PersonaController(PersonaRepository personaRepo) {
        this.personaRepo = personaRepo;
    }

    private Response<Persona> validar(long id, String nombre) {
        if (!Validator.validId(id))
            return new Response<>(Response.ERROR, "ID inválido", null);

        if (!Validator.notEmpty(nombre))
            return new Response<>(Response.ERROR, "Nombre vacío", null);

        if (personaRepo.exists(id))
            return new Response<>(Response.ERROR, "ID duplicado", null);

        return null;
    }

    public Response<Autor> crearAutor(long id, String nombre) {
        Response<Persona> r = validar(id, nombre);
        if (r != null) return new Response<>(Response.ERROR, r.getMessage(), null);
        Autor a = new Autor(id, nombre);
        personaRepo.add(a);
        return new Response<>(Response.OK, "Autor creado", a.clone());
    }

    public Response<Gerente> crearGerente(long id, String nombre) {
        Response<Persona> r = validar(id, nombre);
        if (r != null) return new Response<>(Response.ERROR, r.getMessage(), null);
        Gerente g = new Gerente(id, nombre);
        personaRepo.add(g);
        return new Response<>(Response.OK, "Gerente creado", g.clone());
    }

    public Response<Narrador> crearNarrador(long id, String nombre) {
        Response<Persona> r = validar(id, nombre);
        if (r != null) return new Response<>(Response.ERROR, r.getMessage(), null);
        Narrador n = new Narrador(id, nombre);
        personaRepo.add(n);
        return new Response<>(Response.OK, "Narrador creado", n.clone());
    }

    public Response<List<Persona>> obtenerPersonas() {
        return new Response<>(Response.OK, "OK", personaRepo.getAllOrdered());
    }

    public Response<List<Autor>> obtenerAutores() {
        return new Response<>(Response.OK, "OK", personaRepo.getAutores());
    }

    public Response<List<Gerente>> obtenerGerentes() {
        return new Response<>(Response.OK, "OK", personaRepo.getGerentes());
    }

    public Response<List<Narrador>> obtenerNarradores() {
        return new Response<>(Response.OK, "OK", personaRepo.getNarradores());
    }
}


