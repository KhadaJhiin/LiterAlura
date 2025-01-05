package com.jdev.LiterAluraSpring.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
//    @Transient
    private List<String> autores;
//    @Transient
    private List<String> lenguajes;
    private int descargas;

    //Constructor
    public Libro(){}
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
                "Descargas: " + descargas + "\n" +
                "----------------------------------"+ "\n" +
                "----------------------------------";
    }

    //Setters an getters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

