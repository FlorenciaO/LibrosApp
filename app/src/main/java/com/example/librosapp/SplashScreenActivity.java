package com.example.librosapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    //TODO()
    private static final long DELAYED_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirMainActivity();
            }
        }, DELAYED_TIME);   // Como segundo parámetro se le pasa el tiempo de espera que tendrá antes
        // de que se ejecute el bloque de código dentro del método run()
    }

    private void abrirMainActivity() {
        //TODO(1. Crear el intent para ir hacia la Main Activity)
        //TODO(2. Iniciar la nueva activity)
//        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
//        startActivity(intent);

        //TODO(3. Ver comportamiento sin usar la siguiente linea, luego descomentarla y probar)
        //finish(); // Para finalizar activity actual y sacarla de la pila.
    }
}
