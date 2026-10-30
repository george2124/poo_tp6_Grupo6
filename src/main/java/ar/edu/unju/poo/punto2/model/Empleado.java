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
	    //Validación de Formato de Legajo (4 dígitos - 2 dígitos del año)--punto b
	    if (legajo == null || !legajo.matches("\\d{4}-" +"\\d{2}")) {
            throw new EmpleadoValidacionException("El legajo debe tener el formato NNNN-AA, con el año actual(Ejemplo: 1234-26");
        }
	    
	    // Validación de Fecha de Ingreso--punto c
	    if (fechaIngreso == null) {
            throw new EmpleadoValidacionException("La fecha de ingreso no puede ser nula.");
        }
        if (fechaIngreso.isAfter(LocalDate.now())) {
            throw new EmpleadoValidacionException("La fecha de ingreso debe ser menor o igual a la fecha actual del sistema.");
        }
        
        // Validación de Cantidad de Hijos--punto d
        if (cantidadHijos < 0 || cantidadHijos > 5) {
            throw new EmpleadoValidacionException("La cantidad de hijos debe estar entre 0 y 5.");
        }
	    //validarLegajo(legajo);
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
	    //validarLegajo(legajo);
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

	
	public int getCantidadHijos() {
		return cantidadHijos;
	}

		
	public static double getSueldoBasico() {
		return SUELDO_BASICO;
	}

	//Método  de Validación
    //private void validarLegajo(String legajo) throws EmpleadoValidacionException {
      //  String anioActual = String.valueOf(LocalDate.now().getYear()).substring(2);
    //}
    // --- PUNTO C: Fecha de ingreso menor o igual a la del sistema ---
    //public void setFechaIngreso(LocalDate fechaIngreso) throws EmpleadoValidacionException { 
      //  this.fechaIngreso = fechaIngreso;
    //}

    // --- PUNTO D: Cantidad de hijos entre 0 y 5 ---
    //public void setCantidadHijos(int cantidadHijos) throws EmpleadoValidacionException {
      //  this.cantidadHijos = cantidadHijos;
    //}
    
}
