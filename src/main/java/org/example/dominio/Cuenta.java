package org.example.dominio;

public abstract class Cuenta {
    protected double balance;

    public Cuenta() {
        this.balance = 0.0;
    }

    public Cuenta(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract boolean deposito(double monto);
    public abstract boolean retiro(double monto);

    @Override
    public String toString() {
        return "Cuenta [Balance: " + balance + "]";
    }
}



