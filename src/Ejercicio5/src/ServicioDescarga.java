package Ejercicio5.src;

import java.nio.channels.SocketChannel;

public class ServicioDescarga extends Thread {
    private String nombreArchivo;

    public ServicioDescarga(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void run() {
        try {
            Mensajero seur = new Mensajero();
            SocketChannel socketChannel = seur.inicializaMensajero();
            seur.enviaArchivo(socketChannel, nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
