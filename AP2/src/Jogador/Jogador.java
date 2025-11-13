package Jogador;

public abstract class Jogador {
    protected String Nome;
    protected int Energia;
    protected Grau Grau;
    protected int Forca;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int Agilidade;
    protected Tecnica tecnica;
    protected boolean zona = false;
    protected int rodadasZonaRestantes;
    protected boolean energiaConcentrada = false;
    protected int rodadasConcentradasRestantes;
    protected int forcaBase;


    public Jogador(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {

        this.Nome = nome;
        this.Energia = energia;
        this.Grau = grau;
        this.Forca = forca;
        this.forcaBase = forca;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.Agilidade = agilidade;
        this.tecnica = tecnica;


    }
    public String getNome() {
        return Nome;
    }
    public int getVidaAtual() {
        return vidaAtual;
    }
    public int getEnergia() {
        return Energia;
    }
    public String getGrau() {
        return Grau.getGraus();
    }
    public int getForca() {
        return Forca;
    }
    public void setEnergia(int energia) {
        this.Energia += energia;
    }

    public int  setVidaAtual(int poder) {
        System.out.println(Nome + " Leva o ataque");
        vidaAtual -= poder;
        if (vidaAtual < 0) {
            vidaAtual = 0;
            System.out.println(Nome + " Faleceu :c");
        }

        return vidaAtual;
    }
    public int getAgilidade() {
        return Agilidade;
    }
    public Tecnica getTecnica() {
        return tecnica;
    }
    public abstract void usarTecnicaInata(Jogador alvo);

    public void Socar(Jogador defensor) {
        int random = (int) (Math.random() * 100);

        // atacante morto não bate
        if (getVidaAtual() == 0) {
            System.out.println(this.getNome() + " voce nao pode socar... ja esta morto");
            return;
        }

        // atacante ainda nao esta em zona
        if (!getZona()) {

            // 1% de chance de Kokusen e entrar em zona
            if (random == 99) {
                System.out.println("Kokusen!");
                entrarZona(1); // zona dura 1 turno
                defensor.setVidaAtual((int) Math.pow(getForca(), 2.5));
            } else {
                // soco normal
                defensor.setVidaAtual(getForca());
            }

            // atacante ja esta em zona
        } else {

            // enquanto estiver em zona, chance maior de Kokusen
            if (random >= 60) {
                System.out.println("Kokusen!");
                entrarZona(1); // se quiser, renova a duracao
                defensor.setVidaAtual((int) Math.pow(getForca(), 2.5));
            } else {
                defensor.setVidaAtual(getForca());
            }
        }
    }

    public void Showall(){
        System.out.println("nome: "+Nome);
        System.out.println("energia: "+Energia);
        System.out.println("grau: "+Grau.getGraus());
        System.out.println("forca: "+Forca);
        System.out.println("vida atual: "+vidaAtual);
        System.out.println("agilidade: "+Agilidade);
        System.out.println("tecnica: "+tecnica.getNome());
        System.out.println("zona: "+zona);
        System.out.println("energia concentrada: "+energiaConcentrada);
        System.out.println("--------------");   
    }
    public boolean getZona() {
        return zona;
    }
    public void entrarZona(int duracao) {
        this.zona = true;
        this.rodadasZonaRestantes = duracao+1;
        this.Energia += 20; // ganha 20 de energia ao entrar em zona
        System.out.println(getNome() + " entrou em ZONA por " + duracao + " turno(s)!");
    }
    public void atualizarFimDeTurno(){
        if (zona) {
            rodadasZonaRestantes--;
            if (rodadasZonaRestantes <= 0) {
                zona = false;
                System.out.println(getNome() + " saiu da ZONA.");
            }
        }
        if (energiaConcentrada){
            rodadasConcentradasRestantes--;
            if (rodadasConcentradasRestantes <= 0) {
                energiaConcentrada = false;
                Forca = forcaBase;
                System.out.println(getNome() + " acabou a energia concentrada");
            }
        }
    }
    public boolean getEnergiaConcentrada() {
        return energiaConcentrada;
    }
    public void setEnergiaConcentrada(int qtd) {
        
        if (Energia >0 && qtd<=Energia && qtd>=0) {
            Energia -= qtd;
            this.Forca += qtd;
            energiaConcentrada = true;
             this.rodadasConcentradasRestantes = 2;
            System.out.println("Sua energia aumenta seu fisico");
        }
        else {
            System.out.println("Vc n tem energia pra isso");
        }
       
    }

}
