import Jogador.Feiticeiro;
import Jogador.Jogador;
import Jogador.Maldicao;
import Jogador.Placar;
import java.util.*;



public class Partida implements Comparator<Jogador> {
    private int rodada = 0;
    private List<Jogador> jogadores = new ArrayList<>();
    private int turno;
    private Placar placar;
    private List<Participacao> participacoes = new ArrayList<>();


    public Partida( Jogador jogador1, Jogador jogador2) {
        // Verificação de duplicidade antes de adicionar
        if (!contemJogador(jogador1)) {
            jogadores.add(jogador1);
            participacoes.add(new Participacao(jogador1, this, 0, false));
        }
        if (!contemJogador(jogador2)) {
            jogadores.add(jogador2);
            participacoes.add(new Participacao(jogador2, this, 0, false));
        }
        this.placar = new Placar(jogador1, jogador2);
    }

    // Verificação de duplicidade em collections
    private boolean contemJogador(Jogador jogador) {
        for (Jogador j : jogadores) {
            if (j.getNome().equals(jogador.getNome())) {
                System.out.println("Jogador " + jogador.getNome() + " já está na partida!");
                return true;
            }
        }
        return false;
    }

    private Participacao getParticipacao(Jogador jogador) {
        for (Participacao p : participacoes) {
            if (p.getJogador().equals(jogador)) {
                return p;
            }
        }
        return null;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
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
        System.out.println("ordem dos turnos: " + jogadores.get(0).getNome() +" e depois " + jogadores.get(1).getNome());
        Scanner input = new Scanner(System.in);
        while(jogadores.get(0).getVidaAtual() > 0 && jogadores.get(1).getVidaAtual() > 0) {
            for (int i = 0; i < jogadores.size(); i++) {
               Jogador jogador = jogadores.get(i);
               System.out.println("Turno de " + jogador.getNome());
               System.out.println("Escolha uma ação: ");
               System.out.println("1 - Socar, 2 - Usar Técnica Inata, 3 - concentrar energia, 4 - regenerar vida(feitiçeiro gasta o dobro)");
               
               int acao = 0;
               boolean valido = false;
               
               while (!valido) {
                   if (input.hasNextInt()) {
                       acao = input.nextInt();
                       input.nextLine(); 
                       valido = true;
                   } else {
                       System.out.println("Entrada inválida! Por favor, digite um número válido (1-4):");
                       input.nextLine(); 
                   }
               }

               switch (acao) {
                   case 1:
                       int pontosSoco = jogador.Socar(jogadores.get(i == 0 ? 1 : 0));
                       if (pontosSoco > 0) {
                           placar.addPontos(jogador, pontosSoco);
                           // Registra dano na Participacao (N:N)
                           Participacao part = getParticipacao(jogador);
                           if (part != null) {
                               part.addDano(pontosSoco);
                           }
                       }
                       break;
                   case 2:
                       int pontosTecnica = jogador.usarTecnicaInata(jogadores.get(i == 0 ? 1 : 0));
                       if (pontosTecnica > 0) {
                           placar.addPontos(jogador, pontosTecnica);
                           // Registra dano na Participacao (N:N)
                           Participacao part = getParticipacao(jogador);
                           if (part != null) {
                               part.addDano(pontosTecnica);
                           }
                       }
                       break;
                   case 3:
                       System.out.println("Quanto de energia deseja concentrar?");
                       int energia = input.nextInt();
                       jogador.setEnergiaConcentrada(energia);
                       break;
                   case 4:
                       System.out.println("Quanto de vida deseja regenerar? Você tem " + jogador.getEnergia() + " de energia esta com " + jogador.getVidaAtual() + " de vida. ");
                       
                       int vidaRegenerar = input.nextInt();
                       if (jogador instanceof Feiticeiro) {
                           ((Feiticeiro) jogador).energiaReversa(vidaRegenerar);
                       } else if (jogador instanceof Maldicao) {
                           ((Maldicao) jogador).regenerar(vidaRegenerar);
                       }
                       break;
                   default:
                       System.out.println("Ação inválida.");
               }
               passarTurno();
               System.out.println("----------------------");
               System.out.println("fim do turno"); 

               
               
           }
              System.out.println("fim da rodada, status do combate:");
              for (Jogador jogador : jogadores) {
                jogador.Showall();
              }
           passarRodada();
       }
       System.out.println("fim da batalha! o vencedor é: ");
         for (Jogador jogador : jogadores) {
                if (jogador.getVidaAtual() > 0) {
                 System.out.println(jogador.getNome());
                 // Marca vencedor na Participacao (N:N)
                 Participacao part = getParticipacao(jogador);
                 if (part != null) {
                     part.setVenceu(true);
                 }
                }
          }
       
       // Mostrar placar final
       placar.mostrarPlacarFinal();
       
       // Mostrar informações do relacionamento N:N (Jogador <-> Partida)
       System.out.println("\n=== INFORMAÇÕES DE PARTICIPAÇÃO (N:N) ===");
       for (Participacao p : participacoes) {
           p.mostrarInfo();
           System.out.println("---");
       }
       
       input.close();
       

    }
    
    @Override
    public int compare(Jogador j1, Jogador j2) {
        return Integer.compare(j2.getAgilidade(), j1.getAgilidade()); // Ordem decrescente por agilidade
    }
}
