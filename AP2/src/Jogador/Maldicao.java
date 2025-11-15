package Jogador;

public class Maldicao extends Jogador implements Regeneravel {
    public Maldicao(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica){
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public int usarTecnicaInata(Jogador alvo) {
        return this.getTecnica().UsarTecnica(alvo, this, 10);
    }

    public void regenerar(int vidaDesejada) {
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);
        int energiaNecessaria = vidaARegrenerar;
        
        if (energiaNecessaria > Energia) {
            vidaARegrenerar = Energia; 
            energiaNecessaria = vidaARegrenerar;
        }
        
        vidaAtual += vidaARegrenerar;
        Energia -= energiaNecessaria;

        System.out.println(Nome + " está regenerando!");
        System.out.println("Vida regenerada: +" + vidaARegrenerar);
        System.out.println("Energia consumida: -" + energiaNecessaria);
        System.out.println("Vida atual: " + vidaAtual + "/" + vidaMaxima);
        System.out.println("Energia atual: " + Energia);
    }

    // Implementação da interface Regeneravel
    @Override
    public void regenerarVida(int vidaDesejada) {
        if (!podeRegenerarVida(vidaDesejada)) {
            System.out.println(Nome + " não pode regenerar " + vidaDesejada + " de vida!");
            return;
        }
        
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);
        int custoRegeneracao = getCustoRegeneracao();
        int energiaNecessaria = vidaARegrenerar * custoRegeneracao;
        
        if (energiaNecessaria > Energia) {
            vidaARegrenerar = Energia / custoRegeneracao;
            energiaNecessaria = vidaARegrenerar * custoRegeneracao;
        }
        
        vidaAtual += vidaARegrenerar;
        Energia -= energiaNecessaria;

        System.out.println(Nome + " está regenerando!");
        System.out.println("Vida regenerada: +" + vidaARegrenerar);
        System.out.println("Energia consumida: -" + energiaNecessaria + " (custo: " + custoRegeneracao + ":1)");
        System.out.println("Vida atual: " + vidaAtual + "/" + vidaMaxima);
        System.out.println("Energia atual: " + Energia);
    }

    @Override
    public boolean podeRegenerarVida(int vidaDesejada) {
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);
        int custoRegeneracao = getCustoRegeneracao();
        int energiaNecessaria = vidaARegrenerar * custoRegeneracao;
        return Energia >= energiaNecessaria && vidaARegrenerar > 0;
    }

    @Override
    public int getCustoRegeneracao() {
        return 1; // Maldições gastam 1 de energia por 1 de vida
    }

}
