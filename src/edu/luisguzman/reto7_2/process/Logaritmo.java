package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el cálculo del logaritmo natural utilizando suma y resta.
 */
public class Logaritmo {

    /**
     * Emula el cálculo del logaritmo natural utilizando la serie de Taylor y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void logaritmo(Scanner scanner) {
        System.out.println("Ingrese el valor para calcular el logaritmo natural");
        double x = scanner.nextDouble();

        // Verificar si el valor es válido para el logaritmo
        if (x <= 0) {
            System.out.println("El logaritmo natural no está definido para valores no positivos.");
            return;
        }

        // Calcular el logaritmo utilizando la serie de Taylor
        double resultado = calcularLogaritmo(x);

        // Mostrar el resultado del logaritmo
        System.out.println("El logaritmo natural de " + x + " es: " + resultado);
    }

    /**
     * Calcula el logaritmo natural de un número utilizando la serie de Taylor.
     *
     * @param x El número para el cual se calcula el logaritmo natural.
     * @return El logaritmo natural de x.
     */
    private static double calcularLogaritmo(double x) {
        // Definir el número de términos en la serie de Taylor
        int numTerminos = 1000;
        double logX = 0;

        // Calcular el logaritmo utilizando la serie de Taylor
        for (int n = 1; n <= numTerminos; n++) {
            logX += (Math.pow(-1, n + 1) / n) * Math.pow((x - 1), n);
        }

        return logX;
    }
}