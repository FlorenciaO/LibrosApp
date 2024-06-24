package com.example.librosapp.libros;

public class Libro {

    private Integer id;
    private String titulo;
    private String autor;
    private ImagenId imagenId;

    public Libro() {
    }

    public Libro(Integer id, String titulo, String autor, ImagenId imagenId) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.imagenId = imagenId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public ImagenId getImagenId() {
        return imagenId;
    }

    public enum ImagenId {
        LIBRO1,
        LIBRO2,
        LIBRO3,
        PLACEHOLDER
    }

}
