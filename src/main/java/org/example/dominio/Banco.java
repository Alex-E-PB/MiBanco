package org.example.dominio;

import java.util.Date;

public class Banco {
    // Arreglos para cada tipo
    private Cliente[] clientes;
    private int numClientes;

    private Empleado[] empleados;
    private int numEmpleados;

    private Manager[] managers;
    private int numManagers;

    // Tamaño inicial de arreglos
    private static final int INICIAL = 3;

    public Banco() {
        clientes = new Cliente[INICIAL];
        numClientes = 0;

        empleados = new Empleado[INICIAL];
        numEmpleados = 0;

        managers = new Manager[INICIAL];
        numManagers = 0;
    }

    // --- CRUD CLIENTE ---

    private boolean existeClienteId(int id) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getClienteId() == id) return true;
        }
        return false;
    }

    public void agregarCliente(Cliente c) {
        if (existeClienteId(c.getClienteId())) {
            System.out.println("Error: Cliente con ID " + c.getClienteId() + " ya existe.");
            return;
        }
        if (numClientes == clientes.length) {
            // Redimensionar
            Cliente[] aux = new Cliente[numClientes + INICIAL];
            System.arraycopy(clientes, 0, aux, 0, numClientes);
            clientes = aux;
        }
        clientes[numClientes++] = c;
        System.out.println("Cliente agregado: " + c);
    }

    public void editarCliente(int indice, Cliente c) {
        if (indice < 0 || indice >= numClientes) {
            System.out.println("Error: índice inválido para editar cliente");
            return;
        }
        if (c.getClienteId() != clientes[indice].getClienteId() && existeClienteId(c.getClienteId())) {
            System.out.println("Error: ID duplicado");
            return;
        }
        clientes[indice] = c;
        System.out.println("Cliente actualizado: " + c);
    }

    public void eliminarCliente(int indice) {
        if (indice < 0 || indice >= numClientes) {
            System.out.println("Error: índice inválido para eliminar cliente");
            return;
        }
        for (int i = indice; i < numClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        clientes[numClientes - 1] = null;
        numClientes--;
        System.out.println("Cliente eliminado");
    }

    public String listarClientes() {
        if (numClientes == 0) return "No hay clientes";
        StringBuilder sb = new StringBuilder("Clientes:\n");
        for (int i = 0; i < numClientes; i++) {
            sb.append("[").append(i).append("] ").append(clientes[i]).append("\n");
        }
        return sb.toString();
    }


    // --- CRUD EMPLEADO ---

    private boolean existeEmpleadoId(int id) {
        for (int i = 0; i < numEmpleados; i++) {
            if (empleados[i].getClienteId() == id) return true;
        }
        return false;
    }

    public void agregarEmpleado(Empleado e) {
        if (existeEmpleadoId(e.getClienteId())) {
            System.out.println("Error: Empleado con ID " + e.getClienteId() + " ya existe.");
            return;
        }
        if (numEmpleados == empleados.length) {
            Empleado[] aux = new Empleado[numEmpleados + INICIAL];
            System.arraycopy(empleados, 0, aux, 0, numEmpleados);
            empleados = aux;
        }
        empleados[numEmpleados++] = e;
        System.out.println("Empleado agregado: " + e);
    }

    public void editarEmpleado(int indice, Empleado e) {
        if (indice < 0 || indice >= numEmpleados) {
            System.out.println("Error: índice inválido para editar empleado");
            return;
        }
        if (e.getClienteId() != empleados[indice].getClienteId() && existeEmpleadoId(e.getClienteId())) {
            System.out.println("Error: ID duplicado");
            return;
        }
        empleados[indice] = e;
        System.out.println("Empleado actualizado: " + e);
    }

    public void eliminarEmpleado(int indice) {
        if (indice < 0 || indice >= numEmpleados) {
            System.out.println("Error: índice inválido para eliminar empleado");
            return;
        }
        for (int i = indice; i < numEmpleados - 1; i++) {
            empleados[i] = empleados[i + 1];
        }
        empleados[numEmpleados - 1] = null;
        numEmpleados--;
        System.out.println("Empleado eliminado");
    }

    public String listarEmpleados() {
        if (numEmpleados == 0) return "No hay empleados";
        StringBuilder sb = new StringBuilder("Empleados:\n");
        for (int i = 0; i < numEmpleados; i++) {
            sb.append("[").append(i).append("] ").append(empleados[i]).append("\n");
        }
        return sb.toString();
    }


    // --- CRUD MANAGER ---

    private boolean existeManagerId(int id) {
        for (int i = 0; i < numManagers; i++) {
            if (managers[i].getClienteId() == id) return true;
        }
        return false;
    }

    public void agregarManager(Manager m) {
        if (existeManagerId(m.getClienteId())) {
            System.out.println("Error: Manager con ID " + m.getClienteId() + " ya existe.");
            return;
        }
        if (numManagers == managers.length) {
            Manager[] aux = new Manager[numManagers + INICIAL];
            System.arraycopy(managers, 0, aux, 0, numManagers);
            managers = aux;
        }
        managers[numManagers++] = m;
        System.out.println("Manager agregado: " + m);
    }

    public void editarManager(int indice, Manager m) {
        if (indice < 0 || indice >= numManagers) {
            System.out.println("Error: índice inválido para editar manager");
            return;
        }
        if (m.getClienteId() != managers[indice].getClienteId() && existeManagerId(m.getClienteId())) {
            System.out.println("Error: ID duplicado");
            return;
        }
        managers[indice] = m;
        System.out.println("Manager actualizado: " + m);
    }

    public void eliminarManager(int indice) {
        if (indice < 0 || indice >= numManagers) {
            System.out.println("Error: índice inválido para eliminar manager");
            return;
        }
        for (int i = indice; i < numManagers - 1; i++) {
            managers[i] = managers[i + 1];
        }
        managers[numManagers - 1] = null;
        numManagers--;
        System.out.println("Manager eliminado");
    }

    public String listarManagers() {
        if (numManagers == 0) return "No hay managers";
        StringBuilder sb = new StringBuilder("Managers:\n");
        for (int i = 0; i < numManagers; i++) {
            sb.append("[").append(i).append("] ").append(managers[i]).append("\n");
        }
        return sb.toString();
    }

}




