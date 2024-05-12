package edu.luisguzman.evidencia3.process;

import edu.luisguzman.evidencia3.Idiomas.Idiomas;
import edu.luisguzman.evidencia3.Ui.CLI;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CPU {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas) {
        CPU.idiomas = idiomas;
    }
    private char[][] tablero;
    private Scanner scanner;

    public CPU() {
        this.tablero = new char[3][3];
        this.scanner = new Scanner(System.in);
        inicializarTablero();
    }

    public static void maquina(Scanner scanner) throws IOException {
        CPU cpu = new CPU();
        cpu.jugarConUsuario(scanner);
    }

    public void jugarConUsuario(Scanner scanner) throws IOException {
        boolean terminar = false;

        do {
            imprimirTablero();
            registrarJugadaUsuario('X', scanner);
            if (hayGanador('X')) {
                System.out.println(idiomas.Felicidadess);
                terminar = true;
            } else if (!hayEspacio()) {
                System.out.println(idiomas.Empate);
                terminar = true;
            } else {
                realizarMovimiento('O');
                if (hayGanador('O')) {
                    imprimirTablero();
                    System.out.println(idiomas.Gano_la_CPU);
                    terminar = true;
                }
            }
        } while (!terminar);

        // Después de que el juego haya terminado, preguntar al usuario si desea jugar de nuevo o ir al menú
        mostrarMenu(scanner);
    }

    private void mostrarMenu(Scanner scanner) throws IOException {
        // Muestra el menú y espera la entrada del usuario
        System.out.println(idiomas.Que_deseas_hacer_CPU);

        int opcionCPU;

        if (scanner.hasNextInt()) {
            opcionCPU = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            // Verifica si la opción es válida (1 o 2)
            if (opcionCPU == 1 || opcionCPU == 2) {
                // Ejecuta las opciones según lo seleccionado por el usuario
                switch (opcionCPU) {
                    case 1:
                        System.out.println(idiomas.Iniciando_juego);
                        // Reiniciar el juego
                        reiniciarJuego();
                        break;
                    case 2:
                        System.out.println(idiomas.Regresando_al_menu);
                        CLI menu = new CLI(); // Crear una instancia de la clase CLI
                        menu.contra(scanner); // Llamar al método contra con la instancia creada
                        // Ir al menú
                        // Aquí puedes implementar la lógica para ir al menú
                        break;
                    default:
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

    private void reiniciarJuego() {
        inicializarTablero();
        try {
            jugarConUsuario(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void imprimirTablero() {
        System.out.println(idiomas.Tablero);
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
                System.out.println(idiomas.Turno_de + (caracter == 'X' ? idiomas.Jugador : idiomas.La_CPU));
                System.out.println(idiomas.Ingresa_un_numero);
                position = scanner.nextInt();
                if (position < 1 || position > 9) {
                    System.out.println(idiomas.Casilla_no_valida_elige_una_valida);
                } else if (!casillaNoOcupada(position)) {
                    System.out.println(idiomas.Casilla_no_valida_elige_una_valida);
                }
            } while (position < 1 || position > 9 || !casillaNoOcupada(position));

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
            System.out.println(idiomas.Turno_de_la_CPU);
            Random random = new Random();
            int position;
            do {
                position = random.nextInt(9) + 1;
            } while (!casillaNoOcupada(position));
            asignarMovimiento(position, caracter);
        }
    }
}
