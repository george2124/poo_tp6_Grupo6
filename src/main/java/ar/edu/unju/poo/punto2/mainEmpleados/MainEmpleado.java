package ar.edu.unju.poo.punto2.mainEmpleados;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.poo.punto2.managerEmpleado.ManagerEmpleado;
import ar.edu.unju.poo.punto2.model.Administrativo;
import ar.edu.unju.poo.punto2.model.Empleado;
import ar.edu.unju.poo.punto2.model.Limpieza;
import ar.edu.unju.poo.punto2.model.Profesional;
import ar.edu.unju.poo.punto2.model.Titulo;

public class MainEmpleado {
	 public static void main(String[] args) {
	        ManagerEmpleado manager = new ManagerEmpleado();
	        Scanner scanner = new Scanner(System.in);

	        // 1. Inicializar con empleados (Antigüedad simulada con fechas pasadas)
	        Administrativo emp1 = new Administrativo("AB01", "35111222", "Carlos Jose Gómez", LocalDate.of(2020, 5, 10), 2);
	        
	        Profesional emp2 = new Profesional("OP01", "32444555", "Analia Rodríguez", LocalDate.of(2018, 3, 15), 3);
	        Profesional emp4 = new Profesional("OP04", "33488566", "Camilo Mamani", LocalDate.of(2019, 2, 10), 1);
	        
	        Limpieza emp3 = new Limpieza("LM01", "40888999", "Mariano Luis López", LocalDate.of(2022, 1, 20), 0);

	        emp2.agregarTitulo(new Titulo("Ingeniería en Informática", "Universitario", 2015));
	        emp2.agregarTitulo(new Titulo("Magister en Software", "Universitario", 2017));
	        
	        emp4.agregarTitulo(new Titulo("Analista Programador Universitario", "Terciario", 2016));
	        emp4.agregarTitulo(new Titulo("Licenciatura en Sistema", "Universitario", 2018));

	        manager.agregarEmpleado(emp1);
	        manager.agregarEmpleado(emp2);
	        manager.agregarEmpleado(emp3);
	        manager.agregarEmpleado(emp4);
	        
	        // 2. Probar búsquedas e impresiones de Sueldo Neto
	        Empleado buscado = manager.buscarPorLegajo("OP01");
	        if (buscado != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Nombre: " + buscado.getNombre());
	            System.out.println("Antigüedad: " + buscado.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado.calcularSueldoNeto());
	        }
	        
	        System.out.println();
	        
	        Empleado buscado2 = manager.buscarPorLegajo("OP04");
	        if (buscado2 != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Nombre: " + buscado2.getNombre());
	            System.out.println("Antigüedad: " + buscado2.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado2.calcularSueldoNeto());
	        }
	        
	        System.out.println();
	        
	        Empleado buscado3 = manager.buscarPorLegajo("AB01");
	        if (buscado3 != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Legajo: " + buscado3.getLegajo());
	            System.out.println("Documento: " + buscado3.getDocumento());
	            System.out.println("Nombre: " + buscado3.getNombre());
	            System.out.println("Hijos: " + buscado3.getCantidadHijos());
	            System.out.println("Antigüedad: " + buscado3.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado3.calcularSueldoNeto());
	        }
	        
	        System.out.println();
	        
	        Empleado buscado4 = manager.buscarPorLegajo("OP01");
	        if (buscado4 != null) {
	            System.out.println("--- DATOS DE EMPLEADO ---");
	            System.out.println("Legajo: " + buscado4.getLegajo());
	            System.out.println("Documento: " + buscado4.getDocumento());
	            System.out.println("Nombre: " + buscado4.getNombre());
	            System.out.println("Hijos: " + buscado4.getCantidadHijos());
	            System.out.println("Antigüedad: " + buscado4.getAntiguedad() + " años");
	            System.out.println("Sueldo Neto: $" + buscado4.calcularSueldoNeto());
	        }
	        
	        // e. Obtener y mostrar los empleados de un categoría X

		     	System.out.println();
		     	System.out.println("--- CONSULTA DE EMPLEADOS POR CATEGORÍA ---");
		     	System.out.print("Ingrese la categoría del empleado administrativo (A, B, C, etc.): ");
	
		     	String entradaCategoria = scanner.nextLine().trim();
	
	     	if (!entradaCategoria.isEmpty()) {
	     		char categoria = entradaCategoria.charAt(0);
	
	     		manager.mostrarEmpleadosPorCategoria(categoria);
	     	} else {
	     		System.out.println("No ingresó ninguna categoría.");
	     	}
	        
	        // f. Calcular el importe neto acumulado del tipo solicitado por teclado
	      
	        System.out.println("--- OPERACIÓN F: Consulta de masa salarial por tipo ---");
	        System.out.println("Ingrese el tipo de empleado (Administrativo / Profesional / Limpieza): ");
	        String tipoSolicitado = scanner.nextLine().trim();
	        
	        // El manager resuelve todo el cálculo matemático en una sola línea
	        double totalNetoTipo = manager.calculoNetoAcumuladoPorTipo(tipoSolicitado);
	        
	        System.out.println("El importe neto acumulado total para '" + tipoSolicitado + "' es: $" + totalNetoTipo);

	        scanner.close();
	    }
}
