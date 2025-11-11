package Jogador;

public class Maldicao extends Jogador {
    public Maldicao(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica){
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public void usarTecnicaInata(Jogador alvo) {
        this.getTecnica().UsarTecnica(alvo, this, 10);
    }

}
