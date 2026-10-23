package ar.edu.unju.fi.poo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.poo.domain.Cliente;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
    }

    @Test
    public void testInstanciaCliente() {
        assertNotNull(cliente, "El objeto cliente debería haberse instanciado correctamente");
    }

    @Test
    public void testSetAndGetDatosCliente() {
        cliente.setDni("12345678");
        cliente.setDomicilio("San Salvador de Jujuy");
        cliente.setCelular("3884123456");

        assertEquals("12345678", cliente.getDni(), "El DNI debería coincidir");
        assertEquals("San Salvador de Jujuy", cliente.getDomicilio(), "El domicilio debería coincidir");
        assertEquals("3884123456", cliente.getCelular(), "El celular debería coincidir");
    }
}