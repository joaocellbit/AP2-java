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
    protected boolean turno = false;

    public Jogador(String nome, int energia, Grau grau, int forca, int vidaMaxima, int agilidade, Tecnica tecnica) {
        this.Nome = nome;
        this.Energia = energia;
        this.Grau = grau;
        this.Forca = forca;
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
    public void setForca(int Aumento) {
        if (Energia >0 || Aumento<=Energia) {
            Energia -= Aumento;
            this.Forca += Aumento;
            System.out.println("Sua energia aumenta seu fisico");
        }
        else {
            System.out.println("Vc n tem energia pra isso");
        }

    }
    public boolean getTurno() {
        return turno;
    }
    public boolean setTurno(boolean turno) {
        this.turno = turno;
        return turno;
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
    public void Socar(Maldicao maldicao, Feiticeiro feiticeiro) {
        int random = (int) (Math.random() * 101);
        if (vidaAtual == 0) {
            System.out.println(Nome + " Voce nao pode socar... ja esta morto");
        }
        else if (maldicao == null) {

            if (random == 100 && !zona) {
                System.out.println("Kokusen!");
                System.out.println(Nome + " Voce entrou no estado de zona");
                zona = true;
                feiticeiro.setVidaAtual((int)(Math.pow(Forca,2.5)));
            }
            else if (!zona) {
                feiticeiro.setVidaAtual(Forca);
            } else {
                if (random >= 60) {
                    System.out.println("Kokusen!");
                    feiticeiro.setVidaAtual((int)(Math.pow(Forca,2.5)));
                }else {
                    feiticeiro.setVidaAtual(Forca);
                }
            }
        }else if (feiticeiro == null) {
            if (random == 100 && !zona) {
                System.out.println("Kokusen!");
                zona = true;
                System.out.println(Nome + " Voce entrou no estado de zona");
               maldicao.setVidaAtual((int)(Math.pow(Forca,2.5)));
            }
            else if(!zona) {
                maldicao.setVidaAtual(Forca);
            } else {
                if (random >= 60) {
                    System.out.println("Kokusen!");
                    maldicao.setVidaAtual((int)(Math.pow(Forca,2.5)));
                }else {
                    maldicao.setVidaAtual(Forca);
                }


            }
        }

    }


}
