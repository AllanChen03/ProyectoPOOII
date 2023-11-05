/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Jugador {
    
    public String nombre;
    public ArrayList<Ficha> fichasMano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        fichasMano = new ArrayList<>();
        
    }
    
    public void tomarFicha(Ficha ficha){
        fichasMano.add(ficha);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getFichasMano() {
        return fichasMano;
    }
    
}
