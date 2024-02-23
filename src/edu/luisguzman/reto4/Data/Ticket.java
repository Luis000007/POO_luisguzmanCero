package edu.luisguzman.reto4.Data;

public class Ticket {
    public static void imprimirTicket(Boleto boleto) {
        double importeTotal = 1250.50 * boleto.getCantidadBoletos();
        System.out.println("---- Ticket de Venta ----");
        System.out.println("Comprador: " + boleto.getComprador());
        System.out.println("Cantidad de boletos: " + boleto.getCantidadBoletos());
        System.out.println("Importe total: $" + importeTotal + " MXN");
        System.out.println("*************************");
    }
}
