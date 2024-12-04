package edu.luisguzman.evidencia3.process;

import edu.luisguzman.evidencia3.Idiomas.Idiomas;
import edu.luisguzman.evidencia3.Ui.CLI;

import java.io.IOException;
import java.util.Scanner;

public class Vs {
    public static void contra(Scanner scanner, Idiomas idiomas) throws IOException {
        char[][] matriz_gato = new char[3][3];
        char jugadorActual;
        char jugador1;
        char jugador2;

        System.out.println(idiomas.Jugadro1_Caracter);
        jugador1 = scanner.next().charAt(0);
        scanner.nextLine(); // Consumir el salto de línea pendiente

        // Solicitar al segundo jugador que seleccione su signo
        do {
            System.out.println(idiomas.Jugador2_Caracter);
            jugador2 = scanner.next().charAt(0);
            scanner.nextLine(); // Consumir el salto de línea pendiente
            if (jugador2 == jugador1) {
                System.out.println(idiomas.Caracter_ya_seleccionado_intente_otro);
            }
        } while (jugador2 == jugador1);

        System.out.println(idiomas.Jugador1_Nombre);
        String nombre1 = scanner.nextLine();
        System.out.println(idiomas.Jugador2_Nombre);
        String nombre2 = scanner.nextLine();

        inicializarTablero(matriz_gato);
        jugadorActual = jugador1;
        contra(scanner, idiomas, matriz_gato, nombre1, nombre2, jugadorActual, jugador1, jugador2);
    }

    public static void contra(Scanner scanner, Idiomas idiomas, char[][] matriz_gato, String nombre1, String nombre2, char jugadorActual, char jugador1, char jugador2) throws IOException {
        boolean terminar = false;

        do {
            imprimirPosiciones(idiomas, matriz_gato);
            registrarJugada(jugadorActual, scanner, idiomas, matriz_gato);
            if (hayGanador(jugadorActual, idiomas, matriz_gato)) {
                System.out.println(idiomas.Felicidades + (jugadorActual == jugador1 ? nombre1 : nombre2) + idiomas.Has_ganado_el_juego);
                terminar = true;
            } else if (!hayEspacio(matriz_gato)) {
                System.out.println(idiomas.Se_empato_el_juego);
                terminar = true;
            } else {
                jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
            }
        } while (!terminar);

        mostrarMenu(scanner, idiomas);
    }

    public static void imprimirPosiciones(Idiomas idiomas, char[][] matriz_gato) {
        System.out.println(idiomas.Tablero);
        System.out.println("-------------");

        int numCasilla = 1;
        for (char[] fila : matriz_gato) {
            for (char casilla : fila) {
                if (casilla == '-') {
                    System.out.print("| " + numCasilla + " ");
                } else {
                    System.out.print("| " + casilla + " ");
                }
                numCasilla++;
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public static void registrarJugada(char caracter, Scanner scanner, Idiomas idiomas, char[][] matriz_gato) {
        boolean salir = false;
        int posicion;
        do {
            System.out.println(idiomas.Turno_de + (caracter == 'X' ? idiomas.Jugador : idiomas.La_CPU));
            System.out.println(idiomas.Ingresa_un_numero);
            posicion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            if (casillaNoOcupada(posicion, matriz_gato)) {
                asignarMovimiento(posicion, caracter, matriz_gato);
                salir = true;
            } else {
                System.out.println(idiomas.Casilla_no_valida_elige_una_valida);
            }
        } while (!salir);
    }

    public static boolean casillaNoOcupada(int posicion, char[][] matriz_gato) {
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

    public static void asignarMovimiento(int posicion, char caracter, char[][] matriz_gato) {
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
    }

    public static boolean hayGanador(char caracter, Idiomas idiomas, char[][] matriz_gato) {
        // Evaluar filas
        for (int i = 0; i < matriz_gato.length; i++) {
            if (matriz_gato[i][0] == caracter && matriz_gato[i][1] == caracter && matriz_gato[i][2] == caracter) {
                return true;
            }
        }
        // Evaluar columnas
        for (int j = 0; j < matriz_gato.length; j++) {
            if (matriz_gato[0][j] == caracter && matriz_gato[1][j] == caracter && matriz_gato[2][j] == caracter) {
                return true;
            }
        }
        // Evaluar diagonales
        if (matriz_gato[0][0] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][2] == caracter) {
            return true;
        }
        if (matriz_gato[0][2] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][0] == caracter) {
            return true;
        }
        return false;
    }

    public static boolean hayEspacio(char[][] matriz_gato) {
        for (char[] fila : matriz_gato) {
            for (char casilla : fila) {
                if (casilla == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void inicializarTablero(char[][] matriz_gato) {
        for (int i = 0; i < matriz_gato.length; i++) {
            for (int j = 0; j < matriz_gato.length; j++) {
                matriz_gato[i][j] = '-';
            }
        }
    }

    public static void mostrarMenu(Scanner scanner, Idiomas idiomas) throws IOException {
        System.out.println(idiomas.Que_deseas_hacer_Vs);

        int opcionMenu;

        if (scanner.hasNextInt()) {
            opcionMenu = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            if (opcionMenu == 1 || opcionMenu == 2) {
                switch (opcionMenu) {
                    case 1:
                        System.out.println(idiomas.Iniciando_juego);
                        contra(scanner, idiomas);
                        break;
                    case 2:
                        System.out.println(idiomas.Regresando_al_menu);
                        CLI menu = new CLI();
                        menu.contra(scanner);
                        break;
                }
            } else {
                System.out.println(idiomas.Casilla_no_valida_elige_una_valida);
            }
        } else {
            System.out.println(idiomas.Casilla_no_valida_elige_una_valida);
            scanner.nextLine(); // Consumir la entrada inválida
        }
    }
}
