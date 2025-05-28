package dominio;
import org.example.dominio.Empleado;
import org.example.dominio.Genero;

import java.util.Date;

public class TestEmpleado {
    public static void main(String[] args) {
        System.out.println("----- PRUEBA CONSTRUCTOR POR DEFECTO -----");
        Empleado emp1 = new Empleado();
        System.out.println(emp1);

        System.out.println("\n----- PRUEBA CONSTRUCTOR CON PARÁMETROS -----");
        Empleado emp2 = new Empleado(
                101,
                "Ana",
                "Ramírez",
                "ana.ramirez@banco.com",
                Genero.FEMENINO,
                1500.0,
                "Asesora",
                new Date()
        );
        System.out.println(emp2);

        System.out.println("\n----- PRUEBA DE SETTERS Y VALIDACIONES -----");
        emp2.setSalario(-300); // inválido
        emp2.setPuesto("");    // inválido
        emp2.setFechaContratacion(null); // inválido
        System.out.println(emp2);

        System.out.println("\n----- PRUEBA DE GETTERS -----");
        System.out.println("Salario: " + emp2.getSalario());
        System.out.println("Puesto: " + emp2.getPuesto());
        System.out.println("Fecha de Contratación: " + emp2.getFechaContratacion());

        System.out.println("\n----- CÁLCULO DE BONO ANUAL -----");
        System.out.printf("Bono anual de %s: $%.2f\n", emp2.getNombre(), emp2.calcularBonoAnual());
    }
}


