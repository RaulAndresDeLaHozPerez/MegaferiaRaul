/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.dto;

public class EditorialDTO {
    public String nit;
    public String nombre;
    public long idGerente;     // solo el ID, no el objeto gerente completo

    public EditorialDTO(String nit, String nombre, long idGerente) {
        this.nit = nit;
        this.nombre = nombre;
        this.idGerente = idGerente;
    }
}

