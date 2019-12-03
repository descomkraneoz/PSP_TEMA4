package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private Socket cliente;
    private ServerSocket servidor;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int port;


    // Crear servidor

    public Servidor(int port) {
        this.port=port;
    }

    //iniciar servidor

    public void iniciaServidor(){
        try {
            servidor = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Aceptar un cliente

    public void aceptarCliente(){
        try {
            cliente =servidor.accept();
            dis = new DataInputStream(cliente.getInputStream());
            dos = new DataOutputStream(cliente.getOutputStream());
            leeMensajesYDevuelveHastaAdios();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Accion de leer mensajes y devolverlos hasta pulsar adios

    private void leeMensajesYDevuelveHastaAdios() {
        String mensaje;
        try{
            while (true){
                mensaje = dis.readUTF();
                System.out.println(mensaje);
                dos.writeUTF(mensaje);
                if (mensaje.equals("Bye")) break;
            }
            cerrarServidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Cerrar los canales de entrada, salida, el socket cliente y el serversocket

    public void cerrarServidor(){
        try {
            dis.close();
            dos.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
