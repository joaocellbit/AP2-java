package Jogador;

public class Feiticeiro extends Jogador {
    public Feiticeiro(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public int usarTecnicaInata(Jogador alvo) {
        return this.tecnica.UsarTecnica(alvo, this, 10);
    }

    public void energiaReversa(int vidaDesejada) {
       
        if (vidaDesejada <= 0) {
            System.out.println("Valor inválido! Digite um valor positivo.");
            return;
        }

   
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);


        int energiaNecessaria = vidaARegrenerar * 2;

   
        if (energiaNecessaria > Energia) {
            vidaARegrenerar = Energia / 2;  
            energiaNecessaria = vidaARegrenerar * 2;
        }

      
        if (vidaARegrenerar <= 0) {
            System.out.println(Nome + " não tem energia suficiente para regenerar ou já está com a vida cheia!");
            return;
        }

      
        vidaAtual += vidaARegrenerar;
        Energia -= energiaNecessaria;

        System.out.println(Nome + " usou Energia Reversa!");
        System.out.println("Vida regenerada: +" + vidaARegrenerar);
        System.out.println("Energia consumida: -" + energiaNecessaria);
        System.out.println("Vida atual: " + vidaAtual + "/" + vidaMaxima);
        System.out.println("Energia atual: " + Energia);
    }
}
