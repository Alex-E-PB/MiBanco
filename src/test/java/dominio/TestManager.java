package dominio;

import org.example.dominio.Genero;
import org.example.dominio.Manager;

import java.util.Date;

public class TestManager {
    public static void main(String[] args) {
        System.out.println("----- PRUEBA CONSTRUCTOR POR DEFECTO -----");
        Manager m1 = new Manager();
        System.out.println(m1);

        System.out.println("\n----- PRUEBA CONSTRUCTOR CON PARÁMETROS -----");
        Manager m2 = new Manager(
                201,
                "Carlos",
                "González",
                "carlos.gonzalez@empresa.com",
                Genero.MASCULINO,
                5000.0,
                "Manager",
                new Date(),
                "Recursos Humanos"
        );
        System.out.println(m2);

        System.out.println("\n----- PRUEBA DE SETTERS Y VALIDACIONES -----");
        m2.setSalario(-1000);    // inválido, debe ajustar a 0
        m2.setDepNombre("");     // inválido, debe asignar "Sin departamento"
        System.out.println(m2);

        System.out.println("\n----- PRUEBA DE GETTERS -----");
        System.out.println("Salario: " + m2.getSalario());
        System.out.println("Departamento: " + m2.getDepNombre());

        System.out.println("\n----- CÁLCULO DE BONO ANUAL -----");
        System.out.printf("Bono anual de %s: $%.2f\n", m2.getNombre(), m2.calcularBonoAnual());
    }
}

