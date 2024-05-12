package edu.luisguzman.evidencia3.process;

import edu.luisguzman.evidencia3.Idiomas.Idiomas;
import edu.luisguzman.evidencia3.Ui.CLI;

import java.io.IOException;
import java.util.Scanner;

public class Vs {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas) {
        Vs.idiomas = idiomas;
    }

    public static char[][] matriz_gato = new char[3][3];
    public static String Nombre1 = "";
    public static String Nombre2 = "";
    public static char jugadorActual = '-';
    public static char jugador1 = '-';
    public static char jugador2 = '-';

    public static void imprimirPosiciones() {
        System.out.println("Tablero:");
        System.out.println("-------------");

        int numCasilla = 1;
        for (int i = 0; i < matriz_gato.length; i++) {
            for (int j = 0; j < matriz_gato.length; j++) {
                if (matriz_gato[i][j] == '-') {
                    System.out.print("| " + numCasilla + " ");
                } else {
                    System.out.print("| " + matriz_gato[i][j] + " ");
                }
                numCasilla++;
            }
            System.out.println("|");
            System.out.println("-------------");
        }
        System.out.println();
    }

    public static void seleccionarCaracteres(Scanner scanner) {
        System.out.println("Jugador 1, por favor elija su caracter (*, +, $, X, O): ");
        jugador1 = scanner.next().charAt(0);
        System.out.println("Jugador 2, por favor elija su caracter (*, +, $, X, O): ");
        jugador2 = scanner.next().charAt(0);
        scanner.nextLine(); // Consumir el salto de línea pendiente
    }

    public static void nombres(Scanner scanner) {
        System.out.println("Nombre del jugador 1: ");
        Nombre1 = scanner.nextLine();
        System.out.println("Nombre del jugador 2: ");
        Nombre2 = scanner.nextLine();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        seleccionarCaracteres(scanner);
        nombres(scanner);
        inicializarTablero();
        jugadorActual = jugador1;
        contra(scanner);
    }

    public static void contra(Scanner scanner) throws IOException {
        boolean terminar = false;
        imprimirPosiciones(); // Imprimir el tablero al inicio de la partida
        do {
            registrarJugada(jugadorActual, scanner);
            if (hayGanador(jugadorActual)) {
                System.out.println("Felicidades " + (jugadorActual == jugador1 ? Nombre1 : Nombre2) + " has ganado el juego");
                terminar = true;
            } else if (!hayEspacio()) {
                System.out.println("Ya no hay casillas disponibles, el juego se empato");
                terminar = true;
            } else {
                jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
            }
            imprimirPosiciones(); // Imprimir el tablero al final de cada turno
        } while (!terminar);

        mostrarMenu(scanner);
    }

    public static void mostrarMenu(Scanner scanner) throws IOException {
        System.out.println("******************************************");
        System.out.println("¿Qué deseas hacer ahora?");
        System.out.println("1. Jugar un nuevo juego");
        System.out.println("2. Ir al menú principal");

        int opcionMenu;

        if (scanner.hasNextInt()) {
            opcionMenu = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            if (opcionMenu == 1 || opcionMenu == 2) {
                switch (opcionMenu) {
                    case 1:
                        System.out.println("******************");
                        System.out.println("Iniciando juego...");
                        inicializarTablero();
                        jugadorActual = jugador1;
                        contra(scanner);
                        break;
                    case 2:
                        System.out.println("*********************");
                        System.out.println("Regresando al menú principal...");
                        CLI menu = new CLI();
                        menu.contra(scanner);
                        break;
                }
            } else {
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } else {
            System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
            scanner.nextLine(); // Consumir la entrada inválida
        }
    }

    public static boolean casillaNoOcupada(int posicion) {
        switch (posicion) {
            case 1:
                return matriz_gato[0][0] == '-';
            case 2:
                return matriz_gato[0][1] == '-';
            case 3:
                return matriz_gato[0][2] == '-';
            case 4:
                return matriz_gato[1][0] == '-';
            case 5:
                return matriz_gato[1][1] == '-';
            case 6:
                return matriz_gato[1][2] == '-';
            case 7:
                return matriz_gato[2][0] == '-';
            case 8:
                return matriz_gato[2][1] == '-';
            case 9:
                return matriz_gato[2][2] == '-';
            default:
                return false;
        }
    }

    public static void registrarJugada(char caracter, Scanner scanner) {
        boolean salir = false;
        int posicion;
        do {
            System.out.println("Turno de " + (caracter == jugador1 ? Nombre1 : Nombre2));
            System.out.println("Ingresa un numero:");
            posicion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            if (casillaNoOcupada(posicion)) {
                switch (posicion) {
                    case 1:
                        matriz_gato[0][0] = caracter;
                        break;
                    case 2:
                        matriz_gato[0][1] = caracter;
                        break;
                    case 3:
                        matriz_gato[0][2] = caracter;
                        break;
                    case 4:
                        matriz_gato[1][0] = caracter;
                        break;
                    case 5:
                        matriz_gato[1][1] = caracter;
                        break;
                    case 6:
                        matriz_gato[1][2] = caracter;
                        break;
                    case 7:
                        matriz_gato[2][0] = caracter;
                        break;
                    case 8:
                        matriz_gato[2][1] = caracter;
                        break;
                    case 9:
                        matriz_gato[2][2] = caracter;
                        break;
                }
                salir = true;
            } else {
                System.out.println("Casilla no válida, por favor elija una casilla válida.");
            }
        } while (!salir);
    }

    public static boolean ganaPorRenglon(char caracter) {
        for (char[] gato1 : matriz_gato) {
            if (gato1[0] == caracter && gato1[1] == caracter && gato1[2] == caracter) {
                return true;
            }
        }
        return false;
    }

    public static boolean ganaPorColumna(char caracter) {
        for (int i = 0; i < matriz_gato.length; i++) {
            if (matriz_gato[0][i] == caracter && matriz_gato[1][i] == caracter && matriz_gato[2][i] == caracter) {
                return true;
            }
        }
        return false;
    }

    public static boolean ganaPorDiagonales(char caracter) {
        if (matriz_gato[0][0] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][2] == caracter) {
            return true;
        }
        if (matriz_gato[0][2] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][0] == caracter) {
            return true;
        }
        return false;
    }

    public static boolean hayGanador(char caracter) {
        return ganaPorRenglon(caracter) || ganaPorColumna(caracter) || ganaPorDiagonales(caracter);
    }

    public static boolean hayEspacio() {
        for (char[] gato1 : matriz_gato) {
            for (int j = 0; j < matriz_gato.length; j++) {
                if (gato1[j] == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void inicializarTablero() {
        for (int i = 0; i < matriz_gato.length; i++) {
            for (int j = 0; j < matriz_gato.length; j++) {
                matriz_gato[i][j] = '-';
            }
        }
    }
}
