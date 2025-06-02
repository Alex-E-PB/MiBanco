package dominio;

import org.example.dominio.Cuenta;

public class TestCuenta {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100.0) {
            @Override
            public boolean deposito(double monto) {
                return false;
            }

            @Override
            public boolean retiro(double monto) {
                return false;
            }
        };
        System.out.println("Saldo inicial: " + cuenta.getBalance());

        cuenta.deposito(150.0);
        System.out.println("Saldo después del depósito: " + cuenta.getBalance());

        cuenta.retiro(100.0);
        System.out.println("Saldo después del retiro: " + cuenta.getBalance());
    }
}

