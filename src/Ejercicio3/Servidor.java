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
    private long retraso = 1000; //milisegundos
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

    /**
     * Acerca de porque uso el timer.scheduleAtFixedRate cada 1000ms,
     * es para que me de avisos relativos al primer aviso,  si el ordenador está muy ocupado
     * y da avisos cada 1.1 segundos en vez de cada segundo, el primer aviso se recibirá en el
     * segundo 1.1, el segundo en el 2.1, el tercero en el 3.1, etc. El retraso no se va acumulando.
     */

    public void aceptaClientesEcho(){
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() { //codigo a ejecutar
                    try {
                        cliente = servidorEcho.accept();
                        ServicioEcho se = new ServicioEcho(cliente);
                        se.start();
                        cliente = null;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }, retraso, retraso); // Dentro de 1000 milisegundos avísame cada 1000 milisegundos
        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    //Cerramos el server

    public void cierraServidor() {
        try {
            cliente.close();
            servidorEcho.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
