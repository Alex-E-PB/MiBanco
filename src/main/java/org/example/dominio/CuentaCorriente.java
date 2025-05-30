package org.example.dominio;

public class CuentaCorriente extends Cuenta {
    private double sobregiro;

    public CuentaCorriente() {
        super();
        this.sobregiro = 0.0;
    }

    public CuentaCorriente(double balance, double sobregiro) {
        super(balance);
        this.sobregiro = Math.max(sobregiro, 0);
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



    // Método sobregiro disponible
    public double consultarSobregiro() {
        return Math.max(0, sobregiro);
    }
    double sobregiroinicial=sobregiro;


    @Override
    public void retiro(double monto) {
        if (monto <= balance + sobregiro) {
            balance -= monto;
            if (balance < 0) {
                double sobregiroinicial=sobregiro;

                sobregiro += balance;
                balance = 0;
                double sobregirorestante=sobregiroinicial-sobregiro;
                sobregiro=-sobregirorestante;
            }
            System.out.println("Retiro exitoso. Saldo actual: " + balance + ". Sobregiro disponible: " + consultarSobregiro());
        } else {
            System.out.println("Fondos insuficientes incluso con sobregiro.");
        }
    }

    @Override
    public void deposito(double monto) {

        if (monto > 0) {

            if (sobregiro < 0) {
                double cubrirSobregiro = Math.min(-sobregiro, monto);
                sobregiro += cubrirSobregiro;
                monto -= cubrirSobregiro;
            }

            // Ahora, lo que queda del depósito se va al balance
            balance += monto;


            System.out.println("Depósito exitoso. Saldo actual: " + balance + ". Sobregiro disponible: " + consultarSobregiro());


        } else {
            System.out.println("El monto debe ser mayor a 0.");
        }


    }


    // Sobrescritura del método toString
    @Override
    public String toString() {
        return "Cuenta Corriente [Saldo actual: " + balance +
                ", Sobregiro disponible: " + consultarSobregiro() +
                ", Total disponible: " + (balance + sobregiro) + "]";
    }
}
