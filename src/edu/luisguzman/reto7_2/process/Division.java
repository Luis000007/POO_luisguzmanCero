package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la división utilizando suma y resta.
 */
public class Division {

    /**
     * Divide el dividendo entre el divisor y muestra el cociente y el resto.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void dividir(Scanner scanner) {
        System.out.println("Ingrese el dividendo");
        int dividendo = scanner.nextInt();
        System.out.println("Ingrese el divisor");
        int divisor = scanner.nextInt();

        // Verificar si el divisor es 0
        if (divisor == 0) {
            System.out.println("No se puede dividir por 0");
            return;
        }

        int cociente = 0;
        int resto = Math.abs(dividendo); // Tomar el valor absoluto del dividendo

        // Realizar la división utilizando resta repetida
        while (resto >= Math.abs(divisor)) {
            resto -= Math.abs(divisor); // Restar el divisor del resto
            cociente++; // Incrementar el cociente
        }

        // Manejar el signo del cociente si uno de los números es negativo
        if ((dividendo < 0 && divisor > 0) || (dividendo > 0 && divisor < 0)) {
            cociente = -cociente;
        }

        // Mostrar el resultado de la división
        System.out.println("El cociente es: " + cociente + " y el resto es: " + resto);
    }
}

