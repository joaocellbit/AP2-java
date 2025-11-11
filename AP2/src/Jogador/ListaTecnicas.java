package Jogador;

public enum ListaTecnicas {
    ILIMITADO(new Tecnica("Ilimitado", 25)),
    TRANSFIGURACAO_INERTE(new Tecnica("Transfiguraçao inerte", 20)),
    SANTUARIO(new Tecnica("Santuario", 20)),
    PRINCIPE_DOS_RAIOS_NEGROS(new Tecnica("Principe dos Raios Negros", 25)),
    DEZ_SOMBRAS(new Tecnica("Dez sombras", 20)),
    PROPORCAO(new Tecnica("Proporcao", 20)),
    FALA_AMALDICOADA(new Tecnica("Fala amaldicoada", 20)),
    BOOGIE_WOOGIE(new Tecnica("Boogie Woogie", 22)),
    FEITICO_DE_PROJECAO(new Tecnica("Feitico de projecao", 20)),
    MANIPULACAO_DE_SANGUE(new Tecnica("Manipulacao de sangue", 21)),
    MANIPULACAO_DE_ESPIRITOS_AMALDICOADOS(new Tecnica("Manipulacao de espiritos amaldicoados", 23)),
    CHAMAS_DO_DESASTRE(new Tecnica("Chamas do desastre", 20)),
    CONSTRUCAO(new Tecnica("Construcao", 17)),
    COPIA(new Tecnica("Copia", 0));


    private Tecnica tecnica;
    private ListaTecnicas(Tecnica tecnica) {
        this.tecnica = tecnica;
    }
    public Tecnica getTecnica() {
        return tecnica;
    }
}
