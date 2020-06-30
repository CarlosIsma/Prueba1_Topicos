package com.example.appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText etPeso, etEstatura;
TextView resultado;
Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPeso =(EditText) findViewById(R.id.et1);
        etEstatura =(EditText) findViewById(R.id.et2);
        resultado=(TextView) findViewById(R.id.resul);
        btnCalcular=(Button) findViewById(R.id.Btn1);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, estaura, IMC;
                peso=Double.parseDouble(etPeso.getText().toString());
                estaura=Double.parseDouble(etEstatura.getText().toString());
                IMC=peso/Math.pow(estaura,2);
                resultado.setText(""+IMC);
            }
        });
    }
}