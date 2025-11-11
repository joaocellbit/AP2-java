import Jogador.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private int turno = 0;
    private List<Jogador> jogadores = new ArrayList<>();


    public Partida( Jogador jogador1, Jogador jogador2) {

        jogadores.add(jogador1);
        jogadores.add(jogador2);
    }

    public int getTurno() {
        return turno;
    }
    public void passarTurno() {
        this.turno += 1;
    }
}
