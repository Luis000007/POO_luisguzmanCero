package edu.luisguzman.evidencia2.usuario;

public class Usuario {
    private String usuario = "Luis Guzman";
    private String pasword = "Mariomario";

    public Usuario() {
        // Constructor de la clase Usuario
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPasword() {
        return pasword;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public boolean autenticar(String usuario, String pasword) {
        return this.usuario.equals(usuario) && this.pasword.equals(pasword);
    }
}

