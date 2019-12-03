package Ejercicio4;

import Ejercicio2.Cliente;

public class ClienteHora {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 9999);
        //iniciar clienteHora
        cliente.iniciaCliente();
        //ver si recibe mensaje
        cliente.recibeMensaje();
    }
}
