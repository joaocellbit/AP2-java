package Jogador;
import java.util.HashMap;
import java.util.Map;

public class Placar {
    private Map<Jogador, Integer> pontos = new HashMap<>();


    public Placar(Jogador jogador1, Jogador jogador2){
        pontos.put(jogador1, 0);
        pontos.put(jogador2, 0);
    }

    public void addPontos(Jogador jogador, int qtd){
        pontos.put(jogador, pontos.get(jogador) + qtd);
    }

    public void removePontos(Jogador jogador, int qtd){
        pontos.put(jogador, pontos.get(jogador) - qtd);
    }

    public void verPontos(Jogador jogador){
        System.out.println("Jogador " + jogador.getNome() + " tem: " + pontos.get(jogador) + " pontos");
    }

    public void mostrarPlacarFinal(){
        System.out.println("\n=== PLACAR FINAL ===");
        for (Map.Entry<Jogador, Integer> entry : pontos.entrySet()) {
            System.out.println(entry.getKey().getNome() + " : " + entry.getValue() + " pontos");
        }
    }

    public int getPontos(Jogador jogador){
        return pontos.get(jogador);
    }
}
