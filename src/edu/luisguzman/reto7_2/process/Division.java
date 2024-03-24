package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la división utilizando suma y resta.
 */
public class Division {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Division.idiomas = idiomas;
    }

    /**
     * Divide el dividendo entre el divisor y muestra el cociente y el resto.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void dividir(Scanner scanner) {
        System.out.println(idiomas.INGRESE_DIVIDENDO);
        int dividendo = scanner.nextInt();
        System.out.println(idiomas.INGRESE_DIVISOR);
        int divisor = scanner.nextInt();

        // Verificar si el divisor es 0
        if (divisor == 0) {
            System.out.println(idiomas.Error_DIVISION);
            return;
        }

        // Verificar si el dividendo es 0
        if (dividendo == 0) {
            System.out.println(idiomas.COCIENTE_ES + 0 + idiomas.RESTO_ES + 0);
            return;
        }

        // Manejar el signo del cociente y el divisor
        int signo = 1;
        if ((dividendo < 0 && divisor > 0) || (dividendo > 0 && divisor < 0)) {
            signo = -1;
        }
        dividendo = Math.abs(dividendo);
        divisor = Math.abs(divisor);

        int cociente = 0;
        int resto = dividendo;

        // Realizar la división utilizando resta repetida
        while (resto >= divisor) {
            resto -= divisor; // Restar el divisor del resto
            cociente++; // Incrementar el cociente
        }

        // Mostrar el resultado de la división
        System.out.println(idiomas.COCIENTE_ES + (cociente * signo) + idiomas.RESTO_ES + resto);
    }
}