package edu.luisguzman.reto5.reto5_5.process;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private final List<Articulo> listaArticulos;

    public CarritoCompras() {
        listaArticulos = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo) {
        listaArticulos.add(articulo);
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }
}
