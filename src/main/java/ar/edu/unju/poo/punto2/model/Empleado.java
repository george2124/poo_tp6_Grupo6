package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	private String legajo;
	private String documento;
	private String nombre;
	private LocalDate fechaIngreso;
	private int cantidadHijos;
	
	public static final double SUELDO_BASICO = 400000.0;

	public Empleado(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos) {
		super();
		this.legajo = legajo;
		this.documento = documento;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.cantidadHijos = cantidadHijos;
	}
	
	// Calcula de antiguedad con la fecha actual
    public int getAntiguedad() {
        return Period.between(this.fechaIngreso, LocalDate.now()).getYears();
    }
    
    // Salario Familiar; 15.000 por cada hijo
    public double getSalarioFamiliar() {
        return this.cantidadHijos * 15000.0;
    }
    
    // Método para las subclases
    public abstract double getAdicional();
    
    // Remunerativos = Básico + Adicional + Antigüedad (6500 por año)
    public double getRemunerativosBonificables() {
        double antiguedadMonto = getAntiguedad() * 6500.0;
        return SUELDO_BASICO + getAdicional() + antiguedadMonto;
    }
    
    // Descuentos: 18% de los remunerativos
    public double getDescuentos() {
        return getRemunerativosBonificables() * 0.18;
    }
    
    // Fórmula Final: Sueldo Neto = Remunerativos + Salario Familiar - Descuentos
    public double calcularSueldoNeto() {
        return getRemunerativosBonificables() + getSalarioFamiliar() - getDescuentos();
    }

    // Getters y Setters
	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public static double getSueldoBasico() {
		return SUELDO_BASICO;
	}

    
    
}
