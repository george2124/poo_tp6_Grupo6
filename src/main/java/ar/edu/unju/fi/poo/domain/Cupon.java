package ar.edu.unju.fi.poo.domain;

import java.time.LocalDate;

public class Cupon {
    private String codigo;
    private LocalDate fechaVencimiento;
    private Double porcentajeDescuento;

    public Cupon(String codigo, LocalDate fechaVencimiento, Double porcentajeDescuento) {
        this.codigo = codigo;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public Double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(Double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }
}