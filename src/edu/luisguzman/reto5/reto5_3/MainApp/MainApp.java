package edu.luisguzman.reto5.reto5_3.MainApp;

import edu.luisguzman.reto5.reto5_3.process.ListaCompra;
import edu.luisguzman.reto5.reto5_3.process.Producto;

public class MainApp {
    public static void main(String[] args) {
        // Crear algunos productos
        Producto producto1 = new Producto("Leche", 1.5, 2);
        Producto producto2 = new Producto("Pan", 1.0, 3);
        Producto producto3 = new Producto("Manzanas", 2.0, 1);

        // Crear la lista de compras
        ListaCompra listaCompra = new ListaCompra();
        listaCompra.agregarProducto(producto1);
        listaCompra.agregarProducto(producto2);
        listaCompra.agregarProducto(producto3);

        // Mostrar la lista de compras
        mostrarListaCompra(listaCompra);
    }

    public static void mostrarListaCompra(ListaCompra listaCompra) {
        System.out.println("Lista de Compras:");
        System.out.println("Nombre\tPrecio\tCantidad\tImporte Total");
        for (Producto producto : listaCompra.getListaProductos()) {
            System.out.println(producto.getNombre() + "\t" +
                    producto.getPrecio() + "\t" +
                    producto.getCantidad() + "\t\t" +
                    producto.getImporteTotal());
        }
    }
}

