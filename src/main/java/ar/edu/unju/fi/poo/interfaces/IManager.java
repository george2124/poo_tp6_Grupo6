package ar.edu.unju.fi.poo.interfaces;

import ar.edu.unju.fi.poo.domain.RegistroIngresoSalida;

public interface IManager {
    boolean validarPatente(String patente);
    void registrarIngreso(RegistroIngresoSalida registro);
    Double registrarSalida(RegistroIngresoSalida registro);
    RegistroIngresoSalida obtenerRegistro(Integer id);
}