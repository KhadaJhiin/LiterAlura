package com.jdev.LiterAluraSpring.model;

import java.util.List;
import java.util.stream.Collectors;

public class Libro {
    //Atributo
    private String titulo;
    private List<String> autores;
    private List<String> lenguajes;
    private int descargas;

    //Constructor
    public Libro(DatosLibro.Libro libroRecord) {
        this.titulo = libroRecord.titulo();
        this.autores = libroRecord.autores().stream()
                .map(autor -> autor.nombre())
                .collect(Collectors.toList());
        this.lenguajes = libroRecord.lenguajes();
        this.descargas = libroRecord.descargas();
    }

    //Método to String
    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Autores: " + String.join(", ", autores) + "\n" +
                "Lenguajes: " + String.join(", ", lenguajes) + "\n" +
                "Descargas: " + descargas;
    }

    //Setters an getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}

