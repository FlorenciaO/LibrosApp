package com.example.librosapp.libros;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librosapp.R;

public class LibrosViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView tituloTv;
    TextView autorTv;
    TextView verMasTv;

    public LibrosViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.libro_image_view);
        tituloTv = itemView.findViewById(R.id.titulo_text_view);
        autorTv = itemView.findViewById(R.id.autor_text_view);
        verMasTv = itemView.findViewById(R.id.ver_mas_text_view);
    }

    public void bind(Libro libro, LibrosAdapter.OnItemClickListener onItemClickListener) {
        tituloTv.setText(libro.getTitulo());
        autorTv.setText(libro.getAutor());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(libro);
            }
        });
        verMasTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(libro);
            }
        });

        switch (libro.getImagenId()) {
            case LIBRO1:
                imageView.setImageResource(R.drawable.libro1);
                break;
            case LIBRO2:
                imageView.setImageResource(R.drawable.libro2);
                break;
            case LIBRO3:
                imageView.setImageResource(R.drawable.libro3);
                break;
            case PLACEHOLDER:
                imageView.setImageResource(R.drawable.placeholder);
                break;
        }
    }
}
