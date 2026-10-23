package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;

public class Limpieza extends Empleado {

	public Limpieza(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		
	}

	@Override
	public double getAdicional() {
		
		return 25000.0;
	}
	
}
