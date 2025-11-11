import Jogador.Jogador;

public class Participacao {
    private Jogador jogador;
    private Partida partida;
    private int danoTotal;
    private boolean venceu;


    public Participacao(Jogador jogador, Partida partida, int danoTotal, boolean venceu) {
        this.jogador = jogador;
        this.partida = partida;
        this.danoTotal = danoTotal;
        this.venceu = venceu;
    }
}


