package edu.luisguzman.evidencia3.process;

import edu.luisguzman.evidencia3.Ui.CLI;
import edu.luisguzman.evidencia3.Idiomas.Idiomas;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CPU {
    private char[][] tablero;
    private Scanner scanner;
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas) {
        CPU.idiomas = idiomas;
    }

    public static void maquina(Scanner scanner, Idiomas idiomas) throws IOException {
        CPU cpu = new CPU(idiomas);
        cpu.jugarConUsuario();
    }

    public CPU(Idiomas idiomas) {
        this.tablero = new char[3][3];
        this.scanner = new Scanner(System.in);
        this.idiomas = idiomas;
        inicializarTablero();
    }

    public void jugarConUsuario() throws IOException {
        boolean terminar = false;

        do {
            imprimirTablero();
            registrarJugadaUsuario('X');
            if (hayGanador('X')) {
                System.out.println(idiomas.Felicidades + idiomas.Has_ganado_el_juego);
                terminar = true;
            } else if (!hayEspacio()) {
                System.out.println(idiomas.Se_empato_el_juego);
                terminar = true;
            } else {
                registrarJugadaCPU('O');
                if (hayGanador('O')) {
                    System.out.println(idiomas.La_CPU + idiomas.Has_ganado_el_juego);
                    terminar = true;
                } else if (!hayEspacio()) {
                    System.out.println(idiomas.Se_empato_el_juego);
                    terminar = true;
                }
            }
        } while (!terminar);

        mostrarMenu();
    }

    private void registrarJugadaCPU(char caracter) {
        Random random = new Random();
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (tablero[fila][columna] != '-');
        tablero[fila][columna] = caracter;
        System.out.println(idiomas.Turno_de + idiomas.La_CPU + ":");
    }

    private void registrarJugadaUsuario(char caracter) {
        int seleccion;
        do {
            System.out.println(idiomas.Turno_de + idiomas.Jugador);
            System.out.println(idiomas.Ingresa_un_numero);
            seleccion = scanner.nextInt();
        } while (!posicionValida(seleccion) || !casillaDisponible(seleccion));
        marcarCasilla(seleccion, caracter);
    }

    private boolean posicionValida(int seleccion) {
        return seleccion >= 1 && seleccion <= 9;
    }

    private boolean casillaDisponible(int seleccion) {
        int fila = (seleccion - 1) / 3;
        int columna = (seleccion - 1) % 3;
        return tablero[fila][columna] == '-';
    }

    private void marcarCasilla(int seleccion, char caracter) {
        int fila = (seleccion - 1) / 3;
        int columna = (seleccion - 1) % 3;
        tablero[fila][columna] = caracter;
    }

    private void imprimirTablero() {
        System.out.println(idiomas.Tablero);
        System.out.println("-------------");
        int contador = 1;
        for (char[] fila : tablero) {
            System.out.print("| ");
            for (char casilla : fila) {
                if (casilla == '-') {
                    System.out.print(contador + " | ");
                } else {
                    System.out.print(casilla + " | ");
                }
                contador++;
            }
            System.out.println("\n-------------");
        }
    }

    private boolean hayGanador(char caracter) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == caracter && tablero[i][1] == caracter && tablero[i][2] == caracter) {
                return true;
            }
        }
        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == caracter && tablero[1][j] == caracter && tablero[2][j] == caracter) {
                return true;
            }
        }
        // Verificar diagonales
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private void mostrarMenu() throws IOException {
        System.out.println(idiomas.Que_deseas_hacer_CPU);

        int opcionMenu;

        if (scanner.hasNextInt()) {
            opcionMenu = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            if (opcionMenu == 1 || opcionMenu == 2) {
                switch (opcionMenu) {
                    case 1:
                        System.out.println(idiomas.Iniciando_juego);
                        inicializarTablero(); // Reinicializar el tablero para un nuevo juego
                        jugarConUsuario();
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
