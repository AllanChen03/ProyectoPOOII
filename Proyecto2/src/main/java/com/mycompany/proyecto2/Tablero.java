/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2;

/**
 *
 * @author User
 */
public class Tablero {
    int[][] tablero;

    public Tablero() {
        this.tablero = new int[8][13];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 13; j++) {
                tablero[i][j] = j+1;
            }
            
        }
    }
    public void imprimirTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
