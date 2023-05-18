package com.example.practica2java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.pesoEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);
    }

    public void calcularIMC(View view) {
        String pesoString = pesoEditText.getText().toString();
        String alturaString = alturaEditText.getText().toString();

        if (!pesoString.isEmpty() && !alturaString.isEmpty()) {
            try {
                double peso = Double.parseDouble(pesoString);
                double altura = Double.parseDouble(alturaString);

                double imc = peso / (altura * altura);
                resultadoTextView.setText(String.format("Tu IMC es: %.2f kg/m²", imc));
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Ingresa el Peso y la Altura", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Ingresa el Peso y la Altura", Toast.LENGTH_LONG).show();
        }

    }

    public void limpiarCampos(View view) {
        pesoEditText.setText("");
        alturaEditText.setText("");
        resultadoTextView.setText("");
    }

    public void cerrarApp(View view) {
        finish();
    }
}
