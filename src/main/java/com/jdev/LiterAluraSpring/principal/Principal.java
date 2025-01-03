package com.jdev.LiterAluraSpring.principal;

import com.jdev.LiterAluraSpring.model.DatosLibro;
import com.jdev.LiterAluraSpring.model.Libro;
import com.jdev.LiterAluraSpring.repositorio.LibroRespositorio;
import com.jdev.LiterAluraSpring.service.ConsumoApi;
import com.jdev.LiterAluraSpring.service.ConvierteDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    //Atributos
    private Scanner entrada = new Scanner(System.in);
    private LibroRespositorio repositorio;

    public Principal(LibroRespositorio repository) {
        this.repositorio = repository;
    }

    //Métodos
    public boolean mostrarMenu(){
        System.out.println("""
                
                *************** LiterAlura ***************
                Bienvenidos !
               
                1) Buscar Libro por título
                2) Listar libros registrados
                3) Listar autores registrados
                4) Listar autores vivos en un determinado año
                5) Listar libros por idioma
                0) Salir
                
                Escoge una opcion valida por favor: 
                *****************************************************
                """);
        try {
            int opcion = Integer.parseInt(entrada.nextLine());
            if (opcion == 0){
                return false;
            }
            System.out.println(procesarOpcion(opcion));
            return true;

        }catch (NumberFormatException | IOException | InterruptedException e){
            System.out.println("Por favor ingrese solo números enteros de acuerdo al menu de opciones.");
            return true;
        }
    }
    private String procesarOpcion(int opcion) throws IOException, InterruptedException {
        switch (opcion) {
            case 1:
                return procesadorEntrada();
            case 2:
                return mostrarLibrosBuscados();
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8 :
                return "8";
            default:
                return "Opción no válida";
        }
    }
    public void despedida(){
        System.out.println("Gracias por usar la aplicacion, ten un buen dia..!");
    }

    //Primera opción del menu
    private String procesadorEntrada(){
        System.out.println("Ingrese el nombre de un libro que desee buscar: ");
        String nombreLibro = entrada.nextLine();
        ConsumoApi consumoApi = new ConsumoApi();
        final String URL_BASE = "https://gutendex.com/books/?search=";
        String json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ","%20"));
        ConvierteDatos conversor = new ConvierteDatos();
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        if (!datos.resultados().isEmpty()){
            var libroRecord = datos.resultados().get(0);
            Libro libro = new Libro(libroRecord);
            repositorio.save(libro);
            return libro.toString();
        }else {
            return "No se encontraron libros en los resultados.";
        }
    }

    //Segunda opción del menu
    private String mostrarLibrosBuscados() {
        List<Libro> libros = repositorio.findAll();
        if (libros.isEmpty()) {
            return "No se encontraron libros.";
        }
        return libros.stream()
                .map(Libro::toString)
                .collect(Collectors.joining("\n"));
    }
}







