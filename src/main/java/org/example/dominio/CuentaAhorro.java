package org.example.dominio;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double montoInteres;

    public CuentaAhorro() {
        super();
        this.tasaInteres = 0.0;
        this.montoInteres = 0.0;
    }

    public CuentaAhorro(double balance, double tasaInteres) {
        super(balance);
        this.tasaInteres = tasaInteres;
        this.montoInteres = 0.0;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void calculoInteres() {
        double interesCalculado = balance * (tasaInteres / 100);
        System.out.println("Balance actual: " + balance);
        System.out.println("Interés calculado (con tasa de " + tasaInteres + "%): " + interesCalculado);
        System.out.println("De acuerdo al Balance actual, al finalizar el mes su balance será de: " + (balance + interesCalculado));
        System.out.println("Interés acumulado actual: " + montoInteres);
    }

    @Override
    public boolean retiro(double monto) {
        if (monto > 0 && monto <= balance) {
            balance -= monto;
            return true;
        } else {
            System.out.println("No puede retirar más de su saldo actual.");
            return false;
        }
    }

    @Override
    public boolean deposito(double monto) {
        if (monto > 0) {
            balance += monto;
            return true;
        } else {
            System.out.println("El monto debe ser mayor a 0.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cuenta de Ahorro [Saldo actual: " + balance + ", Interés acumulado: " + montoInteres + "]";
    }
}
