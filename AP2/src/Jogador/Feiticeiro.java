package Jogador;

public class Feiticeiro extends Jogador {
    public Feiticeiro(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {
        super(nome,energia,grau,forca,vidaMaxima,agilidade,tecnica);
    }

    @Override
    public void usarTecnicaInata(Jogador alvo) {
        this.tecnica.UsarTecnica(alvo, this, 10);

    }
}
