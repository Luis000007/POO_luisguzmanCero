package edu.luisguzman.evidencia3.process;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CPU {
    private char[][] tablero;
    private Scanner scanner;

    public CPU() {
        this.tablero = new char[3][3];
        this.scanner = new Scanner(System.in);
        inicializarTablero();
    }

    public static void main(String[] args) throws IOException { // Clase principal
        CPU maquina = new CPU();
        maquina.jugarConUsuario();
    }

    public static void maquina(Scanner scanner) throws IOException {
        CPU cpu = new CPU();
        boolean terminar = false;

        do {
            cpu.imprimirTablero();
            cpu.registrarJugadaUsuario('X', scanner);
            if (cpu.hayGanador('X')) {
                cpu.imprimirTablero();
                System.out.println("¡Felicidades! ¡Has ganado!");
                terminar = true;
            } else if (!cpu.hayEspacio()) {
                cpu.imprimirTablero();
                System.out.println("¡Empate! No quedan casillas disponibles.");
                terminar = true;
            } else {
                cpu.realizarMovimiento('O');
                if (cpu.hayGanador('O')) {
                    cpu.imprimirTablero();
                    System.out.println("¡La CPU ha ganado!");
                    terminar = true;
                }
            }
        } while (!terminar);

        scanner.close();
    }

    public void jugarConUsuario() throws IOException {
        maquina(this.scanner);
    }

    private void imprimirTablero() {
        System.out.println("Tablero:");
        System.out.println("-------------");

        int numCasilla = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == '-') {
                    System.out.print("| " + numCasilla + " ");
                } else {
                    System.out.print("| " + tablero[i][j] + " ");
                }
                numCasilla++;
            }
            System.out.println("|");
            System.out.println("-------------");
        }
        System.out.println();
    }

    private void registrarJugadaUsuario(char caracter, Scanner scanner) throws IOException {
        if (caracter == 'X') {
            int position;
            do {
                System.out.println("Turno de " + (caracter == 'X' ? "jugador" : "la CPU"));
                System.out.println("Ingresa un numero:");
                position = scanner.nextInt();
            } while (!casillaNoOcupada(position));

            asignarMovimiento(position, caracter);
        }
    }

    private boolean casillaNoOcupada(int posicion) {
        switch (posicion) {
            case 1:
                return tablero[0][0] == '-';
            case 2:
                return tablero[0][1] == '-';
            case 3:
                return tablero[0][2] == '-';
            case 4:
                return tablero[1][0] == '-';
            case 5:
                return tablero[1][1] == '-';
            case 6:
                return tablero[1][2] == '-';
            case 7:
                return tablero[2][0] == '-';
            case 8:
                return tablero[2][1] == '-';
            case 9:
                return tablero[2][2] == '-';
            default:
                return false;
        }
    }

    private void asignarMovimiento(int position, char caracter) {
        switch (position) {
            case 1:
                tablero[0][0] = caracter;
                break;
            case 2:
                tablero[0][1] = caracter;
                break;
            case 3:
                tablero[0][2] = caracter;
                break;
            case 4:
                tablero[1][0] = caracter;
                break;
            case 5:
                tablero[1][1] = caracter;
                break;
            case 6:
                tablero[1][2] = caracter;
                break;
            case 7:
                tablero[2][0] = caracter;
                break;
            case 8:
                tablero[2][1] = caracter;
                break;
            case 9:
                tablero[2][2] = caracter;
                break;
        }
    }

    private boolean hayGanador(char caracter) {
        // Evaluar filas
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == caracter && tablero[i][1] == caracter && tablero[i][2] == caracter) {
                return true;
            }
        }
        // Evaluar columnas
        for (int j = 0; j < tablero.length; j++) {
            if (tablero[0][j] == caracter && tablero[1][j] == caracter && tablero[2][j] == caracter) {
                return true;
            }
        }
        // Evaluar diagonales
        if (tablero[0][0] == caracter && tablero[1][1] == caracter && tablero[2][2] == caracter) {
            return true;
        }
        if (tablero[0][2] == caracter && tablero[1][1] == caracter && tablero[2][0] == caracter) {
            return true;
        }
        return false;
    }

    private boolean hayEspacio() {
        for (char[] fila : tablero) {
            for (char casilla : fila) {
                if (casilla == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    private void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private void realizarMovimiento(char caracter) {
        if (caracter == 'O') {
            System.out.println("Turno de la CPU");
            Random random = new Random();
            int position;
            do {
                position = random.nextInt(9) + 1;
            } while (!casillaNoOcupada(position));
            asignarMovimiento(position, caracter);
        }
    }
}
