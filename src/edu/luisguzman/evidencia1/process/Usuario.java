package edu.luisguzman.evidencia1.process;

public class Usuario {
    private final String nombreUsuario;
    private final String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        return this.nombreUsuario.equals(nombreUsuario) && this.contrasena.equals(contrasena);
    }

    public String getNombreUsuario() {
        return null;
    }
}
