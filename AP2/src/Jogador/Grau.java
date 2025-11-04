package Jogador;

public enum Grau {
    Grau_4(4, "Grau 4"),
    Grau_3(3, "Grau 3"),
    Grau_2(2, "Grau 2"),
    Grau_1(1, "Grau 1"),
    Grau_Esp(0, "Grau Especial");
    private int id;
    private String descricao;
    private Grau(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public String getGraus(){
        return descricao;
    }


}
