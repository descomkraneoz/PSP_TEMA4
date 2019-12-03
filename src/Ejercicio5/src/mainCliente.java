package Ejercicio5.src;

import java.io.IOException;
import java.util.Scanner;

public class mainCliente {
    public static void main(String[] args) throws IOException {
        Cliente c = new Cliente("localhost", 1234, "ArchivoRecibido");
        c.iniciaComunicacion();
        c.recibeMensaje();
        Scanner sc = new Scanner(System.in);
        c.enviaMensaje(sc.nextLine());
        c.recibeArchivo();
    }
}
