package ar.edu.unju.poo.punto2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ProfesionalTest {
    @Test
    void deberiaLanzarExcepcionCuandoElNivelDelTituloNoEsUniversitarioNiTerciario() {
        // Arrange: Creamos un título con nivel inválido (Secundario) usando tu constructor
        Titulo tituloInvalido = new Titulo("Bachiller en Informática", "Secundario", 2022);
        
        // Act & Assert: Verificamos que salte la excepción al intentar construir el Profesional
        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> new Profesional("L001", "35123456", "Juan Pérez", LocalDate.now(), 2, tituloInvalido)
        );
        
        // Comprobamos que el mensaje del error sea el correcto
        assertEquals("Debe tener al menos un titulo terceario o universitario", excepcion.getMessage());
    }

    @Test
    void deberiaCrearProfesionalExitosamenteCuandoElNivelEsUniversitario() {
        // Arrange: Creamos un título válido
        Titulo tituloValido = new Titulo("Licenciatura en Sistemas", "Universitario", 2025);
        
        // Act: Creamos el profesional pasándole el título universitario obligatorio
        String legajo = "L001";
        String dni = "35123456";
        String nombre = "Juan Pérez";
        LocalDate fecha = LocalDate.now();
        int hijos = 2;
        
        Profesional profesional = new Profesional(legajo, dni, nombre, fecha, hijos, tituloValido);
        
        // Assert: Validamos que el objeto se creó y tiene los datos esperados
        assertNotNull(profesional);
        assertEquals(1, profesional.getTitulos().size());
        assertEquals(3000.0, profesional.getAdicional());
    }

    @Test
    void deberiaCrearProfesionalExitosamenteCuandoElNivelEsTerciario() {
        // Arrange: Creamos un título válido de nivel terciario
        Titulo tituloValido = new Titulo("Analista Programador", "Terciario", 2024);
        
        // Act
        Profesional profesional = new Profesional("L002", "36123456", "Ana Gómez", LocalDate.now(), 0, tituloValido);
        
        // Assert
        assertNotNull(profesional);
        assertEquals(1, profesional.getTitulos().size());
    }
}
