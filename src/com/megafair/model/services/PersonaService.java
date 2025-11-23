/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.services;

import com.megafair.model.entities.Autor;
import com.megafair.model.entities.Gerente;
import com.megafair.model.entities.Narrador;
import com.megafair.model.repositories.PersonaRepository;

public class PersonaService {

    private final PersonaRepository repo;

    public PersonaService(PersonaRepository repo) {
        this.repo = repo;
    }

    public Autor crearAutor(long id, String nombre, String nacionalidad) {

        validarPersona(id, nombre, nacionalidad);

        if (repo.exists(id))
            throw new IllegalArgumentException("El ID ya existe.");

        Autor autor = new Autor(id, nombre, nacionalidad);
        repo.save(autor);
        return autor;
    }

    public Gerente crearGerente(long id, String nombre, String nacionalidad) {

        validarPersona(id, nombre, nacionalidad);

        if (repo.exists(id))
            throw new IllegalArgumentException("El ID ya existe.");

        Gerente gerente = new Gerente(id, nombre, nacionalidad);
        repo.save(gerente);
        return gerente;
    }

    public Narrador crearNarrador(long id, String nombre, String nacionalidad) {

        validarPersona(id, nombre, nacionalidad);

        if (repo.exists(id))
            throw new IllegalArgumentException("El ID ya existe.");

        Narrador narrador = new Narrador(id, nombre, nacionalidad);
        repo.save(narrador);
        return narrador;
    }

    private void validarPersona(long id, String nombre, String nacionalidad) {

        if (id < 0 || String.valueOf(id).length() > 15)
            throw new IllegalArgumentException("ID inválido.");

        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre vacío.");

        if (nacionalidad == null || nacionalidad.isBlank())
            throw new IllegalArgumentException("Nacionalidad vacía.");
    }
}

