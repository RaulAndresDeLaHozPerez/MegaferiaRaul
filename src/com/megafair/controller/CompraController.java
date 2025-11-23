/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.controller;

import com.megafair.model.repositories.EditorialRepository;
import com.megafair.model.repositories.StandRepository;
import com.megafair.util.*;
import java.util.*;

public class CompraController {

    private final StandRepository standRepo;
    private final EditorialRepository editorialRepo;

    public CompraController(StandRepository standRepo, EditorialRepository editorialRepo) {
        this.standRepo = standRepo;
        this.editorialRepo = editorialRepo;
    }

    public Response<Void> comprar(List<Long> idsStands, List<String> nitsEditoriales) {

        if (idsStands.size() != nitsEditoriales.size())
            return new Response<>(Response.ERROR, "Listas desbalanceadas", null);

        Set<Long> usadosStands = new HashSet<>();
        for (Long id : idsStands) {
            if (usadosStands.contains(id))
                return new Response<>(Response.ERROR, "Stands repetidos", null);
            usadosStands.add(id);

            if (!standRepo.exists(id))
                return new Response<>(Response.ERROR, "Stand inválido", null);
        }

        Set<String> usadasEditoriales = new HashSet<>();
        for (String nit : nitsEditoriales) {
            if (usadasEditoriales.contains(nit))
                return new Response<>(Response.ERROR, "Editoriales repetidas", null);
            usadasEditoriales.add(nit);

            if (!editorialRepo.exists(nit))
                return new Response<>(Response.ERROR, "Editorial inválida", null);
        }

        return new Response<>(Response.OK, "Compra registrada", null);
    }
}



