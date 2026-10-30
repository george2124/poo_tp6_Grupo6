package ar.edu.unju.poo.punto2.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ar.edu.unju.poo.punto2.managerEmpleado.ManagerEmpleado;

public class ManagerEmpleadoTest {
	private ManagerEmpleado manager;
	private Titulo tituloValido;
	
	@BeforeEach
	void setUp() {
		manager = new ManagerEmpleado();
		tituloValido = new Titulo("Analista Porgramador Universitario", "terciario", 2023);
	}
	
	@Test
	void deberiaLanzarExceptionCuandoSeRepitaDocumento() {
		 Empleado empleado1 = new Profesional("1234-26", "40111222", "Juan Pérez", LocalDate.now(), 2, tituloValido);
	     Empleado empleado2 = new Profesional("5678-26", "40111222", "Lucas Gómez", LocalDate.now(), 1, tituloValido);
	     
	     manager.agregar(empleado1);
	     
	     
	     assertThrows(EmpleadoValidacionException.class, () -> manager.agregar(empleado2));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1,6})
	void deberiaLazarExceptionDeLaCantidadDeHijosInvalida(int cantidadHijoInvalida) {
		// Test parametrizado usando @ValueSource para evaluar límites del modelo
        assertThrows(EmpleadoValidacionException.class, () -> {
            new Profesional("1444-26", "25999959", "Test Hijos", LocalDate.now(), cantidadHijoInvalida, tituloValido);
        });
	}
	
	 @Test
	 @Disabled("Prueba deshabilitada temporalmente hasta actualizar el módulo de limpieza")
	 void pruebaDeshabilitada() {
	     // Cumple con el requisito del tag @Disabled exigido en el TP
	     fail("No debería ejecutarse");
	 }
}
