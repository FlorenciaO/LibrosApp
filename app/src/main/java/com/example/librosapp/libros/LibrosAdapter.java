package com.example.librosapp.libros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librosapp.R;

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
        View itemLibro =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_libro, parent, false);
        return new LibrosViewHolder(itemLibro);
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosViewHolder holder, int position) {
        holder.bind(libros.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return libros.size();
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
