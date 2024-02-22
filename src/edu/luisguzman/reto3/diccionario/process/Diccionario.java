package edu.luisguzman.reto3.diccionario.process;

import java.util.Arrays;

public class Diccionario {
    private final String[] palabras;
    private String[] significados;

    public Diccionario(String[] palabras, String[] significados) {
        this.palabras = palabras;
        this.significados = significados;
    }

    public String buscarSignificados(String palabra){
        return getDescription(buscarIndice(palabra));
    }

    private int buscarIndice(String palabra){
        int index = 0;
        boolean found = false;
        while(index < palabras.length && !found ){
            if(palabra.equalsIgnoreCase(palabras[index])) return index;
            index++;
        }
        return -1;
    }

    // Esto es un bucle, lo que hace es que mostrara las opciones disponibles una y otra vez hasta que se seleccione la opvion "Salir del programa"

    public String getDescription(int index){
        if(index == -1) return "La palabra que busca no está en el diccionario";
        return significados[index];
    }

    public void printList(){
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i] + ": " + significados[i]);
        }
    }

    public void detalleDiccionario() {
    }
}