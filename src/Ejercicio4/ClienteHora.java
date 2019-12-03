package Ejercicio4;

import Ejercicio2.Cliente;

public class ClienteHora {
    Cliente[] arrayClientes;

    ClienteHora() {
        arrayClientes = new Cliente[]{
                new Cliente("localhost", 9999),
                new Cliente("localhost", 9999),
                new Cliente("localhost", 9999),
        };
    }


    public void ClienteHoraIniciar() {
        //Cliente cliente = new Cliente("localhost", 9999);

        for (int i = 0; i < arrayClientes.length; i++) {
            //iniciar clienteHora
            arrayClientes[i].iniciaCliente();
            //ver si recibe mensaje
            arrayClientes[i].recibeMensaje();
        }
    }
}
