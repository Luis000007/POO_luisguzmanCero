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
