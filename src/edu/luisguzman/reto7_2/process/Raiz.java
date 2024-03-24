package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el cálculo de la raíz cuadrada utilizando suma y resta.
 */
public class Raiz {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Raiz.idiomas = idiomas;
    }

    /**
     * Emula el cálculo de la raíz cuadrada utilizando suma y resta y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void raizCuadrada(Scanner scanner) {
        System.out.println(idiomas.INGRESE_RAIZ);
        double numero = scanner.nextDouble();

        // Verificar si el número es válido para calcular la raíz cuadrada
        if (numero < 0) {
            System.out.println(idiomas.RAIZ_NEGATIVA);
            return;
        }

        // Calcular la raíz cuadrada utilizando suma y resta
        double aproximacion = calcularRaizCuadrada(numero);

        // Mostrar el resultado de la raíz cuadrada
        System.out.println(idiomas.RAIZ_CUADRADA + numero + idiomas.ES_ES + aproximacion);
    }

    /**
     * Calcula la raíz cuadrada de un número utilizando el método de aproximación por suma y resta.
     *
     * @param numero El número para el cual se calcula la raíz cuadrada.
     * @return La aproximación de la raíz cuadrada de numero.
     */
    private static double calcularRaizCuadrada(double numero) {
        double aproximacion = 1; // Empezamos con una aproximación de 1

        // Iterar hasta que la aproximación se estabilice
        for (int i = 0; i < 100; i++) {
            // Calcular el error (diferencia entre la aproximación y el resultado real)
            double error = aproximacion * aproximacion - numero;
            // Ajustar la aproximación sumando o restando el error
            aproximacion -= error / (2 * aproximacion);
        }

        return aproximacion;
    }
}
