package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {       
        ArrayList <Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(6);
        lista.add(4);
        lista.add(8);
        EjercicioUno.order(lista);

        EjercicioUno.factura();
        
    }
}