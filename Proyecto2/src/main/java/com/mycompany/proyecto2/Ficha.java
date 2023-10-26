/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2;

import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Ficha {
    private int ficha;
    private String color;
    private JLabel label;

    public Ficha(int ficha, String color, JLabel label) {
        this.ficha = ficha;
        this.color = color;
        this.label = label;
    }

    public int getFicha() {
        return ficha;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ficha{" + "ficha=" + ficha + ", color=" + color + '}';
    }
    
    
    
}
