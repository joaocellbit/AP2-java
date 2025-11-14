package Jogador;

public class Maldicao extends Jogador {
    public Maldicao(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica){
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public void usarTecnicaInata(Jogador alvo) {
        this.getTecnica().UsarTecnica(alvo, this, 10);
    }

    public void regenerar(int vidaDesejada) {
        
        if (vidaDesejada <= 0) {
            System.out.println("Valor inválido! Digite um valor positivo.");
            return;
        }

        
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);

       
        int energiaNecessaria = vidaARegrenerar;

   
        if (energiaNecessaria > Energia) {
            vidaARegrenerar = Energia; 
            energiaNecessaria = vidaARegrenerar;
        }

        
        if (vidaARegrenerar <= 0) {
            System.out.println(Nome + " não tem energia suficiente para regenerar!");
            return;
        }

      
        vidaAtual += vidaARegrenerar;
        Energia -= energiaNecessaria;

        System.out.println(Nome + " está regenerando!");
        System.out.println("Vida regenerada: +" + vidaARegrenerar);
        System.out.println("Energia consumida: -" + energiaNecessaria);
        System.out.println("Vida atual: " + vidaAtual + "/" + vidaMaxima);
        System.out.println("Energia atual: " + Energia);
    }

}
