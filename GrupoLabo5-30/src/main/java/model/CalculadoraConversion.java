package model;

import patterns.strategy.EstrategiaConversion;

public class CalculadoraConversion {
    private EstrategiaConversion estrategia;

    public void setEstrategia(EstrategiaConversion e) {
        this.estrategia = e;
    }

    public double convertir(double valor) {
        if (estrategia == null) {
            throw new IllegalStateException("Estrategia de conversión no definida.");
        }
        return estrategia.convertir(valor);
    }
}