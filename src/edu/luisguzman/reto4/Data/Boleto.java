package edu.luisguzman.reto4.Data;

import java.util.ArrayList;

public class Boleto {
    private final String comprador;
    private final int cantidadBoletos;
    private final ArrayList<Pasajero> pasajeros;

    public Boleto(String comprador, int cantidadBoletos) {
        this.comprador = comprador;
        this.cantidadBoletos = cantidadBoletos;
        this.pasajeros = new ArrayList<>();
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public String getComprador() {
        return comprador;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }
}

