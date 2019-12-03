package Ejercicio3;

/**
 * 3.- Modificar el programa del ejercicio 1 para que pueda aceptar varios clientes a la vez,
 * es decir, hacer concurrente el servidor del ejercicio 1.
 */

public class mainServidor {
    public static void main(String[] args) {
        Servidor server = new Servidor(9999);
        server.iniciaServidor();
        server.aceptaClientesEcho();
        //server.cierraServidor(); //no lo cerramos en este ejemplo
    }
}