import Jogador.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private int rodada = 0;
    private List<Jogador> jogadores = new ArrayList<>();
    private int turno;


    public Partida( Jogador jogador1, Jogador jogador2) {

        jogadores.add(jogador1);
        jogadores.add(jogador2);
    }

    public int getRodada() {
        return rodada;
    }
    public void passarRodada() {
        this.rodada += 1;
        this.turno = 1;
        for (Jogador jogador : jogadores) {
            jogador.atualizarZonaFimDeTurno();
        }
        System.out.println("Rodada: " + this.rodada);
    }
    public int getTurno() {
        return turno;
    }
    public void passarTurno() {
        this.turno += 1;
    }
}
