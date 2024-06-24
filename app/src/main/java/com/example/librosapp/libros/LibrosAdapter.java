package com.example.librosapp.libros;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LibrosAdapter extends
        RecyclerView.Adapter<LibrosViewHolder> {

    private List<Libro> libros = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public LibrosAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public LibrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO(1. Inflar la vista)
        // TODO(2. Retornar el view holder)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosViewHolder holder, int position) {
        holder.bind(libros.get(position));
    }

    @Override
    public int getItemCount() {
        // TODO(3. Retornar el tamaño de la lista)
        return 0;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
        // TODO(4. Como mejora, utilizar un DiffUtil para mejor rendimiento)
        notifyDataSetChanged();
    }

    public List<Libro> getLibros() {
        return this.libros;
    }

    public interface OnItemClickListener {
        void onItemClick(Libro libro);
    }
}
