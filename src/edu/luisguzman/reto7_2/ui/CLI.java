package edu.luisguzman.reto7_2.ui;

import edu.luisguzman.reto7_2.process.*;

import java.util.Scanner;

/**
 * Esta clase proporciona un menú de línea de comandos para interactuar con las operaciones matemáticas disponibles.
 */
public class CLI {

    /**
     * El método principal que ejecuta el menú de línea de comandos.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {

        int opcion;
        boolean continuar = true;

        Scanner scanner = new Scanner(System.in);

        // Ciclo principal para mostrar el menú y procesar las selecciones del usuario
        while (continuar) {
            System.out.println("******¿Elige la operacion a realizar?******");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Modulo");
            System.out.println("6. Potencia");
            System.out.println("7. Raiz");
            System.out.println("8. Logaritmo");
            System.out.println("9. Salir");

            System.out.print("Seleccione la opción de su preferencia: ");
            opcion = scanner.nextInt();

            // Procesar la selección del usuario utilizando una instrucción switch
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado: Suma");
                    Suma.suma(scanner);
                    break;

                case 2:
                    System.out.println("Ha seleccionado: Resta");
                    Resta.resta(scanner);
                    break;

                case 3:
                    System.out.println("Ha seleccionado: Multiplicacion");
                    Multiplicacion.multiplicar(scanner);
                    break;

                case 4:
                    System.out.println("Ha seleccionado: Division");
                    Division.dividir(scanner);
                    break;

                case 5:
                    System.out.println("Ha seleccionado: Modulo");
                    Modulo.modulo(scanner);
                    break;

                case 6:
                    System.out.println("Ha seleccionado: Potencia");
                    Potencia.potencia(scanner);
                    break;

                case 7:
                    System.out.println("Ha seleccionado: Raiz");
                    Raiz.raizCuadrada(scanner);
                    break;

                case 8:
                    System.out.println("Ha seleccionado: Logaritmo");
                    Logaritmo.logaritmo(scanner);
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("No tenemos esa opción disponible");
                    break;
            }

            // Verificar si el usuario desea continuar
            if (!continuar) {
                break;
            }

            System.out.print("¿Desea realizar otra operacion? (Si/No): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("Si");
        }

        System.out.print("Gracias por usar el programa :D");
    }
}