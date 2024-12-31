package com.jdev.LiterAluraSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("results") List<Libro> resultados
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Libro(
            @JsonAlias("title") String titulo,
            @JsonAlias("authors") List<Autor> autores,
            @JsonAlias("languages") List<String> lenguajes,
            @JsonAlias("download_count") Integer descargas
    ){
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Autor(
            @JsonAlias("name") String nombre
    ){
    }
}
