package com.jdev.LiterAluraSpring.repositorio;

import com.jdev.LiterAluraSpring.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRespositorio extends JpaRepository<Libro,Long> {

}
