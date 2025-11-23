/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.repositories;

import com.megafair.model.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PersonaRepository {

    private final Map<Long, Persona> personas = new TreeMap<>();

    public boolean exists(long id) {
        return personas.containsKey(id);
    }

    public void save(Persona persona) {
        personas.put(persona.getId(), persona);
    }

    public Persona find(long id) {
        return personas.get(id);
    }

    public List<Persona> getAll() {
        return new ArrayList<>(personas.values());
    }
}



