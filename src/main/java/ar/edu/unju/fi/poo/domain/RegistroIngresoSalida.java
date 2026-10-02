package ar.edu.unju.fi.poo.domain;

import java.time.LocalTime;

public abstract class RegistroIngresoSalida {
    private Integer id;
    private Vehiculo vehiculo;
    private LocalTime hora;
    private String estado;

    public RegistroIngresoSalida(Integer id, Vehiculo vehiculo, LocalTime hora) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.hora = hora;
        this.estado = "INGRESADO"; // Estado inicial por defecto
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public abstract Double obtenerImporte();
}
