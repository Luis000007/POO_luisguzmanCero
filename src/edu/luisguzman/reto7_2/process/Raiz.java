package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el cálculo de la raíz cuadrada utilizando suma y resta.
 */
public class Raiz {

    /**
     * Emula el cálculo de la raíz cuadrada utilizando el método de Newton-Raphson y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void raizCuadrada(Scanner scanner) {
        System.out.println("Ingrese el número para calcular la raíz cuadrada");
        double numero = scanner.nextDouble();

        // Verificar si el número es válido para calcular la raíz cuadrada
        if (numero < 0) {
            System.out.println("La raíz cuadrada de un número negativo no está definida.");
            return;
        }

        // Calcular la raíz cuadrada utilizando el método de Newton-Raphson
        double aproximacion = calcularRaizCuadrada(numero);

        // Mostrar el resultado de la raíz cuadrada
        System.out.println("La raíz cuadrada de " + numero + " es: " + aproximacion);
    }

    /**
     * Calcula la raíz cuadrada de un número utilizando el método de Newton-Raphson.
     *
     * @param numero El número para el cual se calcula la raíz cuadrada.
     * @return La aproximación de la raíz cuadrada de numero.
     */
    private static double calcularRaizCuadrada(double numero) {
        double aproximacion = numero / 2; // Aproximación inicial
        double epsilon = 1e-7; // Tolerancia

        // Iterar hasta que la diferencia entre la aproximación actual y la próxima aproximación sea menor que epsilon
        while (Math.abs(aproximacion * aproximacion - numero) > epsilon) {
            aproximacion = (aproximacion + numero / aproximacion) / 2; // Aplicar el método de Newton-Raphson
        }

        return aproximacion;
    }
}
