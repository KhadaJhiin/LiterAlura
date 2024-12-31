package com.jdev.LiterAluraSpring.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}

