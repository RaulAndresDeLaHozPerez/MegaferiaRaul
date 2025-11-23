/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.entities.Stand;
import com.megafair.model.repositories.StandRepository;
import com.megafair.util.Response;
import com.megafair.util.Validator;

public class StandController {

    private final StandRepository repo;

    public StandController(StandRepository repo) {
        this.repo = repo;
    }

    public Response<Stand> crearStand(long id, String nombre, double precio) {

        if (!Validator.validId(id))
            return new Response<>(Response.ERROR, "ID inválido", null);

        if (repo.exists(id))
            return new Response<>(Response.ERROR, "ID duplicado", null);

        if (!Validator.notEmpty(nombre))
            return new Response<>(Response.ERROR, "Nombre vacío", null);

        if (!Validator.positive(precio))
            return new Response<>(Response.ERROR, "Precio debe ser mayor que 0", null);

        Stand s = new Stand(id, precio);

        repo.add(s);

        return new Response<>(Response.OK, "Stand creado", s.clone());
    }

    public Response<java.util.List<Stand>> obtenerStands() {
        return new Response<>(Response.OK, "OK", repo.getAllOrdered());
    }
}


