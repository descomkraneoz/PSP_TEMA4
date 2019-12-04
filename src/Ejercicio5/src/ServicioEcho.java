package Ejercicio5.src;

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

    public void run() {
        String listaArchivos = " 1)Ingredientes \n 2)Smoothie_Bowl.jpg \n 3)Elaboracion";
        try {
            dis = new DataInputStream(cliente.getInputStream());
            dos = new DataOutputStream(cliente.getOutputStream());
            dos.writeUTF("Elige un archivo para descargar (Por número)" + "\n" + listaArchivos);
            ServicioDescarga sd;
            switch (dis.readUTF()) {
                case "1":
                    System.out.println("ha elegido el 1");
                    sd = new ServicioDescarga("Ingredientes");
                    sd.start();
                    break;
                case "2":
                    System.out.println("ha elegido el 2");
                    sd = new ServicioDescarga("Smoothie_Bowl.jpg");
                    sd.start();
                    break;
                case "3":
                    System.out.println("ha elegido el 3");
                    sd = new ServicioDescarga("Elaboracion");
                    sd.start();
                    break;
                default:
                    System.out.println("ha elegido otra cosa");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
