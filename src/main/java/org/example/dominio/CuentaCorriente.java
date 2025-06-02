package org.example.dominio;

public class CuentaCorriente extends Cuenta {
    private double sobregiro;

    public CuentaCorriente() {
        super();
        this.sobregiro = 0.0;
    }

    public CuentaCorriente(double balance, double sobregiro) {
        super(balance);
        if (sobregiro >= 0) {
            this.sobregiro = sobregiro;
        } else {
            this.sobregiro = 0.0;
        }
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        if (sobregiro >= 0) {
            this.sobregiro = sobregiro;
        } else {
            System.out.println("El sobregiro no puede ser menor a 0.");
        }
    }

    public double consultarSobregiro() {
        if (sobregiro >= 0) {
            return sobregiro;
        } else {
            return 0.0;
        }
    }

    @Override
    public boolean retiro(double monto) {
        if (monto > 0 && monto <= balance + sobregiro) {
            balance -= monto;

            if (balance < 0) {
                double sobregiroInicial = sobregiro;
                sobregiro += balance; // balance es negativo
                balance = 0;
                double sobregiroRestante = sobregiroInicial - sobregiro;
                sobregiro = -sobregiroRestante;
            }

            System.out.println("Retiro exitoso. Saldo actual: " + balance + ". Sobregiro disponible: " + consultarSobregiro());
            return true;
        } else {
            System.out.println("Fondos insuficientes incluso con sobregiro.");
            return false;
        }
    }

    @Override
    public boolean deposito(double monto) {
        if (monto > 0) {
            if (sobregiro < 0) {
                double cubrirSobregiro = monto;
                if (cubrirSobregiro > -sobregiro) {
                    cubrirSobregiro = -sobregiro;
                }
                sobregiro += cubrirSobregiro;
                monto -= cubrirSobregiro;
            }

            balance += monto;

            System.out.println("Depósito exitoso. Saldo actual: " + balance + ". Sobregiro disponible: " + consultarSobregiro());
            return true;
        } else {
            System.out.println("El monto debe ser mayor a 0.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cuenta Corriente [Saldo actual: " + balance +
                ", Sobregiro disponible: " + consultarSobregiro() +
                ", Total disponible: " + (balance + sobregiro) + "]";
    }
}

