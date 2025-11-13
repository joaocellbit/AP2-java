import Jogador.Jogador;
import java.util.HashMap;
import java.util.Map;

public class Placar {
    private Map<Jogador, Integer> pontos = new HashMap<>();


    public Placar(Jogador jogador1, Jogador jogador2){
        pontos.put(jogador1, 0);
        pontos.put(jogador2, 0);
    }

    public void addpontos(Jogador jogador, int qtd){
        pontos.put(jogador, pontos.get(jogador) + qtd);
    }
    public void removepontos(Jogador jogador, int qtd){
        pontos.put(jogador, pontos.get(jogador) - qtd);
    }
    public void verPontos(Jogador jogador){
        System.out.println("Jogador " + jogador.getNome() + " tem: " + pontos.get(jogador));
    }
}
