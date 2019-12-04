package Ejercicio5.src;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mensajero {
    protected void enviaArchivo(SocketChannel socketChannel, String nombreArchivo) throws IOException {
        //Nombre del archivo a enviar.
        String filePath = nombreArchivo;

        //Dirección de entrada que lee el archivo.
        Path path = Paths.get(filePath);
        FileChannel canalEntrada = FileChannel.open(path);

        //Guardando el archivo en un buffer el cual escribimos en el socket channel.
        //Los SocketChannel tienen un método write() que admiten un ByteBuffer con los bytes
        // que queremos enviar por el canal. Debemos por tanto crear un ByteBuffer y rellenarlo con los datos a enviar.
        //Creamos el ByteBuffer con una llamada a ByteBuffer.allocate(bytes);que nos dará un ByteBuffer con capacidad para 1024 bytes
        // en nuestro caso.
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //lee bytes del canal y los va metiendo en el buffer, empezando y
        // haciendo avanzar position y hasta que llega a limit o deja de tener bytes disponibles.
        while (canalEntrada.read(buffer) > 0) {
            buffer.flip();// Pone limit en la actual position y position a cero.
            socketChannel.write(buffer);
            //Una vez escrito, el bucle de escritura termina y tenemos que limpiar el buffer,
            // para que quede listo para la siguiente línea de texto. buffer.clear pone position a cero y
            // limit a la capacidad del buffer, es decir 1024. Nos deja el buffer como si acabáramos de crearlo.
            buffer.clear();
        }
        socketChannel.close();
    }

    protected SocketChannel inicializaMensajero() throws IOException {
        //Abrir un socket cliente que se conecte con un servidor
        SocketChannel socketChannel = SocketChannel.open();
        //Indicamos la IP a la que queremos conectarnos. Esta vez como nuestro programa de pruebas corre en el mismo
        // PC que el servidor y el servidor escucha en todas las IP pusimos localhost.
        //
        //También debemos poner el puerto en el que escucha el servidor, 1250 en nuestro ejemplo.
        SocketAddress socketAddr = new InetSocketAddress("localhost", 1250);
        socketChannel.connect(socketAddr);
        return socketChannel;
    }
}
