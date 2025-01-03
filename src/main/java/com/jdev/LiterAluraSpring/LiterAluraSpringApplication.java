package com.jdev.LiterAluraSpring;

import com.jdev.LiterAluraSpring.principal.Principal;
import com.jdev.LiterAluraSpring.repositorio.LibroRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraSpringApplication implements CommandLineRunner {

	@Autowired
	private LibroRespositorio repository;
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal menu = new Principal(repository);
		while (menu.mostrarMenu()){}
		menu.despedida();
	}
}
