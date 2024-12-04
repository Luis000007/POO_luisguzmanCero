package edu.luisguzman.evidencia2.process;

import edu.luisguzman.evidencia2.Ui.Idiomas;

import java.util.Scanner;

public class Peliculas {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas){
        Peliculas.idiomas = idiomas;
    }
    private static final double COSTO_BASE = 7.0;
    private static final double COSTO_BASE_ESTRENO = 15.0;

    public static double peliculas(Scanner scanner) {
        System.out.print(idiomas.VISTEPELICULASESTEMES);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase(idiomas.SI)) {
            System.out.print(idiomas.PELICULASESTRENO);
            boolean esEstrenoPelicula = scanner.nextLine().equalsIgnoreCase(idiomas.SI);

            System.out.print(idiomas.PELICULASRESERVADAS);
            int cantidadReservadas = scanner.nextInt();
            scanner.nextLine();

            return calcularCosto(esEstrenoPelicula, cantidadReservadas);
        } else {
            System.out.println(idiomas.NOVISTEPELICULASESTEMES);
            return 0.0;
        }
    }

    public static double calcularCosto(boolean esEstreno, int cantidadReservadas) {
        double costoBase = esEstreno ? COSTO_BASE_ESTRENO : COSTO_BASE;
        return costoBase * cantidadReservadas;
    }
}
