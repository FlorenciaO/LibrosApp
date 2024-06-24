package com.example.librosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    public static final String PARAM_USUARIO = "USUARIO";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        saludarUsuario();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Decirle que se comporte como action bar
        // TODO(11. Como mejora, utilizar un recurso de string como titulo)
        String tituloToolbar = getString(R.string.titulo_toolbar);
        getSupportActionBar().setTitle(tituloToolbar); // Setear titulo
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_agregar) {
            Intent intent = new Intent(HomeActivity.this, AgregarLibroActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void saludarUsuario() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String usuario = bundle.getString(PARAM_USUARIO);
            // TODO (12. Como mejora, usar un recurso de string con formato para el saludo)
            String bienvenidoMensaje = getString(R.string.bienvenido_usuario, usuario);
            Toast.makeText(HomeActivity.this, bienvenidoMensaje, Toast.LENGTH_SHORT).show();
        }
    }
}
