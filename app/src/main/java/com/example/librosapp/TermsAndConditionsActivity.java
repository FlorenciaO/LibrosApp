package com.example.librosapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class TermsAndConditionsActivity extends AppCompatActivity {


    private SharedPreferences preferences;
    private CheckBox aceptarTermsAndCondCheckBox;
    private Button aceptarTermsAndCondBtn;

    private static final String PREF_NAME_TERMS_AND_COND = "PREF_TERMS_AND_COND";
    private static final String KEY_PREF_CONFIRMACION_LECTURA = "CONFIRMACION_LECTURA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        abrirSharedPref();
        setupUI();
        cargarSharedPref();
    }

    // Ejercicio adicional

    private void abrirSharedPref() {
        // TODO(2. Abrir el shared pref usando un nombre en particular para usar en esta pantalla)
        /*preferences = getSharedPreferences(PREF_NAME_TERMS_AND_COND, MODE_PRIVATE); */
    }
    private void setupUI() {
        // TODO(1. Vincular elementos)
        aceptarTermsAndCondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO(3. Cuando el usuario le da click al boton, guardar el estado del checkbox SOLO si hay confirmacion de lectura)
                // TODO(5. Si el usuario no habilito el checkbox, mostrar un toast pidiendo la confirmacion)
            }
        });
    }

    private void cargarSharedPref() {
        // TODO(4.Obtener la confirmacion de lectura)
        // TODO(5. Ocultar el boton y el checkbox si hay confirmacion)
    }


}
