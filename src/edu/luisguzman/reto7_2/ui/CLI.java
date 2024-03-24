package edu.luisguzman.reto7_2.ui;

import edu.luisguzman.reto7_2.process.*;

import java.util.Scanner;

public class CLI {

    private static Idiomas idiomas;

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        idiomas = new Esp(); // Por defecto en español
        launchApp();
    }

    public static void showMenuIdiomas() {
        System.out.println("Seleccione el idioma de su preferencia");
        System.out.println("1. Español");
        System.out.println("2. English");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                idiomas = new Esp();
                break;
            case 2:
                idiomas = new Eng();
                break;
            default:
                System.out.println("Opcion no disponible");
        }

        Multiplicacion.setLanguage(idiomas);
        Resta.setLanguage(idiomas);
        Potencia.setLanguage(idiomas);
        Raiz.setLanguage(idiomas);
        Suma.setLanguage(idiomas);
        Modulo.setLanguage(idiomas);
        Logaritmo.setLanguage(idiomas);
        Division.setLanguage(idiomas);

    }

    public static void launchApp() {
        int opcion;
        boolean continuar = true;
        showMenuIdiomas();

        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println(idiomas.MENU);

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(idiomas.SELECCION_SUMA);
                    Suma.suma(scanner);
                    break;

                case 2:
                    System.out.println(idiomas.SELECCION_RESTA);
                    Resta.resta(scanner);
                    break;

                case 3:
                    System.out.println(idiomas.SELECCION_MULTIPLICACION);
                    Multiplicacion.multiplicar(scanner);
                    break;

                case 4:
                    System.out.println(idiomas.SELECCION_DIVISION);
                    Division.dividir(scanner);
                    break;

                case 5:
                    System.out.println(idiomas.SELECCION_MODULO);
                    Modulo.modulo(scanner);
                    break;

                case 6:
                    System.out.println(idiomas.SELECCION_POTENCIA);
                    Potencia.potencia(scanner);
                    break;

                case 7:
                    System.out.println(idiomas.SELECCION_RAIZ);
                    Raiz.raizCuadrada(scanner);
                    break;

                case 8:
                    System.out.println(idiomas.SELECCION_LOGARITMO);
                    Logaritmo.logaritmo(scanner);
                    break;

                case 9:
                    System.out.println(idiomas.SELECCION_SALIR);
                    continuar = false;
                    break;

                default:
                    System.out.println(idiomas.DEFAULT);
                    break;
            }


            if (!continuar) {
                break;
            }

            System.out.print(idiomas.OTRA_OPERACION);
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase(idiomas.SI);
        }

        System.out.print(idiomas.Despedida);
    }
}
