package edu.luisguzman.evidencia3.process;

import java.io.IOException;
import java.util.Scanner;

public class Vs {

    public static char[][] matriz_gato = new char[3][3];
    public static String Nombre1 = "";
    public static String Nombre2 = "";
    public static char jugadorActual = 'X';

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

    public static void registrarJugada(char caracter, Scanner scanner) throws IOException {
        boolean salir = false;
        int position;
        do {
            imprimirPosiciones();
            System.out.println("Turno de " + (jugadorActual == 'X' ? Nombre1 : Nombre2));
            System.out.println("Ingresa un numero:");
            position = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            if (casillaNoOcupada(position)) {
                switch (position) {
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
                System.out.println("Casilla ocupada, por favor elija una casilla valida");
            }
        } while (!salir);
    }

    public static boolean ganaPorRenglon(char caracter) {
        // este metodo evalua si los caracteres por fila son los mismos
        for (char[] gato1 : matriz_gato) {
            if (gato1[0] == caracter && gato1[1] == caracter && gato1[2] == caracter) {
                return true;
            }
        }
        return false;
    }

    public static boolean ganaPorColumna(char caracter) {
        // este metodo evalua si los caracteres por columna son los mismos
        for (int i = 0; i < matriz_gato.length; i++) {
            if (matriz_gato[0][i] == caracter && matriz_gato[1][i] == caracter && matriz_gato[2][i] == caracter) {
                return true;
            }
        }
        return false;
    }

    public static boolean ganaPorDiagonales(char caracter) {
        // este metodo evalua si los caractres por diagonal son los mismos
        if (matriz_gato[0][0] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][2] == caracter) {
            return true;
        }
        if (matriz_gato[0][2] == caracter && matriz_gato[1][1] == caracter && matriz_gato[2][0] == caracter) {
            return true;
        }
        return false;
    }

    public static boolean hayGanador(char caracter) { // Metodo para buscar un ganador
        return ganaPorRenglon(caracter) || ganaPorColumna(caracter) || ganaPorDiagonales(caracter);
    }

    public static boolean hayEspacio() { // Metodo para evaluar si quedan espacios disponibles
        for (char[] gato1 : matriz_gato) {
            for (int j = 0; j < matriz_gato.length; j++) {
                if (gato1[j] == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void inicializarTablero() { // Metodo para crear tablero de gato
        for (int i = 0; i < matriz_gato.length; i++) {
            for (int j = 0; j < matriz_gato.length; j++) {
                matriz_gato[i][j] = '-';
            }
        }
    }

    public static void nombres(Scanner scanner) { // Metodo de nombre
        System.out.println("Nombre del jugador 1: ");
        Nombre1 = scanner.nextLine();
        System.out.println("Nombre del jugador 2: ");
        Nombre2 = scanner.nextLine();
    }

    public static void main(String[] args) throws IOException { // Clase principal
        Scanner scanner = new Scanner(System.in);
        contra(scanner);
    }

    public static void contra(Scanner scanner) throws IOException {
        boolean terminar = false;
        inicializarTablero(); // Metodo para crear el tablero
        nombres(scanner); // Metodos para capturar nombres de los jugadores

        do {
            registrarJugada(jugadorActual, scanner); // Registra la jugada en turno
            if (hayGanador(jugadorActual)) { // Evalua si hay un ganador
                System.out.println("Felicidades " + (jugadorActual == 'X' ? Nombre1 : Nombre2) + " has ganado el juego");
                imprimirPosiciones();
                terminar = true;
            } else if (!hayEspacio()) { // Metodo para evaluar si hay espacios disponibles
                System.out.println("Ya no hay casillas disponibles, el juego se empato");
                imprimirPosiciones();
                terminar = true;
            } else {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X'; // Cambiar al siguiente jugador
            }
        } while (!terminar);
    }
}
