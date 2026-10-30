package ar.edu.unju.poo.punto2.model;

public class EmpleadoValidacionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmpleadoValidacionException(String mensaje) {
        super(mensaje);
    }
}