package ar.edu.unju.fi.poo.domain;

import java.time.LocalTime;

public class Mensual extends RegistroIngresoSalida {
    private Double tarifa;
    private Cliente cliente;
    private Cupon cupon;

    public Mensual(Integer id, Vehiculo vehiculo, LocalTime hora, Double tarifa, Cliente cliente, Cupon cupon) {
        super(id, vehiculo, hora);
        this.tarifa = tarifa;
        this.cliente = cliente;
        this.cupon = cupon;
    }

    public Double getTarifa() { 
        return tarifa; 
    }
    
    public void setTarifa(Double tarifa) { 
        this.tarifa = tarifa; 
    }

    public Cliente getCliente() { 
        return cliente; 
    }
    
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public Cupon getCupon() { 
        return cupon; 
    }
    
    public void setCupon(Cupon cupon) { 
        this.cupon = cupon; 
    }

    @Override
    public Double obtenerImporte() {
        if (cupon != null) {
            // Aplica el descuento si el cliente presentó un cupón
            double descuento = tarifa * (cupon.getPorcentajeDescuento() / 100);
            return tarifa - descuento;
        }
        return tarifa; // Si no hay cupón, paga la tarifa completa
    }
}