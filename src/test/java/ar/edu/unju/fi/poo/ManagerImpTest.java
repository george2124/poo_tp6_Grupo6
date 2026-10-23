package ar.edu.unju.fi.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.poo.domain.PorHora;
import ar.edu.unju.fi.poo.domain.Vehiculo; // Ajusta el import si tu clase Vehiculo está en otro paquete
import ar.edu.unju.fi.poo.interfaces.imp.ManagerImp;

public class ManagerImpTest {

    private ManagerImp manager;

    @BeforeEach
    public void setUp() {
        manager = new ManagerImp();
    }

    @Test
    public void testValidarPatenteInexistente() {
        // Validamos que una patente que no ingresó devuelva false
        boolean existe = manager.validarPatente("ABC123XY");
        assertFalse(existe, "La patente no debería existir en los registros iniciales");
    }

    @Test
    public void testRegistrarIngresoPermitido() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPatente("XYZ987"); // Ajusta si tu método se llama distinto

        PorHora registro = new PorHora();
        registro.setVehiculo(vehiculo);
        registro.setHora(LocalTime.of(10, 0));

        manager.registrarIngreso(registro);

        assertTrue(manager.validarPatente("XYZ987"), "El vehículo debería figurar en la playa");
    }
    @Test
    public void testRegistrarSalida() {
        // 1. Creamos el vehículo y el registro
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPatente("DEF456");

        PorHora registro = new PorHora();
        registro.setVehiculo(vehiculo);
        registro.setHora(LocalTime.of(8, 0));
        registro.setTarifa(200.0); // Le asignamos una tarifa de ejemplo

        // 2. Registramos el ingreso primero
        manager.registrarIngreso(registro);

        // 3. Probamos registrar la salida y validamos que devuelva un importe válido
        Double importe = manager.registrarSalida(registro);
        
        assertNotNull(importe, "El importe calculado de salida no debería ser nulo");
        assertTrue(importe > 0, "El importe debería ser mayor a cero");
    }
}
