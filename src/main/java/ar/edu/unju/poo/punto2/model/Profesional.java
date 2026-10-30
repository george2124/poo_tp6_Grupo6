package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesional extends Empleado{
	private List<Titulo> titulos;
	
	public Profesional(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos, Titulo inicialTitulo) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		this.titulos = new ArrayList<>();// TODO Auto-generated constructor stub
		this.agregarTitulo(inicialTitulo); //validamos la obligacion del titulo
	}


	@Override
	public double getAdicional() {
		// TODO Auto-generated method stub
		return this.titulos.size() * 3000.0;
	}
	
	public void agregarTitulo(Titulo titulo) {
		// Obtenemos el nivel del título usando tu método getNivel()
		String nivel = titulo.getNivel();
				
		// Validamos ignorando mayúsculas/minúsculas para evitar errores de tipeo ("Universitario", "universitario")
		if (!"universitario".equalsIgnoreCase(nivel) && !"terciario".equalsIgnoreCase(nivel)) {
			throw new IllegalArgumentException("Debe tener al menos un titulo terceario o universitario");
		}
		this.titulos.add(titulo);
	}


	public List<Titulo> getTitulos() {
		return titulos;
	}


	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
	
	
}
