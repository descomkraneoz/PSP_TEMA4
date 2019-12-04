package Ejercicio4;


import java.util.Scanner;

public class ClienteEcho {

    public static void main(String[] args) {
        Cliente c = new Cliente("localhost", 9998);
        Cliente e = new Cliente("localhost", 9998);
        c.iniciaCliente();
        e.iniciaCliente();
        Scanner sc = new Scanner(System.in);
        String mensaje;
        while (true) {
            mensaje = sc.nextLine();
            c.enviaMensaje(mensaje);
            c.recibeMensaje();
            e.enviaMensaje(mensaje);
            e.recibeMensaje();
            if (mensaje.equals("Bye")) break;
        }
    }
}
