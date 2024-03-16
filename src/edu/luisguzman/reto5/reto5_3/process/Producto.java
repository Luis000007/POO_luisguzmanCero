package edu.luisguzman.reto5.reto5_3.process;

public class Producto {
    private final String nombre;
    private final double precio;
    private final int cantidad;
    private final double importeTotal;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importeTotal = precio * cantidad;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImporteTotal() {
        return importeTotal;
    }
}

