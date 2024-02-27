import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor aguardando conexões...");
                
            Socket jogador1 = serverSocket.accept();
            System.out.println("Jogador 1 conectado.");

            Socket jogador2 = serverSocket.accept();
            System.out.println("Jogador 2 conectado.");

            JogoDaVelha jogo = new JogoDaVelha(jogador1, jogador2);
            jogo.iniciarJogo();

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}