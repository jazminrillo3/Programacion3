package com.utn.ejercicio2;

import com.utn.ejercicio2.entities.Domicilio;
import com.utn.ejercicio2.entities.Persona;
import com.utn.ejercicio2.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio2Application {

    @Autowired
    PersonaRepository personaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio2Application.class, args);
    }

    @Bean
    CommandLineRunner init(PersonaRepository personaRepo) {
        return args -> {
            System.out.println("-----------------ESTOY FUNCIONANDO---------");
            Persona persona = Persona.builder()
                    .nombre("Jazmín")
                    .apellido("Rillo")
                    .edad(20)
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .calle("Pincolini")
                    .numero(2714)
                    .build();

            persona.setDomicilio(domicilio);

            // Guardar el objeto Persona en la base de datos
            // PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
            personaRepository.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
                System.out.println("Calle: " + personaRecuperada.getDomicilio().getCalle());
                System.out.println("Número: " + personaRecuperada.getDomicilio().getNumero());
            }

        };

    }

}
