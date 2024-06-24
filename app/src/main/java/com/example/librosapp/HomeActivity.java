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
        // TODO(1. Vincular toolbar)
        toolbar = findViewById(R.id.toolbar);
        // TODO(2. Decirle a la toolbar que se comporte como action bar)
        setSupportActionBar(toolbar); // Decirle que se comporte como action bar
        // TODO(3. Setear el titulo a la toolbar)
        getSupportActionBar().setTitle("Mis Libros"); // Setear titulo
        // TODO(11. Como mejora, utilizar un recurso de string como titulo)
        /*String tituloToolbar = getString(R.string.titulo_toolbar);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO(5. Crear el menu con el nombre menu_home)
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // TODO(6. Agregar un item con el nombre item_agregar al XML del menu)
        if (item.getItemId() == R.id.item_agregar) {
            // TODO(7. Abrir la activity AgregarLibroActivity)
            Intent intent = new Intent(HomeActivity.this, AgregarLibroActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void saludarUsuario() {
        // TODO(8. Obtener el bundle conocido como Extras)
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // TODO(9. Si el bundle no es null, obtener el parametro usuario)
            String usuario = bundle.getString(PARAM_USUARIO);
            // TODO (10. Mostrar un toast con un saludo al usuario)
            Toast.makeText(HomeActivity.this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();
            // TODO (12. Como mejora, usar un recurso de string con formato para el saludo)
        }
    }
}
