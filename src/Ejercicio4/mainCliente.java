package Ejercicio4;

public class mainCliente {
    public static void main(String[] args) {

        System.out.println("Empiezan los clientes");

        ClienteEcho ce1 = new ClienteEcho();
        ClienteEcho ce2 = new ClienteEcho();
        ClienteEcho ce3 = new ClienteEcho();
        ClienteHora ch = new ClienteHora();

        ce1.ClienteEchoIniciar();
        ce2.ClienteEchoIniciar();
        ce3.ClienteEchoIniciar();

        ch.ClienteHoraIniciar();

    }
}
