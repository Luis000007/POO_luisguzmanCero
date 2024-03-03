package edu.luisguzman.reto5.reto5_4.MainApp;

public class MainApp {
    public static void main(String[] args) {
        // Crear algunos contactos
        Contacto contacto1 = new Contacto("Juan", "Calle 123", "123456789", "987654321");
        Contacto contacto2 = new Contacto("Maria", "Avenida 456", "987654321", "123456789");

        // Crear la agenda telefónica
        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
        agendaTelefonica.agregarContacto(contacto1);
        agendaTelefonica.agregarContacto(contacto2);

        // Mostrar la lista de contactos
        mostrarListaContactos(agendaTelefonica);
    }

    public static void mostrarListaContactos(AgendaTelefonica agendaTelefonica) {
        System.out.println("Agenda Telefónica:");
        System.out.println("Nombre\tDirección\tTeléfono Casa\tTeléfono Trabajo");
        for (Contacto contacto : agendaTelefonica.getListaContactos()) {
            System.out.println(contacto.getNombre() + "\t" +
                    contacto.getDireccion() + "\t" +
                    contacto.getTelefonoCasa() + "\t" +
                    contacto.getTelefonoTrabajo());
        }
    }
}
