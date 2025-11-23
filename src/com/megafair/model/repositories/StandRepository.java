/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.repositories;

import com.megafair.model.entities.Stand;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StandRepository {

    private final Map<Long, Stand> stands = new TreeMap<>();

    public boolean exists(long id) {
        return stands.containsKey(id);
    }

    public void save(Stand stand) {
        stands.put(stand.getId(), stand);
    }

    public Stand find(long id) {
        return stands.get(id);
    }

    public List<Stand> getAll() {
        return new ArrayList<>(stands.values());
    }
}





