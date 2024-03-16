package edu.luisguzman.reto5.reto5_5.MainApp;

import edu.luisguzman.reto5.reto5_5.process.Articulo;
import edu.luisguzman.reto5.reto5_5.process.CarritoCompras;

public class MainApp {
    public static void main(String[] args) {
        // Crear algunos artículos
        Articulo articulo1 = new Articulo(15.99, 2, 0.16);
        Articulo articulo2 = new Articulo(29.99, 1, 0.16);
        Articulo articulo3 = new Articulo(39.99, 1, 0.16);

        // Crear el carrito de compras
        CarritoCompras carrito = new CarritoCompras();
        carrito.agregarArticulo(articulo1);
        carrito.agregarArticulo(articulo2);
        carrito.agregarArticulo(articulo3);

        // Mostrar la lista de artículos en el carrito
        mostrarCarritoCompras(carrito);
    }

    public static void mostrarCarritoCompras(CarritoCompras carrito) {
        System.out.println("Carrito de Compras:");
        System.out.println("Nombre\tPrecio Unitario\tCantidad\tIVA\tImporte Neto");
        for (Articulo articulo : carrito.getListaArticulos()) {
            System.out.println(articulo.getNombre() + "\t" +
                    articulo.getPrecioUnitario() + "\t\t" +
                    articulo.getCantidad() + "\t\t" +
                    articulo.getIva() + "\t" +
                    articulo.getImporteNeto());
        }
    }
}
