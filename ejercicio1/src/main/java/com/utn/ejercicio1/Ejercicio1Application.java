package com.utn.ejercicio1;

import com.utn.ejercicio1.entities.Persona;
import com.utn.ejercicio1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio1Application {

    @Autowired
    PersonaRepository personaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio1Application.class, args);
    }

    @Bean
    CommandLineRunner init(PersonaRepository personaRepo) {
        return args -> {
            System.out.println("-----------------ESTOY FUNCIONANDO---------");
            Persona persona = new Persona();
            persona.setNombre("Jazmín");
            persona.setApellido("Rillo");
            persona.setEdad(20);

            personaRepository.save(persona);

            Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
            }

        };

    }


}
