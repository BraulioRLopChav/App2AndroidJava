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

        if (pesoString.equals("") || alturaString.equals("")) {
            Toast.makeText(MainActivity.this,
                    "Ingresa el Peso y la Altura",Toast.LENGTH_SHORT).show();
        } else {
            float peso = Float.parseFloat(pesoString);
            float altura = Float.parseFloat(alturaString) / 100;

            float imc = peso / (altura * altura);
            DecimalFormat df = new DecimalFormat("#.##");
            String imcRedondeado = df.format(imc);

            resultadoTextView.setText(String.format("Tu IMC es: %s kg/m²", imcRedondeado));
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
