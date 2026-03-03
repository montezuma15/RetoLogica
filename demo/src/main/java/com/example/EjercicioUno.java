package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioUno {

    public static void order(ArrayList<Integer> lista) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j) < lista.get(j + 1)) {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void factura() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese cuantos productos va a llevar");
        int n = scanner.nextInt();

        ArrayList<Long> precios = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el valor del " + (i + 1) + " producto");
            precios.add(scanner.nextLong());
        }

        scanner.nextLine();
        System.out.println("Ingrese su cupon de descuento o escriba NONE si no se tiene uno");
        String cupon = scanner.nextLine();
        System.out.println("Ingrese el costo de envio");
        long envio = scanner.nextLong();

        calcularTotal(precios, cupon, envio);
    }

    public static void calcularTotal(ArrayList<Long> precios, String cupon, long envio) {

        long subtotal = calcularSubtotal(precios);
        long descuento = 0;

        switch (cupon) {
            case "DESC10":
                descuento = Math.round(subtotal * 0.10);
                break;

            case "DESC20":
                if (subtotal >= 200000) {
                    descuento = Math.round(subtotal * 0.20);
                }
                break;

            case "FREESHIP":
                envio = 0;
                break;

            case "NONE":
            default:
                break;
        }

        long base = subtotal - descuento;

        long iva = Math.round(base * 0.19);

        long total = base + iva + envio;

        System.out.println("SUBTOTAL " + subtotal);
        System.out.println("DESCUENTO " + descuento);
        System.out.println("IVA " + iva);
        System.out.println("ENVIO " + envio);
        System.out.println("TOTAL " + total);
    }

    public static long calcularSubtotal(ArrayList<Long> precios) {
        long suma = 0;
        for (int i = 0; i < precios.size(); i++) {
            suma += precios.get(i);
        }
        return suma;
    }
}
