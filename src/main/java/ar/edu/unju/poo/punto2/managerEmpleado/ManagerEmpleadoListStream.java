package ar.edu.unju.poo.punto2.managerEmpleado;

import ar.edu.unju.poo.punto1tp8.excepciones.EmpleadoValidacionException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.poo.punto2.interfaces.IManagerEmpleado;
import ar.edu.unju.poo.punto2.model.Empleado;

public class ManagerEmpleadoListStream implements IManagerEmpleado {
    
    private List<Empleado> empleados;

    public ManagerEmpleadoListStream() {
        this.empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    private void validarDocumentoUnico(String documento) {
        boolean duplicado = empleados.stream()
                .anyMatch(emp -> emp.getDocumento().equals(documento));
        
        if (duplicado) {
            throw new EmpleadoValidacionException("Error: El documento " + documento + " ya está registrado.");
        }
    }

    @Override
    public void agregar(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public void modificar(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getLegajo().equals(empleado.getLegajo())) {
                empleados.set(i, empleado);
                return;
            }
        }
    }

    @Override
    public Empleado buscar(String legajo) {
        return empleados.stream()
                .filter(e -> e.getLegajo().equals(legajo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Empleado> buscarTipoEmpleado(String tipo) {
        return empleados.stream()
                .filter(e -> e.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Empleado> buscarAntiguedadMayor(Integer anio) {
        return empleados.stream()
                .filter(e -> e.getAntiguedad() > anio) 
                .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerNombresOrdenados(List<Empleado> empleadosList) {
        return empleadosList.stream()
                .map(Empleado::getNombre)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Double obtenerCantidad(List<Empleado> empleadosList) {
        return (double) empleadosList.size();
    }

    @Override
    public Double obtenerNetoTotalAcumulado(List<Empleado> empleadosList) {
        return empleadosList.stream()
                .mapToDouble(Empleado::calcularSueldoNeto)
                .sum();
    }
}