package Ejercicio3;

import Ejercicio2.Cliente;

import java.util.Scanner;

public class ClienteEcho {
    public static void main(String[] args) {
        Cliente c = new Cliente("localhost",9999);
        Cliente l = new Cliente("localhost", 9999);
        Cliente v = new Cliente("localhost", 9999);
        c.iniciaCliente();
        l.iniciaCliente();
        v.iniciaCliente();
        Scanner sc = new Scanner(System.in);
        String mensaje;
        while (true){
            mensaje = sc.nextLine();
            c.enviaMensaje(mensaje + " soy el cliente 1");
            c.recibeMensaje();
            l.enviaMensaje(mensaje + " soy el cliente 2");
            l.recibeMensaje();
            v.enviaMensaje(mensaje + " soy el cliente 3");
            v.recibeMensaje();
            if (mensaje.equals("Bye")) {
                break;
            }
        }
    }
}
