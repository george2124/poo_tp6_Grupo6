package ar.edu.unju.poo.punto2.model;

import java.time.LocalDate;

public class EmpleadoValidacionPrueba {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA DE VALIDACION DE LEGAJOS ===");

        // PRUEBA 1: Legajo correcto
        try {
            Administrativo empleado = new Administrativo(
                "1234-26",
                "35111222",
                "Carlos",
                LocalDate.of(2020, 1, 10),
                2
            );

            System.out.println("PRUEBA 1: CORRECTA");
            System.out.println("Legajo aceptado: " + empleado.getLegajo());

        } catch (EmpleadoValidacionException e) {
            System.out.println("PRUEBA 1: ERROR: " + e.getMessage());
        }

        // PRUEBA 2: Legajo incorrecto
        try {
            Administrativo empleado = new Administrativo(
                "AB01",
                "35111223",
                "Ana",
                LocalDate.of(2020, 1, 10),
                1
            );

            System.out.println("PRUEBA 2: ERROR: acepto un legajo invalido");

        } catch (EmpleadoValidacionException e) {
            System.out.println("PRUEBA 2: CORRECTA");
            System.out.println("Rechazo el legajo invalido: " + e.getMessage());
        }

        // PRUEBA 3: Legajo con cinco digitos
        try {
            Administrativo empleado = new Administrativo(
                "12345-26",
                "35111224",
                "Pedro",
                LocalDate.of(2020, 1, 10),
                0
            );

            System.out.println("PRUEBA 3: ERROR: acepto cinco digitos");

        } catch (EmpleadoValidacionException e) {
            System.out.println("PRUEBA 3: CORRECTA");
            System.out.println("Rechazo los cinco digitos: " + e.getMessage());
        }
    }
}
