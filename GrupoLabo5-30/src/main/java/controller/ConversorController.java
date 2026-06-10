package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.CalculadoraConversion;
import patterns.strategy.CentimetrosMetros;
import patterns.strategy.MetrosCentimetros;

public class ConversorController {

    @FXML private TextField txtCantidad;
    @FXML private ComboBox<String> cbDe;
    @FXML private ComboBox<String> cbA;
    @FXML private Label lblResultado;

    private CalculadoraConversion calculadora;

    @FXML
    public void initialize() {
        calculadora = new CalculadoraConversion();
        cbDe.getItems().addAll("Metros", "Centímetros");
        cbA.getItems().addAll("Metros", "Centímetros");
        cbDe.setValue("Metros");
        cbA.setValue("Centímetros");
    }

    @FXML
    public void onConvertirClick() {
        try {
            double cantidad = Double.parseDouble(txtCantidad.getText());
            String unidadOrigen = cbDe.getValue();
            String unidadDestino = cbA.getValue();
            double resultado = 0;

            if (unidadOrigen.equals("Metros") && unidadDestino.equals("Centímetros")) {
                calculadora.setEstrategia(new MetrosCentimetros());
                resultado = calculadora.convertir(cantidad);
                lblResultado.setText(String.format("%.2f mt. equivalen a %.2f cm.", cantidad, resultado));
            } else if (unidadOrigen.equals("Centímetros") && unidadDestino.equals("Metros")) {
                calculadora.setEstrategia(new CentimetrosMetros());
                resultado = calculadora.convertir(cantidad);
                lblResultado.setText(String.format("%.2f cm. equivalen a %.4f mt.", cantidad, resultado));
            } else {
                lblResultado.setText("Las unidades de origen y destino son iguales.");
            }
            lblResultado.getStyleClass().remove("error-text");

        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Ingrese un valor numérico válido.");
            lblResultado.getStyleClass().add("error-text");
        }
    }
}