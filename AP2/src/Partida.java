import Jogador.Jogador;
import Jogador.Placar;
import Jogador.Regeneravel;
import Jogador.Tecnica;
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

    private void batalhaDeDominio(Jogador jogador1, Jogador jogador2) {
        System.out.println("\n========================================");
        System.out.println("CHOQUE DE DOMÍNIOS!");
        System.out.println("========================================");
        System.out.println(jogador1.getNome() + " vs " + jogador2.getNome());
        System.out.println("Primeiro a vencer 3 rodadas ganha a batalha!");
        
        Tecnica.setDomainClash(true);
        jogador1.getTecnica().resetVitoriasClash();
        jogador2.getTecnica().resetVitoriasClash();
        
        while (jogador1.getTecnica().getVitoriasClash() < 3 && jogador2.getTecnica().getVitoriasClash() < 3) {
            System.out.println("\n--- Rodada do Choque ---");
            
            // Dado de 10 lados + poder da técnica
            int dado1 = (int) (Math.random() * 10) + 1;
            int dado2 = (int) (Math.random() * 10) + 1;
            
            int total1 = dado1 + jogador1.getTecnica().getPoder();
            int total2 = dado2 + jogador2.getTecnica().getPoder();
            
            System.out.println(jogador1.getNome() + ": Dado(" + dado1 + ") + Poder(" + jogador1.getTecnica().getPoder() + ") = " + total1);
            System.out.println(jogador2.getNome() + ": Dado(" + dado2 + ") + Poder(" + jogador2.getTecnica().getPoder() + ") = " + total2);
            
            if (total1 > total2) {
                jogador1.getTecnica().addVitoriaClash();
                System.out.println(jogador1.getNome() + " vence esta rodada! (" + 
                                   jogador1.getTecnica().getVitoriasClash() + "/3)");
            } else if (total2 > total1) {
                jogador2.getTecnica().addVitoriaClash();
                System.out.println(jogador2.getNome() + " vence esta rodada! (" + 
                                   jogador2.getTecnica().getVitoriasClash() + "/3)");
            } else {
                System.out.println("EMPATE! Ninguém ganha ponto nesta rodada.");
            }
        }
        
        System.out.println("\n========================================");
        if (jogador1.getTecnica().getVitoriasClash() == 3) {
            System.out.println(jogador1.getNome() + " VENCEU A BATALHA DE DOMÍNIOS!");
            System.out.println(jogador1.getNome() + " mantém seu domínio expandido!");
            System.out.println(jogador2.getNome() + " perdeu 50 de energia e não consegue expandir!");
            jogador1.getTecnica().ExpandirDominio();
            jogador2.getTecnica().FecharDominio();
        } else {
            System.out.println(jogador2.getNome() + " VENCEU A BATALHA DE DOMÍNIOS!");
            System.out.println(jogador2.getNome() + " mantém seu domínio expandido!");
            System.out.println(jogador1.getNome() + " perdeu 50 de energia e não consegue expandir!");
            jogador2.getTecnica().ExpandirDominio();
            jogador1.getTecnica().FecharDominio();
        }
        System.out.println("========================================\n");
        
        Tecnica.setDomainClash(false);
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
               System.out.println("1 - Socar, 2 - Usar Técnica Inata, 3 - concentrar energia, 4 - regenerar vida(feitiçeiro gasta o dobro), 5 - Expandir Domínio");
               
               int acao = 0;
               boolean valido = false;
               
               while (!valido) {
                   if (input.hasNextInt()) {
                       acao = input.nextInt();
                       input.nextLine(); 
                       valido = true;
                   } else {
                       System.out.println("Entrada inválida! Por favor, digite um número válido (1-5):");
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
                               part.addDano(jogador.getForca());
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
                               part.addDano(jogador.getTecnica().getPoder());
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
                       if (jogador instanceof Regeneravel) {
                           ((Regeneravel) jogador).regenerarVida(vidaRegenerar);
                       }
                       break;
                   case 5:
                       if (jogador.getVidaAtual() >= 30) {
                           System.out.println("Você precisa estar com vida abaixo de 30 para expandir o domínio!");
                           System.out.println("Vida atual: " + jogador.getVidaAtual());
                       } else if (jogador.getEnergia() < 50) {
                           System.out.println("Você precisa de 50 de energia para expandir o domínio!");
                           System.out.println("Energia atual: " + jogador.getEnergia());
                       } else {
                           Jogador oponente = jogadores.get(i == 0 ? 1 : 0);
                           
                           // Verifica se o oponente já está com domínio expandido
                           if (oponente.getTecnica().isInDomain()) {
                               System.out.println("\n[ALERTA] " + oponente.getNome() + " já está com domínio expandido!");
                               System.out.println("Iniciando CHOQUE DE DOMÍNIOS...");
                               
                               // Ambos gastam energia
                               jogador.setEnergia(-50);
                               
                               // Inicia batalha de domínio
                               batalhaDeDominio(jogador, oponente);
                           } else {
                               // Expansão normal
                               jogador.getTecnica().ExpandirDominio();
                               jogador.setEnergia(-50);
                               System.out.println("Energia restante: " + jogador.getEnergia());
                           }
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
