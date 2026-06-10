package org.example.patrones;

public class MetrosCentimetros implements EstrategiaConversion {
    private final double valorCm = 100;

    @Override
    public double convertir(double valor) {
        return valor * valorCm;
    }
}