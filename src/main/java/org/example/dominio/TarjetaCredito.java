package org.example.dominio;

public class TarjetaCredito extends Cuenta {
    private double cupo;

    public TarjetaCredito() {
        super(0);
        this.cupo = 1000.0;
    }

    public TarjetaCredito(double cupo) {
        super(0);
        if (cupo > 0) {
            this.cupo = cupo;
        } else {
            this.cupo = 1000.0;
        }
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double nuevoCupo) {
        if (nuevoCupo > 0) {
            this.cupo = nuevoCupo;
        } else {
            System.out.println("Error: el cupo debe ser mayor a 0.");
        }
    }

    @Override
    public boolean retiro(double monto) {
        if (monto > 0 && monto <= cupo) {
            cupo -= monto;
            System.out.println("Se usaron $" + monto + " del cupo. Cupo restante: " + cupo);
            return true;
        } else {
            System.out.println("No puede usar más del cupo disponible.");
            return false;
        }
    }

    @Override
    public boolean deposito(double monto) {
        if (monto > 0) {
            cupo += monto;
            System.out.println("Se pagaron $" + monto + ". Cupo disponible ahora: " + cupo);
            return true;
        } else {
            System.out.println("El monto debe ser mayor a 0.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tarjeta de Crédito [Cupo disponible: " + cupo + "]";
    }
}

