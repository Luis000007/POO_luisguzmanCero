package edu.luisguzman.reto4.ui;

import edu.luisguzman.reto4.Data.Boleto;
import edu.luisguzman.reto4.Data.Pasajero;
import edu.luisguzman.reto4.Data.Ticket;
import edu.luisguzman.reto4.process.Usuario;

import java.util.ArrayList;

public class CLI {
    private final ArrayList<Boleto> listaVentas = new ArrayList<>();

    public void realizarVenta() {
        String comprador = Usuario.solicitarNombreCompleto();
        int cantidadBoletos = Usuario.solicitarCantidadBoletos();
        Boleto boleto = new Boleto(comprador, cantidadBoletos);

        for (int i = 0; i < cantidadBoletos - 1; i++) {
            String nombrePasajero = Usuario.solicitarNombrePasajero();
            boleto.agregarPasajero(new Pasajero(nombrePasajero));
        }

        Ticket.imprimirTicket(boleto);
        listaVentas.add(boleto);
    }

    public void mostrarDatos() {
        System.out.println("---- Lista de Ventas ----");
        for (Boleto boleto : listaVentas) {
            System.out.println("Comprador: " + boleto.getComprador());
            System.out.println("Cantidad de boletos: " + boleto.getCantidadBoletos());
            System.out.println("Pasajeros adicionales:");
            for (Pasajero pasajero : boleto.getPasajeros()) {
                System.out.println("- " + pasajero.getNombre());
            }
            System.out.println("--------------------------");
        }
        int cantidadTotalBoletos = listaVentas.stream().mapToInt(Boleto::getCantidadBoletos).sum();
        System.out.println("Importe total de la lista de boletos: $" + (cantidadTotalBoletos * 1250.50) + " MXN");
        int cantidadTotalPasajeros = cantidadTotalBoletos - listaVentas.size(); // Excluyendo al comprador
        System.out.println("Cantidad total de pasajeros registrados: " + cantidadTotalPasajeros);
    }
}