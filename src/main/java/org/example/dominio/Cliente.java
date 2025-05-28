package org.example.dominio;

import java.util.Date;

public class Cliente {
    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fecha;
    private Genero genero;

    public Cliente() {
        this.clienteId = 1;
        this.nombre = "sin nombre";
        this.apellido = "sin apellido";
        this.fecha = null;
        this.genero = Genero.MASCULINO;
    }

    public Cliente(Cliente nuevoCliente) {
        this.clienteId = nuevoCliente.clienteId;
        this.nombre = nuevoCliente.nombre;
        this.apellido = nuevoCliente.apellido;
        this.correo = nuevoCliente.correo;
        this.fecha = nuevoCliente.fecha;
        this.genero = nuevoCliente.genero;
    }

    public Cliente(int id, String nombre, String apellido) {
        setClienteId(id);
        setNombre(nombre);
        setApellido(apellido);
    }

    public Cliente(int clienteId, String nombre, String apellido, String correo, Date fecha) {
        setClienteId(clienteId);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setFecha(fecha);
    }

    public Cliente(int clienteId, String nombre, String apellido, String correo, Date fecha, Genero genero) {
        setClienteId(clienteId);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setFecha(fecha);
        setGenero(genero);
    }

    public Cliente(int clienteId, String correo) {
        setClienteId(clienteId);
        setCorreo(correo);
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        if (clienteId >= 0) {
            this.clienteId = clienteId;
        } else {
            System.out.println("Error: código inválido " + clienteId);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.nombre = nuevoNombre;
        } else {
            System.out.println("Error: nombre inválido");
            this.nombre = "sin nombre";
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String nuevoApellido) {
        if (nuevoApellido != null && !nuevoApellido.trim().isEmpty()) {
            this.apellido = nuevoApellido;
        } else {
            System.out.println("Error: apellido inválido");
            this.apellido = "sin apellido";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nuevoCorreo) {
        if (nuevoCorreo != null && nuevoCorreo.contains("@") && nuevoCorreo.contains(".")) {
            this.correo = nuevoCorreo;
        } else {
            System.out.println("Error: formato de correo inválido");
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date nuevaFecha) {
        this.fecha = nuevaFecha;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    // Cliente- cuenta
    private Cuenta[] cuentas = new Cuenta[5];
    private int numCuentas = 0;

    public void nuevoCuenta(double saldo) {
        if (numCuentas == cuentas.length) {
            Cuenta[] nuevaLista = new Cuenta[cuentas.length + 5];
            System.arraycopy(cuentas, 0, nuevaLista, 0, cuentas.length);
            cuentas = nuevaLista;
        }
        cuentas[numCuentas++] = new Cuenta(saldo);
        System.out.println("Cuenta creada con saldo: " + saldo);
    }

    public String consultarCuentas() {
        if (numCuentas == 0) return "No hay cuentas";
        StringBuilder sb = new StringBuilder("Cuentas del cliente:\n");
        for (int i = 0; i < numCuentas; i++) {
            sb.append("[").append(i).append("] ").append(cuentas[i]).append("\n");
        }
        return sb.toString();
    }

    public void editarCuenta(int pos, double saldo) {
        if (pos >= 0 && pos < numCuentas) {
            cuentas[pos].setBalance(saldo);
            System.out.println("Cuenta actualizada con nuevo saldo: " + saldo);
        } else {
            System.out.println("Índice inválido para editar cuenta");
        }
    }

    public void eliminarCuenta(int pos) {
        if (pos >= 0 && pos < numCuentas) {
            for (int i = pos; i < numCuentas - 1; i++) {
                cuentas[i] = cuentas[i + 1];
            }
            cuentas[numCuentas - 1] = null;
            numCuentas--;
            System.out.println("Cuenta eliminada");
        } else {
            System.out.println("Índice inválido para eliminar cuenta");
        }
    }

    public Cuenta buscarCuenta(int pos) {
        if (pos >= 0 && pos < numCuentas) {
            return cuentas[pos];
        }
        System.out.println("Índice inválido para buscar cuenta");
        return null;
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente [ID=").append(clienteId)
                .append(", Nombre=").append(nombre)
                .append(", Apellido=").append(apellido);

        if (correo != null && !correo.isEmpty()) {
            sb.append(", Correo=").append(correo);
        }

        if (fecha != null) {
            sb.append(", Fecha=").append(fecha);
        }

        if (genero != null) {
            sb.append(", Género=").append(genero.getNombre());
        }

        sb.append("]");
        return sb.toString();
    }
}



