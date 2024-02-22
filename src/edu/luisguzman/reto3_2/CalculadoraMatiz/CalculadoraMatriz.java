package edu.luisguzman.reto3_2.CalculadoraMatiz;


import edu.luisguzman.reto3_2.Matiz.Matriz;

public class CalculadoraMatriz {

    public static void contarParesImparesColumnas(Matriz matriz) {
        System.out.println("Conteo de números pares e impares por columnas:");
        int[][] matrizData = matriz.getMatriz();
        int filas = matriz.getFilas();
        int columnas = matriz.getColumnas();

        for (int j = 0; j < columnas; j++) {
            int pares = 0;
            int impares = 0;
            for (int i = 0; i < filas; i++) {
                if (matrizData[i][j] % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }
            }
            System.out.println("Columna " + (j + 1) + ": Pares = " + pares + ", Impares = " + impares);
        }
    }
    public static int calcularSuma(Matriz matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.getFilas(); i++) {
            for (int j = 0; j < matriz.getColumnas(); j++) {
                suma += matriz.getMatriz()[i][j];
            }
        }
        return suma;
    }

}