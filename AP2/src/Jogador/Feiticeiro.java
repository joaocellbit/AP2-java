package Jogador;

public class Feiticeiro extends Jogador {
    public Feiticeiro(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }
    public void UsarTecnicaInata(Maldicao maldicao) {
        this.tecnica.UsarTecnica(maldicao, this, 10);

    }
}
