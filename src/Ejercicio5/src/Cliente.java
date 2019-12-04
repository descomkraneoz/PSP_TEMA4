package Ejercicio5.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Cliente {

    private String ip;
    private int puerto;
    private Socket socketCliente;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String archivoDestino;

    public Cliente(String ip, int puerto, String archivoDestino) {
        this.ip = ip;
        this.puerto = puerto;
        this.archivoDestino = archivoDestino;
    }

    public void iniciarCliente() {
        try {
            socketCliente = new Socket(this.ip, this.puerto);
            dis = new DataInputStream(socketCliente.getInputStream());
            dos = new DataOutputStream(socketCliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviaMensaje(String mensaje) {
        try {
            dos.writeUTF(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recibeMensaje() {
        try {
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recibeArchivo() {
        try {
            Receptor recibe = new Receptor();
            SocketChannel socketChannel = recibe.inicializaServerSocketChannel();
            recibe.leeDeSocketChannel(socketChannel, archivoDestino);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void cierraComunicacion() {
        try {
            dis.close();
            dos.close();
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}