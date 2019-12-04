package Ejercicio4;



public class ClienteHora {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 9999);
        cliente.iniciaCliente();
        cliente.recibeMensaje();

        Cliente cl = new Cliente("localhost", 9999);
        cl.iniciaCliente();
        cl.recibeMensaje();
        Cliente te = new Cliente("localhost", 9999);
        te.iniciaCliente();
        te.recibeMensaje();
    }
}
