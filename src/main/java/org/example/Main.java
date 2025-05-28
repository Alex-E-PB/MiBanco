package org.example;

import org.example.dominio.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Empleados");
            System.out.println("3. Gestionar Managers");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuEmpleados();
                case 3 -> menuManagers();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ---------- CLIENTES ----------
    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarCliente();
                case 2 -> editarCliente();
                case 3 -> eliminarCliente();
                case 4 -> System.out.println(banco.listarClientes());
                case 0 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void agregarCliente() {
        Cliente c = new Cliente();

        // Validar ID positivo
        int id;
        do {
            System.out.print("ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("ID: ");
                scanner.next(); // descarta dato incorrecto
            }
            id = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (id <= 0) {
                System.out.println("Error: el ID debe ser positivo.");
            }
        } while (id <= 0);
        c.setClienteId(id);

        // Validar nombre solo letras
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        c.setNombre(nombre);

        // Validar apellido solo letras
        String apellido;
        do {
            System.out.print("Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        c.setApellido(apellido);

        // Validar correo formato básico
        String correo;
        do {
            System.out.print("Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        c.setCorreo(correo);

        // Fecha asignada automáticamente a fecha actual
        c.setFecha(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        c.setGenero(genero);


        // Finalmente agregar el cliente al banco
        banco.agregarCliente(c);
    }



    private static void editarCliente() {

        System.out.println(banco.listarClientes());
        int index;
        do {
            System.out.print("Índice del cliente a editar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next(); // descarta dato incorrecto
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice debe ser positivo.");
            }
        } while (index < 0);

        Cliente c = new Cliente();

        // Validar nuevo ID
        int id;
        do {
            System.out.print("Nuevo ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Nuevo ID: ");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (id <= 0) {
                System.out.println("El ID debe ser positivo.");
            }
        } while (id <= 0);
        c.setClienteId(id);

        // Validar nuevo nombre
        String nombre;
        do {
            System.out.print("Nuevo Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        c.setNombre(nombre);

        // Validar nuevo apellido
        String apellido;
        do {
            System.out.print("Nuevo Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        c.setApellido(apellido);

        // Validar nuevo correo
        String correo;
        do {
            System.out.print("Nuevo Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente de nuevo.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        c.setCorreo(correo);

        // Fecha actual del sistema
        c.setFecha(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Nuevo Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        c.setGenero(genero);

        banco.editarCliente(index, c);
    }


    private static void eliminarCliente() {

        int index;
        do {
            System.out.print("Índice del cliente a eliminar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next(); // descarta dato incorrecto
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice debe ser positivo.");
            }
        } while (index < 0);
        banco.eliminarCliente(index);
    }

    // ---------- EMPLEADOS ----------
    private static void menuEmpleados() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Editar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Listar Empleados");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarEmpleado();
                case 2 -> editarEmpleado();
                case 3 -> eliminarEmpleado();
                case 4 -> System.out.println(banco.listarEmpleados());
                case 0 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void agregarEmpleado() {
        Empleado e = new Empleado();

        // Validar ID positivo
        int id;
        do {
            System.out.print("ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("ID: ");
                scanner.next(); // descarta dato incorrecto
            }
            id = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (id <= 0) {
                System.out.println("Error: el ID debe ser positivo.");
            }
        } while (id <= 0);
        e.setEmpleadoId(id);

        // Validar nombre solo letras
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        e.setNombre(nombre);

        // Validar apellido solo letras
        String apellido;
        do {
            System.out.print("Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        e.setApellido(apellido);

        // Validar correo formato básico
        String correo;
        do {
            System.out.print("Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        e.setCorreo(correo);

        // Fecha actual
        e.setFechaContratacion(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        e.setGenero(genero);

        // Agregar empleado al banco
        banco.agregarEmpleado(e);
    }


    private static void editarEmpleado() {
        // Validar índice mayor o igual a 0
        int index;
        do {
            System.out.print("Índice del empleado a editar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next();
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice no puede ser negativo.");
            }
        } while (index < 0);

        Empleado e = new Empleado();

        // Validar ID
        int id;
        do {
            System.out.print("Nuevo ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("ID: ");
                scanner.next(); // descarta dato incorrecto
            }
            id = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (id <= 0) {
                System.out.println("Error: el ID debe ser positivo.");
            }
        } while (id <= 0);
        e.setEmpleadoId(id);

        // Validar nombre
        String nombre;
        do {
            System.out.print("Nuevo Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        e.setNombre(nombre);

        // Validar apellido
        String apellido;
        do {
            System.out.print("Nuevo Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        e.setApellido(apellido);

        // Validar correo
        String correo;
        do {
            System.out.print("Nuevo Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        e.setCorreo(correo);

        // Asignar fecha actual
        e.setFechaContratacion(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Nuevo Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        e.setGenero(genero);

        // Editar empleado
        banco.editarEmpleado(index, e);
    }

    private static void eliminarEmpleado() {
        int index;
        do {
            System.out.print("Índice del empleado a eliminar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next(); // descarta dato incorrecto
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice debe ser positivo.");
            }
        } while (index < 0);
        banco.eliminarEmpleado(index);
    }

    // ---------- MANAGERS ----------
    private static void menuManagers() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE MANAGERS ---");
            System.out.println("1. Agregar Manager");
            System.out.println("2. Editar Manager");
            System.out.println("3. Eliminar Manager");
            System.out.println("4. Listar Managers");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarManager();
                case 2 -> editarManager();
                case 3 -> eliminarManager();
                case 4 -> System.out.println(banco.listarManagers());
                case 0 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void agregarManager() {
        Manager m = new Manager();

        // Validar ID
        int id;
        do {
            System.out.print("ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("ID: ");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (id <= 0) {
                System.out.println("Error: el ID debe ser mayor que 0.");
            }
        } while (id <= 0);
        m.setManagerId(id);

        // Validar nombre
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        m.setNombre(nombre);

        // Validar apellido
        String apellido;
        do {
            System.out.print("Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        m.setApellido(apellido);

        // Validar correo
        String correo;
        do {
            System.out.print("Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        m.setCorreo(correo);

        // Fecha actual
        m.setFechaContratacion(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        m.setGenero(genero);

        banco.agregarManager(m);
    }

    private static void editarManager() {
        // Validar índice
        int index;
        do {
            System.out.print("Índice del manager a editar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next();
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice debe ser mayor o igual a 0.");
            }
        } while (index < 0);

        Manager m = new Manager();

        // Validar ID
        int id;
        do {
            System.out.print("Nuevo ID (número positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Nuevo ID: ");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (id <= 0) {
                System.out.println("Error: el ID debe ser mayor que 0.");
            }
        } while (id <= 0);
        m.setManagerId(id);

        // Validar nombre
        String nombre;
        do {
            System.out.print("Nuevo Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Nombre inválido. Solo se permiten letras.");
            }
        } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        m.setNombre(nombre);

        // Validar apellido
        String apellido;
        do {
            System.out.print("Nuevo Apellido: ");
            apellido = scanner.nextLine();
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Apellido inválido. Solo se permiten letras.");
            }
        } while (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"));
        m.setApellido(apellido);

        // Validar correo
        String correo;
        do {
            System.out.print("Nuevo Correo: ");
            correo = scanner.nextLine();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        m.setCorreo(correo);

        // Fecha de edición = ahora
        m.setFechaContratacion(new Date());

        // Validar género por letra: M/F
        char generoChar;
        Genero genero = null;
        do {
            System.out.print("Nuevo Género (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                generoChar = input.charAt(0);
                if (generoChar == 'M') {
                    genero = Genero.MASCULINO;
                } else if (generoChar == 'F') {
                    genero = Genero.FEMENINO;
                } else {
                    System.out.println("Género inválido. Ingrese solo M o F.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo una letra: M o F.");
            }
        } while (genero == null);

        m.setGenero(genero);

        banco.editarManager(index, m);
    }

    private static void eliminarManager() {
        int index;
        do {
            System.out.print("Índice del manager a eliminar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                System.out.print("Índice: ");
                scanner.next(); // descarta dato incorrecto
            }
            index = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (index < 0) {
                System.out.println("Error: el índice debe ser positivo.");
            }
        } while (index < 0);
        banco.eliminarManager(index);
    }
}