package Ejercicio2;

/**
 * 2.- Construir un servidor en Java que ofrezca dos servicios. Por un lado, actuará como
 * un servidor echo para clientes que soliciten este servicio en el puerto 9998; por otro
 * lado, devolverá la hora del sistema a los clientes que soliciten la hora a través del puerto
 * 9999.
 */

public class mainServidor {
    public static void main(String[] args) {
        Servidor server = new Servidor(9998,9999);
        server.iniciarServidor();
        server.aceptarClientesHora();
        server.aceptarClientesEcho();
    }
}