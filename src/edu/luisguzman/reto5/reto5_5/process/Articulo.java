package edu.luisguzman.reto5.reto5_5.process;

public class Articulo {
    private final double precioUnitario;
    private final int cantidad;
    private final double iva;

    public Articulo(double precioUnitario, int cantidad, double iva) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.iva = iva;
    }

    private double calcularImporteNeto() {
        return precioUnitario * cantidad * (1 + iva);
    }

    public Object getIva() {
        return null;
    }

    public Object getCantidad() {
        return null;
    }

    public Object getPrecioUnitario() {
        return null;
    }

    public Object getImporteNeto() {
        return null;
    }

    public boolean getNombre() {
        return false;
    }

    // Getters y setters
}
