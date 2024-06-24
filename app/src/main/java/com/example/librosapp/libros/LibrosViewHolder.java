package com.example.librosapp.libros;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LibrosViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView tituloTv;
    TextView autorTv;
    TextView verMasTv;

    public LibrosViewHolder(@NonNull View itemView) {
        super(itemView);
        // TODO(1. Vincular vistas)
    }

    public void bind(Libro libro) {
        // TODO(2. Setear los atributos del libro a cada text view)
        // TODO(3. Implementar el click al item y al "Ver mas")
        // TODO(4. Según el imageId del libro, setear el recurso (drawable) especifico)
    }
}
