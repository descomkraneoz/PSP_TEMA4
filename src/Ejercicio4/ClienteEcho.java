package Ejercicio4;

import Ejercicio2.Cliente;

import java.util.Scanner;

public class ClienteEcho {

    Cliente[] arrayClientes;


    ClienteEcho() {
        arrayClientes = new Cliente[]{
                new Cliente("localhost", 9998),
                new Cliente("localhost", 9998),
                new Cliente("localhost", 9998),};
    }

    public void ClienteEchoIniciar() {
        //Este cliente mandara un mensaje al servidor y luego recibira una respuesta de este que mostrara en pantalla
        //Cliente c = new Cliente("localhost", 9998);

        for (int i = 0; i < arrayClientes.length; i++) {
            arrayClientes[i].iniciaCliente();
            //escribir mensaje
            Scanner sc = new Scanner(System.in);
            String mensaje;
            while (true) {
                mensaje = sc.nextLine();
                //enviar mensaje
                arrayClientes[i].enviaMensaje(mensaje);
                //recibir mensaje
                arrayClientes[i].recibeMensaje();
                //salir
                if (mensaje.equals("Bye")) {
                    break;
                }
            }

        }

    }
}
