package Ejercicio5.src;

import java.io.IOException;

/**
 * 5.- Construir un programa en Java que actúe como servidor de archivos de texto. Los
 * clientes al conectarse reciben una lista con los archivos de texto disponibles para su
 * descarga. El cliente selecciona un archivo y el servidor lo transfiere al cliente. Al
 * terminar la transferencia, el servidor preguntará si quiere algún archivo más o si quiere
 * desconectarse.
 */

public class mainServidor {
    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor(1234);
        servidor.iniciarServidor();
        servidor.aceptarClientesEcho();
    }
}
