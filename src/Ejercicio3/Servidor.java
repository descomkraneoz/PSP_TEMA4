package Ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Servidor {
    private Socket cliente;
    private ServerSocket servidorEcho;
    private int puertoEcho;
    private long retraso = 1000;
    int contador = 0;

    public Servidor (int puertoEcho){
        this.puertoEcho = puertoEcho;
    }

    //Iniciar servidor

    public void iniciaServidor(){
        try {
            servidorEcho = new ServerSocket(this.puertoEcho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Aceptar clientes, sobreescribimos aqui el run del hilo ServicioEcho

    public void aceptaClientesEcho(){
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        cliente = servidorEcho.accept();
                        ServicioEcho se = new ServicioEcho(cliente);
                        se.start();
                        cliente = null;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            },retraso,retraso);
        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    //Cerramos el server

    private void cierraServidor() {
        try {
            cliente.close();
            servidorEcho.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
