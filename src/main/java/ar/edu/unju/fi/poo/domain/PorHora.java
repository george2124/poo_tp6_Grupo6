package ar.edu.unju.fi.poo.domain;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PorHora extends RegistroIngresoSalida {
    private Double tarifa;

    public PorHora(Integer id, Vehiculo vehiculo, LocalTime hora, Double tarifa) {
        super(id, vehiculo, hora);
        this.tarifa = tarifa;
    }

    public Double getTarifa() { 
        return tarifa; 
    }
    
    public void setTarifa(Double tarifa) { 
        this.tarifa = tarifa; 
    }

    @Override
    public Double obtenerImporte() {
        // Calcula las horas transcurridas desde el ingreso hasta el momento de salida
        long horas = ChronoUnit.HOURS.between(getHora(), LocalTime.now());
        
        // Si estuvo menos de una hora, se cobra la hora completa como mínimo
        if (horas == 0) {
            horas = 1;
        }
        return horas * tarifa;
    }
}
