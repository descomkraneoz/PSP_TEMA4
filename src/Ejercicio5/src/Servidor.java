package Ejercicio5.src;

import Ejercicio2.ServicioEcho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Servidor {
    private Socket cliente;
    private ServerSocket servidorEcho;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int puertoEcho;
    private long retraso = 1000;


    //constructor de servidor

    public Servidor(int puertoEcho) {
        this.puertoEcho = puertoEcho;
    }

    //iniciar servidor

    void iniciarServidor() {
        try {
            servidorEcho = new ServerSocket(this.puertoEcho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void aceptarClientesEcho() {
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
            }, retraso, retraso);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void cierraServidor() {
        try {
            cliente.close();
            servidorEcho.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
