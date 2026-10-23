package ar.edu.unju.poo.punto2.intercafes;

import java.util.List;

import ar.edu.unju.poo.punto2.model.Empleado;


public interface IManagerEmpleado {
	 void agregar(Empleado empleado);
	 void modificar(Empleado empleado);
	 Empleado buscar(String legajo);
	 List<Empleado> buscarTipoEmpleado(String tipo);
	 List<Empleado> buscarAntiguedadMayor(Integer anio);
	 List<String> obtenerNombresOrdenados(List<Empleado> empleados);
	 Double obtenerCantidad(List<Empleado> empleados);
	 Double obtenerNetoTotalAcumulado(List<Empleado> empleados);
}
