package org.example.dominio;

import java.util.Date;

public class Director extends Manager {
    private double presupuesto;
    private double presupuestoDisponible;

    // Constructor por defecto
    public Director() {
        super();
        this.presupuesto = 0.0;
        this.presupuestoDisponible = 0.0;
    }

    // Constructor con parámetros
    public Director(int id, String nombre, String apellido, String correo,
                    Genero genero, double salario, String puesto,
                    Date fechaContratacion, String depNombre, double presupuesto, double presupuestoDisponible) {
        super();
        setPresupuesto(presupuesto);
        setPresupuestoDisponible(presupuestoDisponible);
        this.presupuesto = presupuesto;
        this.presupuestoDisponible = presupuesto;
    }

    // metodo aprobarGasto(double gasto)
    public boolean aprobarGasto(double gasto) {
        if (gasto <= 0) {
            System.out.println("El gasto debe ser mayor a 0.");
            return false;
        }

        if (gasto > presupuestoDisponible) {
            System.out.println("Gasto rechazado. Exede el presupuesto.");
            System.out.println("Gasto solicitado: " + gasto);
            System.out.println("Presupuesto disponible: " + presupuestoDisponible);
            return false;
        }

        presupuestoDisponible -= gasto;
        System.out.println("Gasto aprobado por $" + gasto);
        System.out.println("Presupuesto restante: $" + presupuestoDisponible);
        return true;
    }

    // Getters y Setters
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        if (presupuesto > 0) {
            this.presupuesto = presupuesto;
        } else {
            System.out.println("El presupuesto no puede ser negativo.");
        }
    }

    public double getPresupuestoDisponible() {
        return presupuestoDisponible;
    }

    public void setPresupuestoDisponible(double presupuestoDisponible) {
        if (presupuestoDisponible > 0) {
            this.presupuestoDisponible = presupuestoDisponible;
        } else {
            System.out.println("No podemos mostrar presupuesto porque no tiene");
        }
    }
    //to String

    @Override
    public String toString() {
        return super.toString();
    }
}
