package edu.luisguzman.evidencia2.process;

import edu.luisguzman.evidencia2.Ui.Idiomas;

import java.util.Scanner;

public class Libros {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas){
        Libros.idiomas = idiomas;
    }
    public static double libros(Scanner scanner) {

        final double COSTO_BASE = 5.0; // Costo base de todos los libros

        System.out.print(idiomas.LEISTEDURANTEELMES);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase(idiomas.SI)) {

            System.out.print(idiomas.NUMERODEDIASLEIDOSDESPUESDELCORTE);
            int diasLecturaLibros = scanner.nextInt();
            scanner.nextLine();

            System.out.print(idiomas.GENEROLIBRO);
            String generoLibros = scanner.nextLine();

            System.out.print(idiomas.LIBRODEESTRENO);
            boolean esEstrenoLibros = scanner.nextLine().equalsIgnoreCase(idiomas.SI);

            // Calcular costo de libros
            return calcularCosto(COSTO_BASE, diasLecturaLibros, generoLibros, esEstrenoLibros);
        } else {
            System.out.println(idiomas.NOLEISTEDURANTEELMES);
            return 0.0;
        }
    }

    public static double calcularCosto(double costoBase, int diasLectura, String genero, boolean esEstreno) {
        final double COSTO_NOVELA = 2.0;
        final double COSTO_TECNOLOGIA = 3.0;
        final double COSTO_ESTRENO = 0.5;

        double costoTotal = costoBase * diasLectura; // Costo base multiplicado por los días de lectura

        // Calcular costos adicionales según el género
        if (genero.equalsIgnoreCase(idiomas.NOVELA)) {
            costoTotal += COSTO_NOVELA * diasLectura; // Costo adicional para libros de género novela
        } else if (genero.equalsIgnoreCase(idiomas.TECNOLOGIA)) {
            costoTotal += COSTO_TECNOLOGIA * diasLectura; // Costo adicional para libros de género tecnología
        }

        // Agregar costo adicional para libros estreno
        if (esEstreno) {
            costoTotal += COSTO_ESTRENO * diasLectura;
        }

        return costoTotal;
    }
}
