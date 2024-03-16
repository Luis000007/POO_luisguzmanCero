package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para emular el operador módulo (%) utilizando suma y resta.
 */
public class Modulo {

    /**
     * Emula el operador módulo (%) utilizando suma y resta y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void modulo(Scanner scanner) {
        System.out.println("Ingrese el dividendo");
        int dividendo = scanner.nextInt();
        System.out.println("Ingrese el divisor");
        int divisor = scanner.nextInt();

        // Verificar si el divisor es 0
        if (divisor == 0) {
            System.out.println("No se puede dividir por 0");
            return;
        }

        // Emular el operador módulo utilizando resta repetida
        int resto = dividendo; // Inicializar el resto con el dividendo
        while (resto >= divisor) {
            resto -= divisor; // Restar el divisor del resto
        }

        // Mostrar el resultado del módulo
        System.out.println("El resultado del módulo es: " + resto);
    }
}
