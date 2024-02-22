package edu.luisguzman.reto3.ui;

import edu.luisguzman.reto3.diccionario.process.Diccionario;
import edu.luisguzman.reto3.diccionario.ui.CLI;

public class Main {
    public static void main(String[] args) {
        String[] palabras = {"Creativo", "Persuasión", "Volar", "Balance", "Repudio"};
        String[] significados = {
                "Capacidad de generar nuevas ideas o conceptos",
                "Capacidad de influir en las actitudes o comportamientos de otras personas",
                "Moverse o desplazarse por el aire",
                "Estado de equilibrio o estabilidad",
                "Rechazo o negación de algo"
        };

        // En esta parte se implementan las palabras con su significado por matrices

        Diccionario diccionario = new Diccionario(palabras, significados);
        CLI.showMenu(diccionario);
    }
}