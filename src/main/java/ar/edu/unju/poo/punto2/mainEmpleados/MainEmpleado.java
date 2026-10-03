package ar.edu.unju.poo.punto2.mainEmpleados;

import java.time.LocalDate;

import ar.edu.unju.poo.punto2.managerEmpleado.ManagerEmpleado;
import ar.edu.unju.poo.punto2.model.Administrativo;
import ar.edu.unju.poo.punto2.model.Empleado;
import ar.edu.unju.poo.punto2.model.Limpieza;
import ar.edu.unju.poo.punto2.model.Profesional;
import ar.edu.unju.poo.punto2.model.Titulo;

public class MainEmpleado {
	 public static void main(String[] args) {
	        ManagerEmpleado manager = new ManagerEmpleado();

	        // 1. Inicializar con empleados (Antigüedad simulada con fechas pasadas)
	        Administrativo emp1 = new Administrativo("AB01", "35111222", "Carlos Jose Gómez", LocalDate.of(2020, 5, 10), 2);
	        Profesional emp2 = new Profesional("OP01", "32444555", "Analia Rodríguez", LocalDate.of(2018, 3, 15), 1);
	        Profesional emp4 = new Profesional("OP04", "33488566", "Camilo Mamani", LocalDate.of(2026, 2, 10), 1);
	        Limpieza emp3 = new Limpieza("LM01", "40888999", "Mariano Luis López", LocalDate.of(2022, 1, 20), 0);

	        emp2.agregarTitulo(new Titulo("Universitario", "Ingeniería en Informática", 2015));
	        emp2.agregarTitulo(new Titulo("Universitario", "Magister en Software", 2017));
	        
	        emp4.agregarTitulo(new Titulo("Terciario", "Analista Programador Universitario", 2023));
	        emp4.agregarTitulo(new Titulo("Universitario", "Licenciatura en Sistema", 2025));

	        manager.agregarEmpleado(emp1);
	        manager.agregarEmpleado(emp2);
	        manager.agregarEmpleado(emp3);
	        
	        // 2. Probar búsquedas e impresiones de Sueldo Neto
	        Empleado buscado = manager.buscarPorLegajo("OP01");
	        
	        if (buscado != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Nombre: " + buscado.getNombre());
	            System.out.println("Antigüedad: " + buscado.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado.calcularSueldoNeto());
	        }
	        
	        Empleado buscado2 = manager.buscarPorLegajo("OP04");
	        if (buscado2 != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Nombre: " + buscado.getNombre());
	            System.out.println("Antigüedad: " + buscado.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado.calcularSueldoNeto());
	        }

	    }
}
