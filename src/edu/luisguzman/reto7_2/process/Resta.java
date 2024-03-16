package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la resta entre dos números.
 */
public class Resta {

    /**
     * Realiza la resta entre dos números y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void resta(Scanner scanner) {
        System.out.println("Ingrese el primer numero");
        int numero1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero");
        int numero2 = scanner.nextInt();
        int resultado = numero1 - numero2;
        System.out.println("El resultado es: " + resultado);
    }
}

