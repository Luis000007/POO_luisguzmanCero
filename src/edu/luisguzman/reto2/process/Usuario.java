package edu.luisguzman.reto2.process;

public class Usuario {
    private String usuario = "Maclein";
    private String contraseña = "77777";

    public Usuario() {
        // Constructor de la clase Usuario
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean autenticar(String usuario, String contraseña) {
        return this.usuario.equals(usuario) && this.contraseña.equals(contraseña);
    }
}
