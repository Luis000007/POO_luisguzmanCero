package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular la operación de potenciación utilizando suma y resta.
 */
public class Potencia {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Potencia.idiomas = idiomas;
    }

    /**
     * Emula la operación de potenciación utilizando suma y resta y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void potencia(Scanner scanner) {
        // Acceder a las variables de idioma utilizando la instancia de Idiomas
        System.out.println(idiomas.INGRESE_LA_BASE);
        int base = scanner.nextInt();
        System.out.println(idiomas.INGRESE_EXPONENTE);
        int exponente = scanner.nextInt();

        // Verificar si el exponente es 0
        if (exponente == 0) {
            System.out.println(idiomas.EL_RESULTADO + 1);
            return;
        }

        // Inicializar el resultado como 1, ya que cualquier número elevado a 0 es 1
        int resultado = 1;

        // Emular la operación de potenciación utilizando multiplicación repetida
        for (int i = 1; i <= exponente; i++) {
            resultado = multiplicar(resultado, base); // Multiplicar el resultado actual por la base
        }

        // Mostrar el resultado de la potenciación
        System.out.println(idiomas.EL_RESULTADO + resultado);
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