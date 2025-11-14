import Jogador.Jogador;
public class Participacao {
    private Jogador jogador;
    private Partida partida;
    private int danoTotal;
    private boolean venceu;


    public Participacao(Jogador jogador, Partida partida, int danoTotal, boolean venceu) {
        this.jogador = jogador;
        this.partida = partida;
        this.danoTotal = danoTotal;
        this.venceu = venceu;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Partida getPartida() {
        return partida;
    }

    public int getDanoTotal() {
        return danoTotal;
    }

    public void setDanoTotal(int danoTotal) {
        this.danoTotal = danoTotal;
    }

    public void addDano(int dano) {
        this.danoTotal += dano;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }

    public void mostrarInfo() {
        System.out.println("Jogador: " + jogador.getNome());
        System.out.println("Dano Total Causado: " + danoTotal);
        System.out.println("Vencedor: " + (venceu ? "Sim" : "Não"));
    }
}