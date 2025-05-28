package org.example.dominio;

import java.util.Date;

/**
 * Representa un Manager que es un tipo especial de Empleado
 */
public class Manager extends Empleado {
    private int managerId;
    private String depNombre; // nombre del departamento

    /**
     * Constructor por defecto
     */
    public Manager() {
        super();
        this.managerId=1;
        this.depNombre = "Sin departamento";
    }

    /**
     * Constructor con todos los atributos
     * @param id ID del manager
     * @param nombre Nombre del manager
     * @param apellido Apellido del manager
     * @param correo Correo del manager
     * @param genero Género del manager
     * @param salario Salario del manager
     * @param puesto Puesto del manager (ej. Manager)
     * @param fechaContratacion Fecha de contratación
     * @param depNombre Nombre del departamento
     */
    public Manager(int id, String nombre, String apellido, String correo,
                   Genero genero, double salario, String puesto,
                   Date fechaContratacion, String depNombre) {
        super(id, nombre, apellido, correo, genero, salario, puesto, fechaContratacion);
        setDepNombre(depNombre);
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        if (managerId >= 0) {
            this.managerId = managerId;
        } else {
            System.out.println("Error: código inválido " + managerId);
        }
    }

    /**
     * Obtiene el nombre del departamento
     * @return Nombre del departamento
     */
    public String getDepNombre() {
        return depNombre;
    }

    /**
     * Establece el nombre del departamento con validación
     * @param depNombre Nuevo nombre del departamento
     */
    public void setDepNombre(String depNombre) {
        if (depNombre != null && !depNombre.trim().isEmpty()) {
            this.depNombre = depNombre;
        } else {
            System.out.println("Error: nombre de departamento inválido");
            this.depNombre = "Sin departamento";
        }
    }

    /**
     * Método para mostrar la información completa del Manager
     * @return String con la info del Manager
     */
    @Override
    public String toString() {
        return super.toString() + ", Departamento=" + depNombre + "]";
    }
}

