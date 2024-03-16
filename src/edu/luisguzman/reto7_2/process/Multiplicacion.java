package edu.luisguzman.reto7_2.process;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la multiplicación utilizando suma repetida.
 */
public class Multiplicacion {

    /**
     * Realiza la multiplicación de dos números utilizando suma repetida y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void multiplicar(Scanner scanner) {
        System.out.println("Ingrese el primer numero");
        int numero1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero");
        int numero2 = scanner.nextInt();

        // Verificar si uno de los números es 0
        if (numero1 == 0 || numero2 == 0) {
            System.out.println("El resultado es: 0");
            return;
        }

        int resultado = 0;
        int contador = Math.abs(numero2); // Tomar el valor absoluto de numero2

        // Realizar la multiplicación utilizando suma repetida
        while (contador > 0) {
            resultado += numero1; // Sumar numero1 al resultado
            contador--; // Decrementar el contador
        }

        // Manejar el signo del resultado si uno de los números es negativo
        if ((numero1 < 0 && numero2 > 0) || (numero1 > 0 && numero2 < 0)) {
            resultado = -resultado;
        }

        // Mostrar el resultado de la multiplicación
        System.out.println("El resultado es: " + resultado);
    }
}
