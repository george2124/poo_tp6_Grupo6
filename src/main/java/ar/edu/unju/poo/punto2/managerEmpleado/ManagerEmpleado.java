package ar.edu.unju.poo.punto2.managerEmpleado;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.poo.punto2.intercafes.IManagerEmpleado;
import ar.edu.unju.poo.punto2.model.Administrativo;
import ar.edu.unju.poo.punto2.model.Empleado;
import ar.edu.unju.poo.punto2.model.Limpieza;
import ar.edu.unju.poo.punto2.model.Profesional;

public class ManagerEmpleado implements IManagerEmpleado {
	private List<Empleado> listaEmpleados;

	public ManagerEmpleado() {
		super();
		this.listaEmpleados = new ArrayList<>();
	}
	
	// =========================================================================
		// OPERACIONES OBLIGATORIAS DE LA INTERFAZ (IManagerEmpleado)
		// =========================================================================

		@Override
		public void agregar(Empleado empleado) {
			// Reutilizamos tu lógica original de validación de legajos antes de agregar
			for (Empleado e : listaEmpleados) {
				if (e.getLegajo().equals(empleado.getLegajo())) {
					System.out.println("Error: El legajo " + empleado.getLegajo() + " ya existe.");
					return; // Corta la ejecución si ya existe
				}
			}
			listaEmpleados.add(empleado);
		}

		@Override
		public void modificar(Empleado empleado) {
			// Buscamos el empleado existente por su legajo
			Empleado encontrado = buscar(empleado.getLegajo());
			if (encontrado != null) {
				int indice = listaEmpleados.indexOf(encontrado);
				listaEmpleados.set(indice, empleado); // Reemplaza los datos viejos por los nuevos
				System.out.println("Empleado con legajo " + empleado.getLegajo() + " modificado con éxito.");
			} else {
				System.out.println("Error: No se encontró ningún empleado con el legajo " + empleado.getLegajo());
			}
		}

		@Override
		public Empleado buscar(String legajo) {
			// Implementación directa utilizando tu bucle original de búsqueda
			for (Empleado e : listaEmpleados) {
				if (e.getLegajo().equals(legajo)) {
					return e;
				}
			}
			return null;
		}

		@Override
		public List<Empleado> buscarTipoEmpleado(String tipo) {
			List<Empleado> filtrados = new ArrayList<>();
			for (Empleado e : listaEmpleados) {
				boolean coincide = false;
				if (tipo.equalsIgnoreCase("Profesional") && e instanceof Profesional) coincide = true;
				if (tipo.equalsIgnoreCase("Administrativo") && e instanceof Administrativo) coincide = true;
				if (tipo.equalsIgnoreCase("Limpieza") && e instanceof Limpieza) coincide = true;
				
				if (coincide) {
					filtrados.add(e);
				}
			}
			return filtrados;
		}

		@Override
		public List<Empleado> buscarAntiguedadMayor(Integer anio) {
			List<Empleado> filtrados = new ArrayList<>();
			for (Empleado e : listaEmpleados) {
				// Llama al método getAntiguedad() de tu clase Empleado
				if (e.getAntiguedad() > anio) {
					filtrados.add(e);
				}
			}
			return filtrados;
		}

		@Override
		public List<String> obtenerNombresOrdenados(List<Empleado> empleados) {
			List<String> nombres = new ArrayList<>();
			for (Empleado e : empleados) {
				nombres.add(e.getNombre());
			}
			// Ordenamiento alfabético elemental (A-Z)
			nombres.sort(String::compareTo);
			return nombres;
		}

		@Override
		public Double obtenerCantidad(List<Empleado> empleados) {
			// Devuelve el tamaño de la lista que recibe como parámetro, convertido a Double
			return (double) empleados.size();
		}

		@Override
		public Double obtenerNetoTotalAcumulado(List<Empleado> empleados) {
			double totalNeto = 0.0;
			for (Empleado e : empleados) {
				totalNeto += e.calcularSueldoNeto();
			}
			return totalNeto;
		}

	
	//metodos del tp6
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
			
			if (coincide) {
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
    
    // Operación 2: mostrar empleados y acumular sus importes
    public void mostrarEmpleadosPorCategoria(char categoria) {
        List<Administrativo> empleados =
                obtenerEmpleadosPorCategoria(categoria);

        double totalRemunerativos = 0;
        double totalSalarioFamiliar = 0;
        double totalDescuentos = 0;
        double totalNeto = 0;

        System.out.println("\nEmpleados de categoría "
                + Character.toUpperCase(categoria));

        if (empleados.isEmpty()) {
            System.out.println("No se encontraron empleados de esa categoría.");
            return;
        }

        for (Administrativo e : empleados) {
            System.out.println("-----------------------------");
            System.out.println("Legajo: " + e.getLegajo());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Remunerativos bonificables: "
                    + e.getRemunerativosBonificables());
            System.out.println("Salario familiar: " + e.getSalarioFamiliar());
            System.out.println("Descuentos: " + e.getDescuentos());
            System.out.println("Importe neto: " + e.calcularSueldoNeto());

            totalRemunerativos += e.getRemunerativosBonificables();
            totalSalarioFamiliar += e.getSalarioFamiliar();
            totalDescuentos += e.getDescuentos();
            totalNeto += e.calcularSueldoNeto();
        }

        System.out.println("\n===== TOTALES ACUMULADOS =====");
        System.out.println("Total remunerativos bonificables: "
                + totalRemunerativos);
        System.out.println("Total salario familiar: " + totalSalarioFamiliar);
        System.out.println("Total descuentos: " + totalDescuentos);
        System.out.println("Total importe neto: " + totalNeto);
    }

}
