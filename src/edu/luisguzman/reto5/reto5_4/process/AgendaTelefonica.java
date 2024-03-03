package edu.luisguzman.reto5.reto5_4.process;

import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica {
    private final List<Contacto> listaContactos;

    public AgendaTelefonica() {
        listaContactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
    }

    public List<Contacto> getListaContactos() {
        return listaContactos;
    }
}

