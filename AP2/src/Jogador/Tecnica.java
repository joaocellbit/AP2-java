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
    public int UsarTecnica(Jogador inimigo,Jogador Usuario, int consumo) {




        System.out.println("Usando Tecnica");
        
        // Usuário morto não pode usar técnica
        if (Usuario.getVidaAtual() <= 0) {
            System.out.println(Usuario.getNome() + " você não pode usar técnica... já está morto");
            return 0;
        }
        
        // Verifica se tem energia suficiente
        if (Usuario.getEnergia() < consumo) {
            System.out.println(Usuario.getNome() + " não tem energia suficiente! (Necessário: " + consumo + ", Atual: " + Usuario.getEnergia() + ")");
            return 0;
        }
       
        Usuario.setEnergia(-consumo);
        
        // Sistema de esquiva baseado em agilidade
        int dadoAtacante = (int) (Math.random() * 10) + 1;  
        int dadoDefensor = (int) (Math.random() * 10) + 1;   
        
        int totalAtacante = dadoAtacante + Usuario.getAgilidade();
        int totalDefensor = dadoDefensor + inimigo.getAgilidade();
        
        System.out.println(Usuario.getNome() + " (Agi: " + Usuario.getAgilidade() + " + Dado: " + dadoAtacante + " = " + totalAtacante + ")");
        System.out.println(inimigo.getNome() + " (Agi: " + inimigo.getAgilidade() + " + Dado: " + dadoDefensor + " = " + totalDefensor + ")");
        
        if (totalDefensor > totalAtacante) {
            System.out.println(inimigo.getNome() + " DESVIOU da técnica! (Energia gasta: " + consumo + ")");
            return 0;
        }
        
        System.out.println(inimigo.getNome() + " não conseguiu desviar da técnica!");
        
        switch (nome) {
            case "Ilimitado":
                System.out.println("Azul!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Transfiguraçao inerte":
                System.out.println("tocado na alma");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Santuario":
                System.out.println("Desmantelar");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Principe dos Raios Negros":
                System.out.println("é o principe papai");
                
                int random = (int) (Math.random() * 101);
                if (random >= 50) {
                    System.out.println("Kokusen!");
                    inimigo.setVidaAtual((int) (Math.pow(Usuario.Forca, 2.5)));
                    Usuario.entrarZona(1); // zona dura 1 turno
                    System.out.println("+100 pontos!");
                    return 100;
                }else {
                    inimigo.setVidaAtual(Usuario.getForca());
                    System.out.println("+10 pontos!");
                    return 10;
                }
            default:
                System.out.println("Sem Tecnica");
                return 0;
        }
    }
}
