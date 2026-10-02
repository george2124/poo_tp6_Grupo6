ManagerImp:

package ar.edu.unju.fi.poo.interfaces.imp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.poo.domain.PorHora;
import ar.edu.unju.fi.poo.domain.RegistroIngresoSalida;
import ar.edu.unju.fi.poo.interfaces.IManager;

public class ManagerImp implements IManager {
    private List<RegistroIngresoSalida> registros;

    public ManagerImp() {
        this.registros = new ArrayList<>();
    }

    @Override
    public boolean validarPatente(String patente) {
        for (RegistroIngresoSalida reg : registros) {
            if (reg.getVehiculo().getPatente().equals(patente) && reg.getEstado().equals("INGRESADO")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registrarIngreso(RegistroIngresoSalida registro) {
        if (validarPatente(registro.getVehiculo().getPatente())) {
            System.out.println("Error: El vehículo ya está en la playa.");
            return;
        }
        if (registro instanceof PorHora) {
            if (registro.getHora().isAfter(LocalTime.of(21, 0))) {
                System.out.println("Error: Ingreso fuera de horario.");
                return;
            }
        }
        registro.cambiarEstado("INGRESADO");
        registros.add(registro);
        System.out.println("Ingreso registrado: " + registro.getVehiculo().getPatente());
    }

    @Override
    public Double registrarSalida(RegistroIngresoSalida registro) {
        registro.cambiarEstado("AFUERA");
        Double importe = registro.obtenerImporte();
        System.out.println("Salida de " + registro.getVehiculo().getPatente() + ". A pagar: $" + importe);
        return importe;
    }

    @Override
    public RegistroIngresoSalida obtenerRegistro(Integer id) {
        for (RegistroIngresoSalida reg : registros) {
            if (reg.getId().equals(id)) {
                return reg;
            }
        }
        return null;
    }
}