package com.example.librosapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarLibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        Toast.makeText(AgregarLibroActivity.this, "Se muestra AgregarLibroActivity", Toast.LENGTH_SHORT).show();
    }
}
