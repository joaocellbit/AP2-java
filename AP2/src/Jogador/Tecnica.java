package Jogador;

public class Tecnica {
    private String nome;
    private int poder;

    public Tecnica(String nome,int poder){
        this.nome = nome;
        this.poder = poder;
    }
    public String getNome() {
        return nome;
    }
    public int getPoder() {
        return poder;
    }
    public void UsarTecnica(Jogador inimigo,Jogador Usuario, int consumo) {




        System.out.println("Usando Tecnica");
        switch (nome) {
            case "Ilimitado":
                System.out.println("Azul!");
                inimigo.setVidaAtual(poder);

                break;
            case "Transfiguraçao inerte":
                System.out.println("tocado na alma");
                inimigo.setVidaAtual(poder);
                break;
            case "Santuario":
                System.out.println("Desmantelar");
                inimigo.setVidaAtual(poder);
                break;
            case "Principe dos Raios Negros":
                System.out.println("é o principe papai");
                int random = (int) (Math.random() * 101);
                if (random >= 50) {
                    System.out.println("Kokusen!");
                    inimigo.setVidaAtual((int) (Math.pow(Usuario.Forca, 2.5)));
                }else {
                    inimigo.setVidaAtual(Usuario.getForca());
                }
                break;
            default:
                System.out.println("Sem Tecnica");
                break;
        }
    }
}
