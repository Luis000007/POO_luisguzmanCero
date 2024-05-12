package edu.luisguzman.evidencia3.Ui;

import edu.luisguzman.evidencia3.Idiomas.Eng;
import edu.luisguzman.evidencia3.Idiomas.Esp;
import edu.luisguzman.evidencia3.Idiomas.Idiomas;
import edu.luisguzman.evidencia3.process.CPU;
import edu.luisguzman.evidencia3.process.Vs;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private static Idiomas idiomas;
    public static void main(String[] args) throws IOException {
        idiomas = new Esp();
        Scanner scanner = new Scanner(System.in);
        CLI menu = new CLI();
        menu.imprimirMenuInicial(scanner);
    }

    public void imprimirMenuInicial(Scanner scanner) throws IOException {
        int opcionIdioma = 0;

        while (true) {
            System.out.println(idiomas.Bienvenido_a_gato);

            System.out.println(idiomas.Menu_idiomas);

            if (scanner.hasNextInt()) {
                opcionIdioma = scanner.nextInt();
                scanner.nextLine();

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break;
                } else {
                    System.out.println(idiomas.Opcion_invalida_1_2);
                }
            } else {
                System.out.println(idiomas.Opcion_invalida);
                scanner.nextLine();
            }
        }

        switch (opcionIdioma) {
            case 1:
                idiomas = new Esp();
                break;
            case 2:
                idiomas = new Eng();
                break;
        }

        System.out.println(idiomas.Instrucciones);

        contra(scanner);
    }

    public void contra(Scanner scanner) throws IOException {
        int opcionJuego = 0;

        while (true) {
            System.out.println(idiomas.Modo_de_juego);

            if (scanner.hasNextInt()) {
                opcionJuego = scanner.nextInt();
                scanner.nextLine();

                if (opcionJuego >= 1 && opcionJuego <= 3) {

                    break;
                } else {
                    System.out.println(idiomas.Opcion_invalida);
                }
            } else {
                System.out.println(idiomas.Opcion_invalida);
                scanner.nextLine();
            }
        }

        switch (opcionJuego) {
            case 1:
                System.out.println(idiomas.Jugar_contra_jugador);
                Vs.contra(scanner);
                break;
            case 2:
                System.out.println(idiomas.Jugar_contra_CPU);
                CPU.maquina(scanner);
                break;
            case 3:
                System.out.println(idiomas.Gracias_por_jugar);
                break;
        }

        // Si se selecciona la opción 3, el programa termina
        if (opcionJuego == 3) {
            System.out.println(idiomas.Saliendo);
        }
    }
}

