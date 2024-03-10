package edu.luisguzman.reto6.process;

import javax.swing.*;

public class Categorias {
    public static void main(String[] args) {

        boolean continuar = true;

        int totalHorasLaboradas = 0;
        int totalHorasExtras = 0;
        int totalPersonasConHorasExtras = 0;
        int totalPersonasSinHorasExtras = 0;
        double totalSueldoNormal = 0;
        double totalPagoHorasExtras = 0;


        while (continuar) {
            int horastrabajadas;
            float salariototal;


            String categoria = JOptionPane.showInputDialog("Digite la categoria a la que pertenece");

            switch (categoria) {
                case "Ventas":

                    Empleado.ingresarDatosEmpleado();

                    horastrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de horas trabajadas"));

                    if (horastrabajadas <= 40) {
                        salariototal = horastrabajadas * 100;
                        totalSueldoNormal += salariototal;
                    } else {
                        salariototal = (40 * 100) + ((horastrabajadas - 40) * 50);
                        totalSueldoNormal += (40 * 100);
                        totalPagoHorasExtras += ((horastrabajadas - 40) * 50);
                        totalHorasExtras += (horastrabajadas - 40);
                        totalPersonasConHorasExtras++;
                    }

                    JOptionPane.showMessageDialog(null, "El salario total es: " + salariototal);
                    break;

                case "Administrador":

                    Empleado.ingresarDatosEmpleado();

                    horastrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de horas trabajadas"));

                    if (horastrabajadas <= 40) {
                        salariototal = horastrabajadas * 180;
                        totalSueldoNormal += salariototal;
                    } else {
                        salariototal = (40 * 180) + ((horastrabajadas - 40) * 100);
                        totalSueldoNormal += (40 * 180);
                        totalPagoHorasExtras += ((horastrabajadas - 40) * 100);
                        totalHorasExtras += (horastrabajadas - 40);
                        totalPersonasConHorasExtras++;
                    }

                    JOptionPane.showMessageDialog(null, "El salario total es: " + salariototal);
                    break;

                case "Gerente":

                    Empleado.ingresarDatosEmpleado();

                    horastrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de horas trabajadas"));

                    if (horastrabajadas <= 40) {
                        salariototal = horastrabajadas * 250;
                        totalSueldoNormal += salariototal;
                    } else {
                        salariototal = (40 * 250) + ((horastrabajadas - 40) * 150);
                        totalSueldoNormal += (40 * 250);
                        totalPagoHorasExtras += ((horastrabajadas - 40) * 150);
                        totalHorasExtras += (horastrabajadas - 40);
                        totalPersonasConHorasExtras++;
                    }

                    totalHorasLaboradas += horastrabajadas;

                    JOptionPane.showMessageDialog(null, "El salario total es: " + salariototal);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Tu puesto no aparece en la nómina");
                    break;
            }

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar datos para otro empleado?", "Continuar", JOptionPane.YES_NO_OPTION);
            continuar = (opcion == JOptionPane.YES_OPTION);
            if (!continuar) break;
        }

        totalPersonasSinHorasExtras = (totalPersonasConHorasExtras == 0) ? totalHorasLaboradas : (totalHorasLaboradas / 40) - totalPersonasConHorasExtras;

        System.out.println("Reporte de nómina:");
        System.out.println("Total de la nómina de la empresa: ");
        System.out.println("Total a pagar por sueldo normal: " + totalSueldoNormal);
        System.out.println("Total a pagar por horas extras: " + totalPagoHorasExtras);
        System.out.println("Total de horas laboradas en la empresa: " + totalHorasLaboradas);
        System.out.println("Total de personas que tienen horas extras: " + totalPersonasConHorasExtras);
        System.out.println("Total de personas que no tienen horas extras: " + totalPersonasSinHorasExtras);
    }

}


