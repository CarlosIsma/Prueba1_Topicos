package com.example.appimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {
    EditText autname, autclave, autemail, autcel;
    Button btn1;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        autname=findViewById(R.id.autName);
        autclave=findViewById(R.id.autClave);
        autemail=findViewById(R.id.autMail);
        autcel=findViewById(R.id.autCel);
        btn1=findViewById(R.id.Btn1);


        fAuth=FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = autemail.getText().toString().trim();
                String password = autclave.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    autemail.setError("Por favor Ingrese Un Correo");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    autclave.setError("Por favor Ingrese La Clave");
                    return;
                }
                if (password.length() < 8) {
                    autclave.setError("La Clave Debe Ser Mas Larga");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Registro.this, "Usuario Creado Exitosamente", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Registro.this, "Usuario No Creado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}