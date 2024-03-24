package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el operador módulo (%) utilizando suma y resta.
 */
public class Modulo {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Modulo.idiomas = idiomas;
    }

    /**
     * Emula el operador módulo (%) utilizando suma y resta y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void modulo(Scanner scanner) {
        System.out.println(idiomas.INGRESE_DIVIDENDO);
        int dividendo = scanner.nextInt();
        System.out.println(idiomas.INGRESE_DIVISOR);
        int divisor = scanner.nextInt();

        // Verificar si el divisor es 0
        if (divisor == 0) {
            System.out.println(idiomas.Error_DIVISION);
            return;
        }

        // Obtener el valor absoluto del dividendo y del divisor
        dividendo = Math.abs(dividendo);
        divisor = Math.abs(divisor);

        // Emular el operador módulo utilizando resta repetida
        int resto = dividendo % divisor;

        // Mostrar el resultado del módulo
        System.out.println(idiomas.EL_RESULTADO + resto);
    }
}