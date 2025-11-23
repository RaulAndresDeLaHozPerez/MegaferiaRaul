/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.entities.Persona;
import com.megafair.model.entities.Gerente;
import com.megafair.model.entities.Editorial;
import com.megafair.model.repositories.EditorialRepository;
import com.megafair.model.repository.PersonaRepository;
import com.megafair.util.*;
import java.util.List;

public class EditorialController {

    private final EditorialRepository editorialRepo;
    private final PersonaRepository personaRepo;

    public EditorialController(EditorialRepository editorialRepo, PersonaRepository personaRepo) {
        this.editorialRepo = editorialRepo;
        this.personaRepo = personaRepo;
    }

    public Response<Editorial> crearEditorial(String nit, String nombre, long idGerente) {

        if (!Validator.validNit(nit))
            return new Response<>(Response.ERROR, "NIT inválido", null);

        if (!Validator.notEmpty(nombre))
            return new Response<>(Response.ERROR, "Nombre vacío", null);

        if (editorialRepo.exists(nit))
            return new Response<>(Response.ERROR, "NIT duplicado", null);

        Persona p = personaRepo.getById(idGerente);
        if (p == null || !(p instanceof Gerente))
            return new Response<>(Response.ERROR, "Gerente inválido", null);

        Gerente g = (Gerente) p;

        Editorial e = new Editorial(nit, nombre, g);
        editorialRepo.add(e);

        return new Response<>(Response.OK, "Editorial creada", e.clone());
    }

    public Response<List<Editorial>> obtenerEditoriales() {
        return new Response<>(Response.OK, "OK", editorialRepo.getAllOrdered());
    }
}


