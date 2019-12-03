package Ejercicio1;

import java.util.Scanner;

public class mainCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente("localhost",9999);
        Cliente c = new Cliente("localhost", 9999); // No debe funcionar porque no es recurrente el servidor
        cliente.iniciaCliente();
        c.iniciaCliente(); // No debe funcionar porque no es recurrente el servidor
        String mensaje;
        while (true){
            mensaje = sc.nextLine();
            cliente.enviaMensaje(mensaje + " soy el cliente 1");
            c.enviaMensaje(mensaje + " soy el cliente 2"); // No debe funcionar porque no es recurrente el servidor
            cliente.recibeMensaje();
            if (mensaje.equals("Bye")) break;
        }
        cliente.cerrarCliente();
    }
}
