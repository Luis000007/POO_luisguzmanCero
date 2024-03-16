package edu.luisguzman.reto6.process;

import javax.swing.*;

public class Empleado {


    public static void ingresarDatosEmpleado() {
        String NombreCompleto = JOptionPane.showInputDialog("Digita su nombre completo");
        int Telefono = Integer.parseInt(JOptionPane.showInputDialog("Digita tu numero telefonico"));
        int Edad = Integer.parseInt(JOptionPane.showInputDialog("Digita tu edad"));

    }

    public static void main(String[] args) {

    }
}

/* En esta clase, para no hacer la clase "Categorias mas larga, decidi hacer una clase co variables que
almacen los datos necesarios y mandalos a llamar con un metodo
 */