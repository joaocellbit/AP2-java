import Jogador.Jogador;

import java.util.*;


public class Partida implements Comparator<Jogador> {
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
            jogador.atualizarFimDeTurno();
        }
        System.out.println("Rodada: " + this.rodada);
    }
    public int getTurno() {
        return turno;
    }
    public void passarTurno() {
        this.turno += 1;
    }
    public void acoesTurno() {
        // Ordena jogadores por agilidade (maior primeiro)
        jogadores.sort((j1, j2) -> Integer.compare(j2.getAgilidade(), j1.getAgilidade()));

        System.out.println("ordem dos turnos: ");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome());
        }
      

    }
    
    @Override
    public int compare(Jogador j1, Jogador j2) {
        return Integer.compare(j2.getAgilidade(), j1.getAgilidade()); // Ordem decrescente por agilidade
    }
}
