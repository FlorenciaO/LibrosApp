package com.example.librosapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        // TODO(2. Decirle a la toolbar que se comporte como action bar)
        // TODO(3. Setear el titulo a la toolbar)
        // TODO(11. Como mejora, utilizar un recurso de string como titulo)
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
        }
        return super.onOptionsItemSelected(item);
    }

    private void saludarUsuario() {
        // TODO(8. Obtener el bundle conocido como Extras)
        // TODO(9. Si el bundle no es null, obtener el parametro usuario)
        // TODO (10. Mostrar un toast con un saludo al usuario)
        // TODO (12. Como mejora, usar un recurso de string con formato para el saludo)
    }
}
