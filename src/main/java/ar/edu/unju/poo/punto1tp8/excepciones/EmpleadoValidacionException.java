package ar.edu.unju.poo.punto1tp8.excepciones;
import ar.edu.unju.poo.punto1tp8.excepciones.EmpleadoValidacionException;

public class EmpleadoValidacionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmpleadoValidacionException(String mensaje) {
        super(mensaje);
    }
}