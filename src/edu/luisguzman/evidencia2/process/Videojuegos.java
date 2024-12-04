package edu.luisguzman.evidencia2.process;

import edu.luisguzman.evidencia2.Ui.Idiomas;

import java.util.Scanner;

public class Videojuegos {
    private static Idiomas idiomas;

    public static void setLanguage(Idiomas idiomas){
        Videojuegos.idiomas = idiomas;
    }
    private static final double COSTO_BASE = 5.0;
    private static final double COSTO_RESERVA = 2.0;

    public static double videojuegos(Scanner scanner) {
        System.out.print(idiomas.VIDEOJUEGOSJUGADOSESTEMES);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase(idiomas.SI)) {
            System.out.print(idiomas.DIASJUGADOSDESPUESDELAFECHADECORTE);
            int diasJugadosVideojuegos = scanner.nextInt();
            scanner.nextLine();

            System.out.print(idiomas.VIDEOJUEGSRESERVADOS);
            int videojuegosReservados = scanner.nextInt();
            scanner.nextLine();

            return calcularCosto(diasJugadosVideojuegos, videojuegosReservados);
        } else {
            System.out.println(idiomas.NOJUGASTEESTEMES);
            return 0.0;
        }
    }

    public static double calcularCosto(int diasJugados, int videojuegosReservados) {
        double costoTotal = COSTO_BASE * diasJugados;
        costoTotal += COSTO_RESERVA * videojuegosReservados;
        return costoTotal;
    }
}
