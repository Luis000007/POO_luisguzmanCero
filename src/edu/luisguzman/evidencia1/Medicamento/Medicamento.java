package edu.luisguzman.evidencia1.Medicamento;

public class Medicamento {
    private final String nombreQuimico;
    private final String nombreGenerico;
    private final String nombreRegistrado;
    private final double precioPublico;
    private final double precioVenta;
    private final String formaFarmaceutica;

    public Medicamento(String nombreQuimico, String nombreGenerico, String nombreRegistrado,
                       double precioPublico, String formaFarmaceutica) {
        this.nombreQuimico = nombreQuimico;
        this.nombreGenerico = nombreGenerico;
        this.nombreRegistrado = nombreRegistrado;
        this.precioPublico = precioPublico;
        this.formaFarmaceutica = formaFarmaceutica;
        this.precioVenta = calcularPrecioVenta();
    }

    private double calcularPrecioVenta() {
        double porcentajeAdicional = switch (formaFarmaceutica) {
            case "solido" -> 0.09;
            case "semisolido" -> 0.12;
            case "liquido" -> 0.13;
            default -> 0.0;
        };
        return precioPublico * (1 + porcentajeAdicional);
    }

    public String toString() {
        return "Nombre Químico: " + nombreQuimico + ", Nombre Genérico: " + nombreGenerico +
                ", Nombre Registrado: " + nombreRegistrado + ", Precio al Público: $" +
                precioPublico + ", Precio de Venta: $" + precioVenta + ", Forma Farmacéutica: " +
                formaFarmaceutica;
    }
}
