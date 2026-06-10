package patterns.strategy;

public class CentimetrosMetros implements EstrategiaConversion {
    private final double valorMt = 0.01;

    @Override
    public double convertir(double valor) {
        return valor * valorMt;
    }
}