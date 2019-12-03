package Ejercicio2;

import java.util.Scanner;

public class ClienteEcho {
    public static void main(String[] args) {
        Cliente c = new Cliente("localhost",9998);
        c.iniciaCliente();
        //escribir mensaje
        Scanner sc = new Scanner(System.in);
        String mensaje;
        while (true){
            mensaje = sc.nextLine();
            //enviar mensaje
            c.enviaMensaje(mensaje);
            //recibir mensaje
            c.recibeMensaje();
            //salir
            if (mensaje.equals("Bye")){
                break;
            }
        }
    }
}
