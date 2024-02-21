// CLI.java
package edu.luisguzman.reto1.UI;

import edu.luisguzman.reto1.process.CalculadoraMasaCorporal;
import java.util.Scanner;

public class CLI {
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("Menú:");
            System.out.println("A. Cálculo de masa corporal (índice de masa corporal)");
            System.out.println("B. Cálculo de masa corporal magra");
            System.out.println("C. Cálculo de metabolismo basal (gasto energético basal)");
            System.out.println("D. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.next().charAt(0);
            scanner.nextLine(); // Limpiar el buffer del teclado

            switch (opcion) {
                case 'A':
                    CalculadoraMasaCorporal.calcularIMC();
                    break;
                case 'B':
                    CalculadoraMasaCorporal.calcularMasaCorporalMagra();
                    break;
                case 'C':
                    CalculadoraMasaCorporal.calcularMetabolismoBasal();
                    break;
                case 'D':
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 'D');
        scanner.close();
    }
}
