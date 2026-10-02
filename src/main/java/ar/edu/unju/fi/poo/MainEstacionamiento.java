package ar.edu.unju.fi.poo;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unju.fi.poo.domain.Cliente;
import ar.edu.unju.fi.poo.domain.Cupon;
import ar.edu.unju.fi.poo.domain.Mensual;
import ar.edu.unju.fi.poo.domain.PorHora;
import ar.edu.unju.fi.poo.domain.Vehiculo;
import ar.edu.unju.fi.poo.interfaces.IManager;
import ar.edu.unju.fi.poo.interfaces.imp.ManagerImp;

public class MainEstacionamiento {

    public static void main(String[] args) {
        
        // 1. Instanciar el manager usando la Interfaz (Polimorfismo)
        IManager manager = new ManagerImp();

        // 2. Crear vehículos de prueba
        Vehiculo moto1 = new Vehiculo("A123BCD", "Guerrero Trip 110", "Negro");
        Vehiculo moto2 = new Vehiculo("Z987XW", "Gilera Smash 125", "Azul");

        // 3. Crear un cliente y un cupón de descuento
        Cliente cliente1 = new Cliente(1, "40123456", "San Pedro de Jujuy", "3888123456");
        Cupon cuponDescuento = new Cupon("DESC20", LocalDate.now().plusDays(10), 20.0);

        // 4. Crear registros de ingreso
        // Simulamos que la primera moto entró hace 3 horas. Tarifa: $500 la hora
        PorHora ingresoPorHora = new PorHora(1, moto1, LocalTime.now().minusHours(3), 500.0);
        
        // Ingreso mensual con cliente asociado y cupón. Tarifa: $15000 el mes
        Mensual ingresoMensual = new Mensual(2, moto2, LocalTime.now(), 15000.0, cliente1, cuponDescuento);

        // 5. Probar la lógica de negocio a través del Manager
        System.out.println("--- REGISTRO DE INGRESOS ---");
        manager.registrarIngreso(ingresoPorHora);
        manager.registrarIngreso(ingresoMensual);

        // Intentar ingresar la misma moto de nuevo para probar si la validación funciona
        System.out.println("\n--- PRUEBA DE VALIDACIÓN ---");
        manager.registrarIngreso(ingresoPorHora);

        // 6. Registrar las salidas y ver el cálculo de importes
        System.out.println("\n--- REGISTRO DE SALIDAS ---");
        manager.registrarSalida(ingresoPorHora);
        manager.registrarSalida(ingresoMensual);
    }

}