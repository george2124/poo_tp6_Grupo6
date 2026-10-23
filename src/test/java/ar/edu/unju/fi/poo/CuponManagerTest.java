package ar.edu.unju.fi.poo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.poo.domain.Cupon;
import ar.edu.unju.fi.poo.interfaces.imp.ManagerImp;

public class CuponManagerTest {

    private ManagerImp manager;

    @BeforeEach
    public void setUp() {
        manager = new ManagerImp();
    }

    @Test
    public void testCrearCupon() {
        Cupon cupon = new Cupon();
        assertNotNull(cupon, "El cupón no debería ser nulo");
    }

    @Test
    public void testInstanciaManager() {
        assertNotNull(manager, "El manager debería haberse inicializado correctamente");
    }
}