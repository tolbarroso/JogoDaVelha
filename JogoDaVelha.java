import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JogoDaVelha {
    private Socket jogador1;
    private Socket jogador2;
    private char[][] tabuleiro;
    private PrintWriter outJogador1;
    private PrintWriter outJogador2;
    private BufferedReader inJogador1;
    private BufferedReader inJogador2;
    private boolean jogoEmAndamento;
    private char jogadorAtual;

    public JogoDaVelha(Socket jogador1, Socket jogador2) throws IOException {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = new char[3][3];
        this.outJogador1 = new PrintWriter(jogador1.getOutputStream(), true);
        this.outJogador2 = new PrintWriter(jogador2.getOutputStream(), true);
        this.inJogador1 = new BufferedReader(new InputStreamReader(jogador1.getInputStream()));
        this.inJogador2 = new BufferedReader(new InputStreamReader(jogador2.getInputStream()));
        this.jogoEmAndamento = true;
        this.jogadorAtual = 'X';
    }

    public void iniciarJogo() throws IOException {
        outJogador1.println("INICIAR:X");
        outJogador2.println("INICIAR:O");

        while (jogoEmAndamento) {
            jogada(inJogador1, outJogador2);
            if (verificarVencedor() || verificarEmpate()) break;

            jogada(inJogador2, outJogador1);
            if (verificarVencedor() || verificarEmpate()) break;
        }

        jogador1.close();
        jogador2.close();
    }

    private void jogada(BufferedReader in, PrintWriter out) throws IOException {
        out.println("SUA_VEZ");
        String jogada = in.readLine();
        int linha = Character.getNumericValue(jogada.charAt(0));
        int coluna = Character.getNumericValue(jogada.charAt(1));

        if (tabuleiro[linha][coluna] == '\0') {
            tabuleiro[linha][coluna] = jogadorAtual;
            out.println("VALIDA");
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        } else {
            out.println("INVALIDA");
        }
    }

    private boolean verificarVencedor() {
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0] == tabuleiro[linha][1] && 
                tabuleiro[linha][1] == tabuleiro[linha][2] && 
                tabuleiro[linha][0] != '\0') {
                jogoEmAndamento = false;
                return true;
            }
        }

        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna] == tabuleiro[1][coluna] && 
                tabuleiro[1][coluna] == tabuleiro[2][coluna] && 
                tabuleiro[0][coluna] != '\0') {
                jogoEmAndamento = false;
                return true;
            }
        }

        if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != '\0') ||
            (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != '\0')) {
            jogoEmAndamento = false;
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == '\0') {
                    return false;
                }
            }
        }

        jogoEmAndamento = false;
        return true;
    }
}