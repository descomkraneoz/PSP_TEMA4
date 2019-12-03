package Ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioHora extends Thread {
    private Socket cliente;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServicioHora(Socket cliente) {
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
        try {
            Date hoy = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            dos = new DataOutputStream(cliente.getOutputStream());
            dos.writeUTF(sdf.format(hoy));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}