package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    private Socket socketCliente;
    private String host;
    private int port;
    private DataInputStream dis;
    private DataOutputStream dos;

    // Crear constructor cliente

    public Cliente(String host, int port){
        this.host=host;
        this.port=port;
    }

    //Iniciar el cliente

    public void iniciaCliente(){
        try{
            socketCliente = new Socket(this.host,this.port);
            dis = new DataInputStream(socketCliente.getInputStream());
            dos = new DataOutputStream(socketCliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Acción de enviar un mensaje

    public void enviaMensaje(String mensaje){
        try {
            dos.writeUTF(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Acción de recibir un mensaje

    public void recibeMensaje(){
        try {
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Cerrar los canales de entrada, salida y el socket cliente

    public void cerrarCliente() {
        try {
            dis.close();
            dos.close();
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}