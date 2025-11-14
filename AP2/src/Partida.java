import Jogador.Feiticeiro;
import Jogador.Jogador;
import Jogador.Maldicao;
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
                       jogador.Socar(jogadores.get(i == 0 ? 1 : 0));
                       break;
                   case 2:
                       jogador.usarTecnicaInata(jogadores.get(i == 0 ? 1 : 0));
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
                }
          }
       input.close();
       

    }
    
    @Override
    public int compare(Jogador j1, Jogador j2) {
        return Integer.compare(j2.getAgilidade(), j1.getAgilidade()); // Ordem decrescente por agilidade
    }
}
