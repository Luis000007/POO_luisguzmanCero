package edu.luisguzman.reto5.reto5_3.process;

import java.util.ArrayList;
import java.util.List;

public class ListaCompra {
    private final List<Producto> listaProductos;

    public ListaCompra() {
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
