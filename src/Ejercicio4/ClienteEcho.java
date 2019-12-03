package Ejercicio4;

import Ejercicio2.Cliente;

import java.util.Scanner;

public class ClienteEcho {
    public static void main(String[] args) {
        //Este cliente mandara un mensaje al servidor y luego recibira una respuesta de este que mostrara en pantalla
        Cliente c = new Cliente("localhost", 9998);
        //iniciar el cliente
        c.iniciaCliente();
        //escribir mensaje
        Scanner sc = new Scanner(System.in);
        String mensaje;
        while (true) {
            mensaje = sc.nextLine();
            //enviar mensaje
            c.enviaMensaje(mensaje);
            //recibir mensaje
            c.recibeMensaje();
            //salir
            if (mensaje.equals("Bye")) {
                break;
            }
        }
    }
}
