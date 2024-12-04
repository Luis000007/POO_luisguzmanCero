package edu.luisguzman.evidencia2.process;

import edu.luisguzman.evidencia2.Ui.Idiomas;

import java.util.Scanner;

public class Canciones {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas){
        Canciones.idiomas = idiomas;
    }
    private static final double COSTO_BASE = 5.0;
    private static final double COSTO_ESTRENO = 1.50;

    public static double canciones(Scanner scanner) {
        System.out.print(idiomas.ESCUCHASTEMUSICADURANTEELMES);
        if (scanner.nextLine().equalsIgnoreCase(idiomas.SI)) {
            System.out.print(idiomas.NUMERODEREPRODUCCIONES);
            int reproduccionesCanciones = scanner.nextInt();
            scanner.nextLine();
            System.out.print(idiomas.CANCIONESDEESTRENO);
            boolean esEstreno = scanner.nextLine().equalsIgnoreCase(idiomas.SI);
            double costoTotal = calcularCosto(reproduccionesCanciones, esEstreno);
            System.out.println(idiomas.COSTOTOTALDELACANCION + costoTotal);
            return costoTotal;
        } else {
            System.out.println(idiomas.NOESCUCHASTECANCIONES);
            return 0.0;
        }
    }

    public static double calcularCosto(int reproducciones, boolean esEstreno) {
        double costoTotal = COSTO_BASE + 0.50 * reproducciones;
        if (esEstreno) {
            costoTotal += COSTO_ESTRENO;
        }
        return costoTotal;
    }
}