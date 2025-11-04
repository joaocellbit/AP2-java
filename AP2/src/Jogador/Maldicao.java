package Jogador;

public class Maldicao extends Jogador {
    public Maldicao(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica){
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }
    public void UsarTecnicaInata(Feiticeiro feiticeiro) {
        this.tecnica.UsarTecnica(feiticeiro, this, 10);

    }

}
