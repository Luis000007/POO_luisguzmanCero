package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el cálculo del logaritmo natural utilizando suma y resta.
 */
public class Logaritmo {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Logaritmo.idiomas = idiomas;
    }

    /**
     * Emula el cálculo del logaritmo natural utilizando la serie de Taylor y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void logaritmo(Scanner scanner) {
        System.out.println(idiomas.INGRESE_LOGARITMO);
        double x = scanner.nextDouble();

        // Verificar si el valor es válido para el logaritmo
        if (x <= 0) {
            System.out.println(idiomas.ERROR_LOGARITMO);
            return;
        }

        // Calcular el logaritmo utilizando la serie de Taylor
        double resultado = calcularLogaritmo(x);

        // Mostrar el resultado del logaritmo
        System.out.println(idiomas.LOGARITMO_NATURAL + x + idiomas.ES_ES + resultado);
    }

    /**
     * Calcula el logaritmo natural de un número utilizando la serie de Taylor.
     *
     * @param x El número para el cual se calcula el logaritmo natural.
     * @return El logaritmo natural de x.
     */
    private static double calcularLogaritmo(double x) {
        // Definir el número de términos en la serie de Taylor
        int numTerminos = 100;
        double logX = 0;
        double numerador = x - 1;
        double denominador = 1;

        // Calcular el logaritmo utilizando la serie de Taylor
        for (int n = 1; n <= numTerminos; n++) {
            logX += (Math.pow(-1, n + 1) * numerador) / denominador;
            numerador *= (x - 1); // Actualizar el numerador
            denominador++; // Incrementar el denominador
        }

        return logX;
    }
}