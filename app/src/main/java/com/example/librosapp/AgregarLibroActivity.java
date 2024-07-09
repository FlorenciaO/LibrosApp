package com.example.librosapp;

import static com.example.librosapp.HomeActivity.PARAM_FOR_RESULT_LIBRO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librosapp.libros.Libro;

import java.util.Random;

public class AgregarLibroActivity extends AppCompatActivity {
    private EditText etNombreLibro;
    private EditText etAutor;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        setupUI();
    }

    private void setupUI() {
        etNombreLibro = findViewById(R.id.etNombreLibro);
        etAutor = findViewById(R.id.etAutor);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarLibro();
            }
        });
    }

    private void guardarLibro() {
        if (datosValidos()) {
            Integer id = crearId();
            String titulo = etNombreLibro.getText().toString();
            String autor = etAutor.getText().toString();
            Libro libro = new Libro(id, titulo, autor, Libro.ImagenId.PLACEHOLDER);
            // TODO(1. Enviar resultado a la activity previa -> HomeActivity)
            setResult(RESULT_OK, new Intent().putExtra(PARAM_FOR_RESULT_LIBRO, libro));
            finish();
        } else {
            Toast.makeText(AgregarLibroActivity.this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private Integer crearId() {
        Random ran = new Random();
        Integer valorMaximo = 10; // A modo de ejemplo
        Integer valorMinimo = 4; // Ids 1,2 y 3 ya estan creados
        return ran.nextInt(valorMaximo) + valorMinimo;
    }

    private boolean datosValidos() {
        boolean datosValidos = true;
        if (etNombreLibro.getText().toString().isEmpty() || etAutor.getText().toString().isEmpty()) {
            datosValidos = false;
        }
        return datosValidos;
    }
}
