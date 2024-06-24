package com.example.librosapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TermsAndConditionsActivity extends AppCompatActivity {


    private SharedPreferences preferences;
    private LinearLayout confirmacionContainer;
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

    // Modulo 3 - clase 2 - Ejercicios

    private void abrirSharedPref() {
        preferences = getSharedPreferences(PREF_NAME_TERMS_AND_COND, MODE_PRIVATE);
    }
    private void setupUI() {
        confirmacionContainer = findViewById(R.id.confirmacion_container);
        aceptarTermsAndCondBtn = findViewById(R.id.confirmacion_btn);
        aceptarTermsAndCondCheckBox = findViewById(R.id.confirmacion_checkbox);

        aceptarTermsAndCondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aceptarTermsAndCondCheckBox.isChecked()) {
                    guardarPref();
                } else {
                    Toast.makeText(TermsAndConditionsActivity.this, "Por favor, confirme que ha leído y aceptado los términos y condiciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void guardarPref() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_PREF_CONFIRMACION_LECTURA, aceptarTermsAndCondCheckBox.isChecked());
        editor.apply();
    }

    private void cargarSharedPref() {
        boolean lecturaConfirmada = preferences.getBoolean(KEY_PREF_CONFIRMACION_LECTURA, false);
        if (lecturaConfirmada) {
            confirmacionContainer.setVisibility(View.GONE);
        }
    }

}
