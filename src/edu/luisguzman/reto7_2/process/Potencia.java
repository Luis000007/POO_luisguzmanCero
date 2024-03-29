package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular la operación de potenciación utilizando suma y resta.
 */
public class Potencia {

    /**
     * Emula la operación de potenciación utilizando suma y resta y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void potencia(Scanner scanner) {
        System.out.println("Ingrese la base");
        int base = scanner.nextInt();
        System.out.println("Ingrese el exponente");
        int exponente = scanner.nextInt();

        // Manejar el caso especial donde el exponente es 0
        if (exponente == 0) {
            System.out.println("El resultado es: 1");
            return;
        }

        // Inicializar el resultado como 1, ya que cualquier número elevado a 0 es 1
        int resultado = 1;

        // Emular la operación de potenciación utilizando multiplicación repetida
        for (int i = 1; i <= exponente; i++) {
            resultado = multiplicar(resultado, base); // Multiplicar el resultado actual por la base
        }

        // Mostrar el resultado de la potenciación
        System.out.println("El resultado es: " + resultado);
    }

    /**
     * Multiplica dos números utilizando suma repetida.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return El resultado de la multiplicación.
     */
    private static int multiplicar(int a, int b) {
        int resultado = 0;
        for (int i = 0; i < b; i++) {
            resultado += a; // Sumar 'a' a 'resultado' 'b' veces
        }
        return resultado;
    }
}

