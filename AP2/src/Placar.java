import Jogador.Jogador;

import java.util.HashMap;
import java.util.Map;

public class Placar {
    private Map<Jogador, Integer> pontos = new HashMap<>();


    private Placar(Jogador jogador1, Jogador jogador2){
        pontos.put(jogador1, 0);
        pontos.put(jogador2, 0);
    }

    private void addpontos(Jogador jogador){
        pontos.put(jogador, pontos.get(jogador) + 1);
    }
    private void removepontos(Jogador jogador){
        pontos.put(jogador, pontos.get(jogador) - 1);
    }
    private void verPontos(Jogador jogador){
        System.out.println("Jogador " + jogador.getNome() + " tem: " + pontos.get(jogador));
    }
}
