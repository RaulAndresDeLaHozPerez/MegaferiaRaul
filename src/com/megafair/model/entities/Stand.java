/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megafair.model.entities;

import com.megafair.model.entities.Editorial;

public class Stand implements Cloneable {

    private long id;
    private double precio;
    private Editorial editorial;

    public Stand(long id, double precio) {
        this.id = id;
        this.precio = precio;
        this.editorial = null;
    }

    public long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public Stand clone() {
        Stand s = new Stand(id, precio);
        s.editorial = this.editorial; 
        return s;
    }
}


