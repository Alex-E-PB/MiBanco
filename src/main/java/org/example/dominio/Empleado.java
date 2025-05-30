package org.example.dominio;

import java.util.Date;
import java.util.Objects;

public class Empleado extends Cliente {
    private int empleadoId;
    private double salario;
    private String puesto;
    private Date fechaContratacion;

    public Empleado() {
        super();
        this.empleadoId=1;
        this.salario = 0.0;
        this.puesto = "Sin asignar";
        this.fechaContratacion = new Date();
    }

    public Empleado(int id, String nombre, String apellido, String correo,
                    Genero genero, double salario, String puesto, Date fechaContratacion) {
        super(id, nombre, apellido, correo, fechaContratacion, genero);  // <--- aquí está la corrección
        setSalario(salario);
        setPuesto(puesto);
        setFechaContratacion(fechaContratacion);
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        if (empleadoId >= 0) {
            this.empleadoId = empleadoId;
        } else {
            System.out.println("Error: código inválido " + empleadoId);
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Error: el salario no puede ser negativo");
            this.salario = 0.0;
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("Error: puesto inválido");
            this.puesto = "Sin asignar";
        }
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        if (fechaContratacion != null) {
            this.fechaContratacion = new Date(fechaContratacion.getTime());
        } else {
            System.out.println("Advertencia: fecha de contratación nula. Se asigna fecha actual.");
            this.fechaContratacion = new Date();
        }
    }

    public double calcularBonoAnual() {
        return salario * 0.30;
    }

    @Override
    public String toString() {
        return "Empleado [ID=" + getClienteId() +
                ", Nombre=" + getNombre() +
                ", Apellido=" + getApellido() +
                ", Correo=" + getCorreo() +
                ", Género=" + getGenero() +
                ", Puesto=" + puesto +
                ", Salario=$" + String.format("%.2f", salario) +
                ", Fecha Contratación=" + fechaContratacion +
                ", Bono Anual=$" + String.format("%.2f", calcularBonoAnual()) +
                "]";
    }

    @Override
    public int hashCode(){
        int hash=1;
        hash=7*hash+ Objects.hashCode(this.getNombre());
        hash=7*hash+ Objects.hashCode(this.getApellido());
        return hash;
    }
}
