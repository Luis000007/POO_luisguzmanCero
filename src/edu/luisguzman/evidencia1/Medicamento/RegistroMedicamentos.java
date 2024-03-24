package edu.luisguzman.evidencia1.Medicamento;

import edu.luisguzman.evidencia1.process.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class RegistroMedicamentos {
    private final Usuario usuario;
    private final ArrayList<Medicamento> listaMedicamentos;

    public RegistroMedicamentos(Usuario usuario) {
        this.usuario = usuario;
        this.listaMedicamentos = new ArrayList<>();
    }

    public void registrarMedicamento(Medicamento medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public void generarReporte() {
        System.out.println("\nReporte de Medicamentos");
        System.out.println("Usuario: " + usuario.getNombreUsuario());
        System.out.println("Fecha de generación: " + new Date());
        System.out.println("Cantidad de productos en la lista: " + listaMedicamentos.size());
        System.out.println("Detalle de medicamentos:");

        for (Medicamento medicamento : listaMedicamentos) {
            System.out.println(medicamento.toString());
        }
    }
}

