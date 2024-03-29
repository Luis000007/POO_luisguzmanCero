package edu.luisguzman.reto7_2.process;

import edu.luisguzman.reto7_2.ui.Idiomas;

import java.util.Scanner;

/**
 * Esta clase proporciona un método estático para realizar la resta entre dos números.
 */
public class Resta {
    private static Idiomas idiomas;

    // Método para configurar el idioma
    public static void setLanguage(Idiomas idiomas) {
        Resta.idiomas = idiomas;
    }

    /**
     * Realiza la resta entre dos números y muestra el resultado.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void resta(Scanner scanner) {
        System.out.println(idiomas.INGRESE_PRIMERNUM);
        int numero1 = scanner.nextInt();
        System.out.println(idiomas.INGRESE_SEGUNDONUM);
        int numero2 = scanner.nextInt();
        int resultado = numero1 - numero2;
        System.out.println(idiomas.EL_RESULTADO + resultado);
    }
}
