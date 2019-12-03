package Ejercicio5.src;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class Receptor {

    protected void leeDeSocketChannel(SocketChannel socketChannel, String nombreArchivo) throws IOException {
        //Archivo que se creará del archivo recibido
        String filePath = nombreArchivo + "r";

        Path path = Paths.get(filePath);
        //Crea un conjunto de enumeraciones que inicialmente contiene el elemento especificado.
        //StandardOpenOption.CREATE, crea un nuevo file si no existe antes
        // StandardOpenOption.TRUNCATE_EXISTING, Si el archivo ya existe y está abierto para acceso de ESCRITURA, su longitud se trunca a 0.
        // StandardOpenOption.WRITE, Abre para escribir
        FileChannel fileChannel = FileChannel.open(path,
                EnumSet.of(StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.WRITE)
        );

        //Buffer que usamos para escribir el archivo recibido.
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) > 0) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        fileChannel.close();
        System.out.println("Archivo recibido.");
        socketChannel.close();
    }

    protected SocketChannel inicializaServerSocketChannel() throws IOException {
        ServerSocketChannel serverSocket = null;
        SocketChannel client = null;
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(1250));
        client = serverSocket.accept();

        System.out.println("Conexión establecida a: " + client.getRemoteAddress());
        return client;
    }
}