package Ejercicio3;

public class mainServidor {
    public static void main(String[] args) {
        Servidor server = new Servidor(9999);
        server.iniciaServidor();
        server.aceptaClientesEcho();
    }
}