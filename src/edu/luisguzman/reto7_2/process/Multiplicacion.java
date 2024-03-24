package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la multiplicación utilizando suma repetida.
 */
public class Multiplicacion {
    private static Idiomas idiomas = new Idiomas();

    public static void setLanguage(Idiomas idiomas) {
        Multiplicacion.idiomas = idiomas;
    }

    /**
     * Realiza la multiplicación de dos números utilizando suma repetida y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void multiplicar(Scanner scanner) {
        System.out.println(idiomas.INGRESE_MULTIPLICADOR);
        int multiplicador = scanner.nextInt();
        System.out.println(idiomas.INGRESE_MULTIPLICADO);
        int multiplicando = scanner.nextInt();

        // Verificar si uno de los números es 0
        if (multiplicador == 0 || multiplicando == 0) {
            System.out.println(idiomas.EL_RESULTADO + 0);
            return;
        }

        int resultado = 0;

        // Realizar la multiplicación utilizando suma repetida
        for (int i = 0; i < Math.abs(multiplicando); i++) {
            resultado += multiplicador;
        }

        // Manejar el signo del resultado
        if ((multiplicador < 0 && multiplicando > 0) || (multiplicador > 0 && multiplicando < 0)) {
            resultado = -resultado;
        }

        // Mostrar el resultado de la multiplicación
        System.out.println(idiomas.EL_RESULTADO + resultado);
    }
}