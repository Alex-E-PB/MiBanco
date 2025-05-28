package dominio;

import org.example.dominio.Cliente;
import org.example.dominio.Genero;

import java.util.Date;

public class TestCliente {
    Cliente cliente;

    public void testConstructor() {
        cliente = new Cliente();
        System.out.println("Constructor vacío: " + cliente);

        Cliente clienteBasico = new Cliente(201, "Lucía", "Fernández");
        System.out.println("Constructor básico: " + clienteBasico);

        Cliente clienteCompleto = new Cliente(
                203,
                "Tomás",
                "Villalba",
                "tomas.v@example.org",
                new Date(), // fecha actual
                Genero.MASCULINO
        );
        System.out.println("Constructor completo: " + clienteCompleto);
    }

    public void testSet() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        cliente.setClienteId(200);
        cliente.setNombre("Martina");
        cliente.setApellido("Castro");
        cliente.setCorreo("martina.castro@example.com");
        cliente.setCorreo("correo_sin_arroba");

        Date fechaValida = new Date(125, 3, 30); // 2025-04-30
        cliente.setFecha(fechaValida);
        System.out.println("Cliente modificado: " + cliente);
    }

    public void testGet() {
        if (cliente == null) {
            System.out.println("Error: el cliente no ha sido inicializado");
            return;
        }
        System.out.println("Id: " + cliente.getClienteId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Fecha: " + cliente.getFecha());
    }

    public void testValidaciones() {
        System.out.println("\n=== Prueba de validaciones ===");

        Cliente clientePrueba = new Cliente();

        clientePrueba.setClienteId(-10);
        System.out.println("ID después de intentar valor negativo: " + clientePrueba.getClienteId());

        clientePrueba.setNombre("");
        System.out.println("Nombre después de intentar valor vacío: " + clientePrueba.getNombre());

        clientePrueba.setCorreo("correo_invalido.com");
        System.out.println("Correo después de formato inválido: " + clientePrueba.getCorreo());

        clientePrueba.setCorreo("prueba@correo.com");
        System.out.println("Correo después de formato válido: " + clientePrueba.getCorreo());
    }
}
