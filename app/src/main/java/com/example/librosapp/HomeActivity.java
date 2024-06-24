package com.example.librosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librosapp.libros.Libro;
import com.example.librosapp.libros.LibrosAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static final String PARAM_USUARIO = "USUARIO";

    private Toolbar toolbar;
    private RecyclerView librosRV;
    private LibrosAdapter librosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        saludarUsuario();
        setupAdapter();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Decirle que se comporte como action bar
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
            String bienvenidoMensaje = getString(R.string.bienvenido_usuario, usuario);
            Toast.makeText(HomeActivity.this, bienvenidoMensaje, Toast.LENGTH_SHORT).show();
        }
    }

    private void setupAdapter() {
        librosRV = findViewById(R.id.rvLibros);

        librosAdapter = new LibrosAdapter(new LibrosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Libro libro) {
                String libroSeleccionado = getString(R.string.libro_seleccionado, libro.getTitulo());
                Toast.makeText(HomeActivity.this, libroSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });

        librosRV.setAdapter(librosAdapter);
        librosAdapter.setLibros(getLibros());
    }

    private List<Libro> getLibros() {
        return new ArrayList<Libro>() {{
            add(new Libro(1, "Harry Potter", "J.K. Rowling", Libro.ImagenId.LIBRO1));
            add(new Libro(2, "Game of Thrones", "George Martin", Libro.ImagenId.LIBRO2));
            add(new Libro(3, "Maze Runner", "James Dashner", Libro.ImagenId.LIBRO3));
        }};
    }
}
