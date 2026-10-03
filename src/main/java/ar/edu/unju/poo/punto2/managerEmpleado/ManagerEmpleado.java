package ar.edu.unju.poo.punto2.managerEmpleado;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.poo.punto2.model.Empleado;

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
	          if (e.getLegajo().equals(legajo)) return e;
	      }
	  return null;
	}
	
	
	public List<Empleado> getListaEmpleados() { 
	
		return listaEmpleados; 
	
	}
}
