package edu.luisguzman.reto5.reto5_4.process;

public class Contacto {
    private final String nombre;
    private final String direccion;
    private final String telefonoCasa;
    private final String telefonoTrabajo;

    public Contacto(String nombre, String direccion, String telefonoCasa, String telefonoTrabajo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoCasa = telefonoCasa;
        this.telefonoTrabajo = telefonoTrabajo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }
}
