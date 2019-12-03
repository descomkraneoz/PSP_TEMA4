package Ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServicioEcho extends Thread {

    private Socket cliente;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServicioEcho(Socket cliente) {
        this.cliente = cliente;
    }

    private void cierraServicio() {
        try {
            dis.close();
            dos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo run de los hilos, iniciamos el cliente, escribimos y leemos el mensaje, salimos con Bye

    public void run() {
        String mensaje;
        try {
            dis = new DataInputStream(cliente.getInputStream());
            dos = new DataOutputStream(cliente.getOutputStream());
            while (true) {
                mensaje = dis.readUTF();
                System.out.println(mensaje);
                dos.writeUTF(mensaje);
                if (mensaje.equals("Bye")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
