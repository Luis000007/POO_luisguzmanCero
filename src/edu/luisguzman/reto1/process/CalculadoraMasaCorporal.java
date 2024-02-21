// CalculadoraMasaCorporal.java
package edu.luisguzman.reto1.process;

import java.util.Scanner;

public class CalculadoraMasaCorporal {
    public static void calcularIMC() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el peso en kg:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese la estatura en cm:");
        double estatura = scanner.nextDouble() / 100; // Convertir a metros

        double imc = peso / (estatura * estatura);
        System.out.println("Su IMC es: " + imc);

        if (imc < 18.5) {
            System.out.println("Peso bajo");
        } else if (imc >= 18.5 && imc <= 24.99) {
            System.out.println("Peso normal");
        } else if (imc >= 25 && imc <= 29.99) {
            System.out.println("Sobrepeso");
        } else if (imc >= 30 && imc <= 34.99) {
            System.out.println("Obesidad leve");
        } else if (imc >= 35 && imc <= 39.99) {
            System.out.println("Obesidad media");
        } else {
            System.out.println("Obesidad mórbida");
        }
        scanner.close();
    }

    public static void calcularMasaCorporalMagra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el peso en kg:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese la estatura en cm:");
        double estatura = scanner.nextDouble();
        System.out.println("Ingrese el sexo del paciente (M/F):");
        char sexo = scanner.next().charAt(0);

        double masaCorporalMagra;
        if (sexo == 'M') {
            masaCorporalMagra = (1.10 * peso) - 128 * (peso * peso) / (estatura * estatura);
        } else {
            masaCorporalMagra = (1.07 * peso) - 148 * (peso * peso) / (estatura * estatura);
        }

        System.out.println("La masa corporal magra es: " + masaCorporalMagra);
        scanner.close();
    }

    public static void calcularMetabolismoBasal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el peso en kg:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese la estatura en cm:");
        double estatura = scanner.nextDouble();
        System.out.println("Ingrese la edad del paciente:");
        int edad = scanner.nextInt();
        System.out.println("Ingrese el sexo del paciente (M/F):");
        char sexo = scanner.next().charAt(0);

        double metabolismoBasal;
        if (sexo == 'M') {
            metabolismoBasal = 66.5 + (13.75 * peso) + (5.003 * estatura) - (6.775 * edad);
        } else {
            metabolismoBasal = 655.1 + (9.563 * peso) + (1.85 * estatura) - (4.676 * edad);
        }

        System.out.println("El metabolismo basal es: " + metabolismoBasal);
        scanner.close();
    }
}
