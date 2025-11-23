/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.repositories;

import com.megafair.model.entities.Editorial;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EditorialRepository {

    private final Map<String, Editorial> editoriales = new TreeMap<>();

    public boolean exists(String nit) {
        return editoriales.containsKey(nit);
    }

    public void save(Editorial editorial) {
        editoriales.put(editorial.getNit(), editorial);
    }

    public Editorial find(String nit) {
        return editoriales.get(nit);
    }

    public List<Editorial> getAll() {
        return new ArrayList<>(editoriales.values());
    }
}



