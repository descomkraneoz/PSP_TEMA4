package Ejercicio4;

/**
 * 4.- Modificar el programa del ejercicio 2 para que sea concurrente, es decir, pueda dar
 * servicio a varios clientes a la vez.
 */

public class mainServidor {
    public static void main(String[] args) {
        Servidor server = new Servidor(9998, 9999);
        server.iniciarServidor();
        server.aceptarClientesHora();
        server.aceptarClientesEcho();
    }
}
