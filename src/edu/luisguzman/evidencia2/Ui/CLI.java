package edu.luisguzman.evidencia2.Ui;

import java.util.Scanner;
import edu.luisguzman.evidencia2.usuario.Usuario;
import edu.luisguzman.evidencia2.process.Canciones;
import edu.luisguzman.evidencia2.process.Libros;
import edu.luisguzman.evidencia2.process.Peliculas;
import edu.luisguzman.evidencia2.process.Videojuegos;

public class CLI {
    private static Idiomas idiomas;
    public static void main(String[] args) {
        idiomas = new Esp();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {

            System.out.println("********** Bienvenido a TecmiFlix **********");
            System.out.println("Iniciar sesión");
            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            Usuario usuario = new Usuario();

            if (usuario.autenticar(nombreUsuario, contrasena)) {
                System.out.println("Inicio de sesión exitosa. Bienvenido, " + usuario.getUsuario() + "!");
                continuar = false;
            } else {
                System.out.println("Tu nombre de usuario o contraseña son incorrectos. Por favor, inténtalo de nuevo.");
            }
        }

        int opcion = 0;

        while (opcion != 1 && opcion != 2) {
            System.out.println("Selecciona el idioma de su preferencia");
            System.out.println("1. Español");
            System.out.println("2. English");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    idiomas = new Esp();
                    break;
                case 2:
                    idiomas = new Eng();
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
            System.out.println(idiomas.INGRESARDATOSDELMES);

            // Set the language
            Canciones.setLanguage(idiomas);
            Libros.setLanguage(idiomas);
            Peliculas.setLanguage(idiomas);
            Videojuegos.setLanguage(idiomas);

            // Mandar a llamar las funcionalidades de las clases y capturar los costos
            double costoCanciones = Canciones.canciones(scanner);
            double costoLibros = Libros.libros(scanner);
            double costoPeliculas = Peliculas.peliculas(scanner);
            double costoVideojuegos = Videojuegos.videojuegos(scanner);

            // Calcular costo total y mostrarlos al usuario
            double costoTotal = costoCanciones + costoLibros + costoPeliculas + costoVideojuegos;

            System.out.println("******************************************");
            System.out.println(idiomas.COSTODECANCIONES + costoCanciones);
            System.out.println(idiomas.COSTODELIBROS + costoLibros);
            System.out.println(idiomas.COSTODEPELICULAS + costoPeliculas);
            System.out.println(idiomas.COSTODEVIDEOJUEGOS + costoVideojuegos);
            System.out.println("******************************************");
            System.out.println(idiomas.COSTOTOTAL + costoTotal);

            scanner.close();
        }
    }
}
