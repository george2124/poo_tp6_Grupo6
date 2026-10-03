package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesional extends Empleado{
	private List<Titulo> titulos;
	
	public Profesional(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		this.titulos = new ArrayList<>();// TODO Auto-generated constructor stub
	}


	@Override
	public double getAdicional() {
		// TODO Auto-generated method stub
		return this.titulos.size() * 3000.0;
	}
	
	public void agregarTitulo(Titulo titulo) {
		this.titulos.add(titulo);
	}
	
	
}
