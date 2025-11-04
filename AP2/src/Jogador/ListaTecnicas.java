package Jogador;

public enum ListaTecnicas {
    ILIMITADO(new Tecnica("Ilimitado", 25)),
    TRANSFIGURACAO_INERTE(new Tecnica("Transfiguraçao inerte", 20)),
    SANTUARIO(new Tecnica("Santuario", 20)),
    PRINCIPE_DOS_RAIOS_NEGROS(new Tecnica("Principe dos Raios Negros", 25));
    private Tecnica tecnica;
    private ListaTecnicas(Tecnica tecnica) {
        this.tecnica = tecnica;
    }
    public Tecnica getTecnica() {
        return tecnica;
    }
}
