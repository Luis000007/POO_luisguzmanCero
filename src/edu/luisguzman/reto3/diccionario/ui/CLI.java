package edu.luisguzman.reto3.diccionario.ui;

import edu.luisguzman.reto3.diccionario.process.Diccionario;
import java.util.Scanner;

public class CLI {
    public static void showMenu(Diccionario diccionario){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("-----diccionario-----");
            System.out.println("**********************");
            System.out.println("1. Mostrar palabras del diccionario");
            System.out.println("2. Buscar palabra del diccionario");
            System.out.println("3. Detalle del diccionario");
            System.out.println("4. Salir del programa");
            System.out.println("**********************");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    diccionario.printList();
                    break;
                case "2":
                    System.out.println("¿Qué palabra quiere conocer?");
                    String palabra = scanner.nextLine();
                    String significado = diccionario.buscarSignificados(palabra);
                    System.out.printf("%s: %s%n", palabra, significado);
                    break;
                case "3":
                    diccionario.detalleDiccionario();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

// La clase CLI es la interfaz y el menu que se le muestra al usuario