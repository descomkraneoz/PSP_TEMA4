package Ejercicio1;

import java.util.Scanner;

public class mainCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente("localhost",9999);
        cliente.iniciaCliente();
        String mensaje;
        while (true){
            mensaje = sc.nextLine();
            cliente.enviaMensaje(mensaje);
            cliente.recibeMensaje();
            if (mensaje.equals("Bye")) break;
        }
        cliente.cerrarCliente();
    }
}
