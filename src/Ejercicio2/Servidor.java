package Ejercicio2;

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
    private ServerSocket servidorHora;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int puertoEcho;
    private int puertoHora;
    private long retraso = 1000;
    int contador = 0;

    //constructor de servidor

    public Servidor (int puertoEcho, int puertoHora){
        this.puertoEcho = puertoEcho;
        this.puertoHora = puertoHora;
    }

    //iniciar servidor

    public void iniciarServidor(){
        try {
            servidorEcho = new ServerSocket(this.puertoEcho);
            servidorHora = new ServerSocket(this.puertoHora);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Accion aceptar cliente hora

    public void aceptarClientesHora(){
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        cliente = servidorHora.accept();
                        ServicioHora sh = new ServicioHora(cliente);
                        sh.start();
                        cliente = null;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            },retraso,retraso);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    //Accion aceptar clientes echo

    public void aceptarClientesEcho(){
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

    //Cerrar servidor

    private void cierraServidor() {
        try {
            dis.close();
            dos.close();
            cliente.close();
            servidorEcho.close();
            servidorHora.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
