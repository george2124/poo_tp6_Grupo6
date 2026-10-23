package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;

public class Administrativo extends Empleado{
	
	private char categoria;
	
	//Constructor original: mantiene compatibilidad con el Main actual
	public Administrativo(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos) {
		this(legajo, documento, nombre, fechaIngreso, cantidadHijos, 'A');
	}

	//Constructor que permite indicar la categoria
	public Administrativo(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos, char categoria) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		this.categoria = Character.toUpperCase(categoria);
	}
	

	@Override
	public double getAdicional() {
		 switch (this.categoria) {
         	 case 'A': 
         		 return 30000.0;
         	 case 'B': 
         		 return 45000.0;
         	 case 'C': 
         		 return 55000.0;
         	 default: 
         		 return 0.0;
		 }
	}
	
	public char getCategoria() { 
		return categoria; 
	}
    
	public void setCategoria(char categoria) { 
		this.categoria = Character.toUpperCase(categoria); 
    }


}
