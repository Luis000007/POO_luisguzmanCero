package edu.luisguzman.reto7.vasos_de_cafe;

import java.util.Scanner;

public class VasosDeCafe {
    public static void main(String[] args) {

        int opcion;
        boolean continuar = true;

        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println("******¿Qué le gustaría ordenar?******");
            System.out.println("1. Pequeño sin azúcar");
            System.out.println("2. Pequeño con azúcar");
            System.out.println("3. Mediano con azúcar");
            System.out.println("4. Mediano sin azúcar");
            System.out.println("5. Grande con azúcar");
            System.out.println("6. Grande sin azúcar");
            System.out.println("7. Salir");

            System.out.print("Seleccione la opción de su preferencia: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado: Pequeño sin azúcar");
                    break;

                case 2:
                    System.out.println("Ha seleccionado: Pequeño con azúcar");
                    break;

                case 3:
                    System.out.println("Ha seleccionado: Mediano con azúcar");
                    break;

                case 4:
                    System.out.println("Ha seleccionado: Mediano sin azúcar");
                    break;

                case 5:
                    System.out.println("Ha seleccionado: Grande con azúcar");
                    break;

                case 6:
                    System.out.println("Ha seleccionado: Grande sin azúcar");
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("No tenemos esa opción disponible");
                    break;
            }

            if (!continuar) {
                break;
            }

            System.out.print("¿Desea ordenar algo más? (Si/No): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("Si");
        }

        System.out.print("Gracias por su compra :D");
    }
}