package edu.luisguzman.evidencia1;

import edu.luisguzman.evidencia1.Medicamento.Medicamento;
import edu.luisguzman.evidencia1.Medicamento.RegistroMedicamentos;
import edu.luisguzman.evidencia1.process.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Autenticación del usuario
        System.out.println("Ingrese nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese contraseña:");
        String contrasena = scanner.nextLine();

        Usuario usuario = new Usuario("Luis", "12345"); // Usuario por defecto

        if (usuario.autenticar(nombreUsuario, contrasena)) {
            RegistroMedicamentos registro = new RegistroMedicamentos(usuario);

            // Registro de medicamentos
            while (true) {
                System.out.println("Ingrese nombre químico del medicamento (o 'salir' para terminar):");
                String nombreQuimico = scanner.nextLine();
                if (nombreQuimico.equalsIgnoreCase("salir")) {
                    break;
                }
                System.out.println("Ingrese nombre genérico del medicamento:");
                String nombreGenerico = scanner.nextLine();
                System.out.println("Ingrese nombre registrado del medicamento:");
                String nombreRegistrado = scanner.nextLine();
                System.out.println("Ingrese precio al público del medicamento:");
                double precioPublico = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.println("Ingrese forma farmacéutica del medicamento (solido, semisolido, liquido):");
                String formaFarmaceutica = scanner.nextLine();

                // Crear instancia de Medicamento y agregarlo al registro
                Medicamento medicamento = new Medicamento(nombreQuimico, nombreGenerico,
                        nombreRegistrado, precioPublico, formaFarmaceutica);
                registro.registrarMedicamento(medicamento);
            }

            // Generación de reporte
            registro.generarReporte();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Saliendo del programa...");
        }
    }
}

