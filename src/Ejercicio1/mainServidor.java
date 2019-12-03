package Ejercicio1;

public class mainServidor {
    public static void main(String[] args) {
        Servidor servidor = new Servidor(9999);
        servidor.iniciaServidor();
        servidor.aceptarCliente();
    }
}
