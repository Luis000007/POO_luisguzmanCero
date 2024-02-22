package edu.luisguzman.reto3_2.Matiz;

import java.util.Random;

public class Matriz {
    private final int[][] matriz;
    private final int filas;
    private final int columnas;

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
        Random rand = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(100) + 1;
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}