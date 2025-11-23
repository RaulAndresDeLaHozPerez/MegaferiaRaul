/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

public class Editorial {

    private String nit;
    private String nombre;
    private Gerente gerente;

    public Editorial(String nit, String nombre, Gerente gerente) {
        this.nit = nit;
        this.nombre = nombre;
        this.gerente = gerente;
    }

    public String getNit() { return nit; }
    public String getNombre() { return nombre; }
    public Gerente getGerente() { return gerente; }
}


