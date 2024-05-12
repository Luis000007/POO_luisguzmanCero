package edu.luisguzman.evidencia3.Idiomas;

public class Eng extends Idiomas {
    public Eng(){

        // CLI
        Bienvenido_a_gato = "********** Welcome to Gato ***********";
        Menu_idiomas = "Select the language of your choice\n1. Spanish\n2. English\nEnter a number: ";
        Opcion_invalida_1_2 = "Invalid option. Please select 1 for Spanish or 2 for English.";
        Opcion_invalida = "Invalid option. Please enter a valid option.";
        Seleccion_Esp = "Has seleccionado: Español";
        Seleccion_Eng = "You have selected: English";
        Instrucciones = "************************************** Instructions ****************************************" +
                "\n- You can choose any box that contains a number" +
                "\n- Cells that appear with 'X' or 'O' are already occupied and cannot be selected" +
                "\n- The first to make a line of three 'X' or 'O' is the winner" +
                "\n¡good luck!" +
                "\n************************************************************************************************";
        Modo_de_juego = "*******************************************\n" +
                "Choose a mode of play\n" +
                "1. Play against another player\n" +
                "2. Play against the CPU\n" +
                "3. Exit from the program\n" +
                "Enter a number: ";
        Jugar_contra_jugador = "*******************************************\n" +
                "You have selected: Play against another player";
        Jugar_contra_CPU = "*******************************************\n" +
                "You’ve selected: Play against CPU";
        Gracias_por_jugar = "thanks for playing :D";
        Saliendo = "leaving...";

        // Vs
        Tablero = "Board:";
        Jugadro1_Caracter = "Player 1, please choose your character (*, +, $, X, O)\n" +
                "Select the character of your preference: ";
        Jugador2_Caracter = "Player 2, please choose your character (*, +, $, X, O):\n" +
                "Select the character of your preference: ";
        Jugador1_Nombre = "Player name 1: ";
        Jugador2_Nombre = "Player name 2: ";
        Felicidades = "Congratulations ";
        Has_ganado_el_juego = " you’ve won the game";
        Se_empato_el_juego = "No more boxes available, the game was tied";
        Que_deseas_hacer_Vs = "******************************************\n" +
                "¿Want to play a new game or go to the menu?\n" +
                "1. Play a new game\n" +
                "2. Go to the main menu\n" +
                "Enter the desired selection number: ";
        Iniciando_juego = "******************\n" +
                "Starting game...";
        Regresando_al_menu = "*********************\n" +
                "Back to the main menu...";
        Turno_de = "Turno de ";
        Ingresa_un_numero = "Enter a number: ";
        Casilla_no_valida_elige_una_valida = "Invalid box, please choose a valid box.";

        // CPU
        Felicidadess = "¡Congratulations! You have won!";
        Empate = "Tie! No boxes are available.";
        Gano_la_CPU = "The CPU has won!";
        Que_deseas_hacer_CPU = "******************************************\n" +
                "Want to play a new game or go to the menu?\n" +
                "1. Play again\n" +
                "2. Go to the menu\n" +
                "Enter the desired selection number: ";
        Jugador = "player";
        La_CPU = "the CPU";
        Turno_de_la_CPU = "Turn of the CPU";

    }
}
