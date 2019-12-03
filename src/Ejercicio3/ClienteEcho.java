package Ejercicio3;

import Ejercicio2.Cliente;

import java.util.Scanner;

public class ClienteEcho {
    public static void main(String[] args) {
        Cliente c = new Cliente("localhost",9999);
        c.iniciaCliente();
        Scanner sc = new Scanner(System.in);
        String mensaje;
        while (true){
            mensaje = sc.nextLine();
            c.enviaMensaje(mensaje);
            c.recibeMensaje();
            if (mensaje.equals("Bye")) {
                break;
            }
        }
    }
}
