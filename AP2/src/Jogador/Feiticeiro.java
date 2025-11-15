package Jogador;

public class Feiticeiro extends Jogador implements Regeneravel {
    public Feiticeiro(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public int usarTecnicaInata(Jogador alvo) {
        return this.tecnica.UsarTecnica(alvo, this, 10);
    }

    public void energiaReversa(int vidaDesejada) {
        int vidaFaltando = vidaMaxima - vidaAtual;
        int vidaARegrenerar = Math.min(vidaDesejada, vidaFaltando);
        int energiaNecessaria = vidaARegrenerar * 2;
        
        if (energiaNecessaria > Energia) {
            vidaARegrenerar = Energia / 2;  
            energiaNecessaria = vidaARegrenerar * 2;
        }
        
        vidaAtual += vidaARegrenerar;
        Energia -= energiaNecessaria;

        System.out.println(Nome + " usou Energia Reversa!");
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

        System.out.println(Nome + " usou Energia Reversa!");
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
        return 2; // Feiticeiros gastam 2 de energia por 1 de vida
    }
}
