package Jogador;

public interface Regeneravel {
    void regenerarVida(int vidaDesejada);
    
    boolean podeRegenerarVida(int vidaDesejada);
    
    int getCustoRegeneracao();
}
