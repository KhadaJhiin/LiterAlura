package com.jdev.LiterAluraSpring;

import com.jdev.LiterAluraSpring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal menu = new Principal();
		while (menu.mostrarMenu()){}
		menu.despedida();
	}
}
