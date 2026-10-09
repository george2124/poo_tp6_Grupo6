package ar.edu.unju.poo.punto2.managerEmpleado;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.poo.punto2.model.Administrativo;
import ar.edu.unju.poo.punto2.model.Empleado;
import ar.edu.unju.poo.punto2.model.Limpieza;
import ar.edu.unju.poo.punto2.model.Profesional;

public class ManagerEmpleado {
	private List<Empleado> listaEmpleados;

	public ManagerEmpleado() {
		super();
		this.listaEmpleados = new ArrayList<>();
	}
	
	public boolean agregarEmpleado(Empleado empleado) {
		 for (Empleado e : listaEmpleados) {
	            if (e.getLegajo().equals(empleado.getLegajo())) {
	                System.out.println("Error: El legajo " + empleado.getLegajo() + " ya existe.");
	                return false;
	            }
	        }
	        listaEmpleados.add(empleado);
	        return true;
	}
	
	public Empleado buscarPorLegajo(String legajo) {
	      for (Empleado e : listaEmpleados) {
	          if (e.getLegajo().equals(legajo)) 
	        	 return e;
	      }
	  return null;
	}
	
	
	public List<Empleado> getListaEmpleados() { 
	
		return listaEmpleados; 
	
	}
	
	public double calculoNetoAcumuladoPorTipo(String tipo) {
		
		double acumulado = 0;
		
		for(Empleado e : listaEmpleados) {
			
			boolean coincide = false;
			
			if (tipo.equalsIgnoreCase("Profesional") && e instanceof Profesional) 
				coincide = true;
			if (tipo.equalsIgnoreCase("Administrativo") && e instanceof Administrativo)
				coincide = true;
			if (tipo.equalsIgnoreCase("Limpieza") && e instanceof Limpieza)
				coincide = true;
			
			if (coincide = true) {
				acumulado += e.calcularSueldoNeto(); 
			}
		}
		
		return acumulado;
	}
	
    // Operación 1: obtener los empleados administrativos de una categoría
    public List<Administrativo> obtenerEmpleadosPorCategoria(char categoria) {
        List<Administrativo> empleadosEncontrados = new ArrayList<>();
        char categoriaBuscada = Character.toUpperCase(categoria);

        for (Empleado e : listaEmpleados) {
            if (e instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) e;

                if (administrativo.getCategoria() == categoriaBuscada) {
                    empleadosEncontrados.add(administrativo);
                }
            }
        }

        return empleadosEncontrados;
    }
}
