package org.example.dominio;

public class Cuenta {
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

    public void deposito(double monto) {
        if (monto > 0) {
            this.balance += monto;
        } else {
            System.out.println("El monto debe ser mayor a 0.");
        }
    }

    public void retiro(double monto) {
        if (monto > 0 && monto <= balance) {
            this.balance -= monto;
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta [Balance: " + balance + "]";
    }
}


