package edu.luisguzman.reto7.process;

import java.util.Scanner;

public class Calculos {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        float precio, pago, cambio, faltante;


        System.out.println("Ingrese el precio del articulo");
        precio=lector.nextFloat();
        System.out.println("Cantidad recibida");
        pago = lector.nextFloat();

        cambio = pago - precio;
        faltante = precio - pago;

        if (cambio < 0) {
            System.out.println("Falta dinero en el pago. El dinero faltante es " + (-faltante));
        } else if (cambio == 0) {
            System.out.println("Se pagó exactamente");
        } else if (cambio > 0) {
            System.out.println("El cambio a dar es " + cambio);
            }
        }
    }





/*
        float pequeño_sin_azucar = 10.50F;
        float pequeño_con_azucar = 14.50F;
        float mediano_con_azucar = 24.50F;
        float mediano_sin_azucar = 34.50F;
        float grande_con_azucar = 34.50F;
        float grande_sin_azucar = 39.50F;
 */