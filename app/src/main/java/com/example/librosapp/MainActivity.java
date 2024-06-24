package com.example.librosapp;

import static com.example.librosapp.HomeActivity.PARAM_USUARIO;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContrasenia;
    private Button btnIniciarSesion;
    private TextView txtTerminosYCondiciones;
    private SharedPreferences preferences;
    private CheckBox checkBoxRecordar;

    private static final String KEY_PREF_USUARIO = "USUARIO";
    private static final String KEY_PREF_RECORDAR_USUARIO = "RECORDAR_USUARIO";

    private static final String PREF_NAME_MAIN = "PREF_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abrirSharedPref();
        setupUI();
    }

    private void abrirSharedPref() {
        abrirSharedPref();preferences = getSharedPreferences(PREF_NAME_MAIN, MODE_PRIVATE);
    }

    private void setupUI() {
        etUsuario = findViewById(R.id.etUsuario);
        etContrasenia = findViewById(R.id.etContraseña);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        txtTerminosYCondiciones = findViewById(R.id.txtTerminosYCondiciones);
        checkBoxRecordar = findViewById(R.id.checkBoxRecordar);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasenia = etContrasenia.getText().toString();
                if (usuario.isEmpty() || contrasenia.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
                } else {
                    guardarSharedPref(usuario);
                    abrirHomeActivity(usuario);
                }
            }
        });
        txtTerminosYCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(MainActivity.this, TermsAndConditionsActivity.class)
                );
            }
        });

        cargarSharedPref();
    }

    private void abrirHomeActivity(String usuario) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra(PARAM_USUARIO, usuario);
        startActivity(intent);
        finish();
    }

    private void cargarSharedPref() {
        cargarUsuarioSharedPref();
        boolean recordarUsuario = preferences.getBoolean(KEY_PREF_RECORDAR_USUARIO, false);
        if (recordarUsuario) {
            cargarUsuarioSharedPref();
        }
        checkBoxRecordar.setChecked(recordarUsuario);
    }

    private void cargarUsuarioSharedPref() {
        String usuarioGuardado = preferences.getString(KEY_PREF_USUARIO, "");
        etUsuario.setText(usuarioGuardado);
    }

    private void guardarSharedPref(String usuario) {
        SharedPreferences.Editor editor = preferences.edit();

        if (checkBoxRecordar.isChecked()) {
            editor.putString(KEY_PREF_USUARIO, usuario);
        }
        editor.putBoolean(KEY_PREF_RECORDAR_USUARIO, checkBoxRecordar.isChecked());
        editor.apply();
    }
}
