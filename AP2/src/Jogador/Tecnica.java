package Jogador;

public class Tecnica {
    private String nome;
    private int poder;
    private boolean IsInDomain;

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
    
    public void ExpandirDominio() {
        this.IsInDomain = true;
        System.out.println("Expansão de Domínio!");
        System.out.println("⚡ Acerto garantido ativado! ⚡");
    }
    
    public void FecharDominio() {
        this.IsInDomain = false;
        System.out.println("Domínio fechado.");
    }
    
    public boolean isInDomain() {
        return IsInDomain;
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
        
        // Sistema de esquiva baseado em agilidade (ignorado se estiver em domínio)
        if (!IsInDomain) {
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
        } else {
            System.out.println("ACERTO GARANTIDO - DOMÍNIO ATIVO!");
        }
        
        switch (nome) {
            case "Ilimitado":
                System.out.println("Azul!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Transfiguraçao inerte":
                System.out.println("Tocado na alma!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Santuario":
                System.out.println("Desmantelar!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Principe dos Raios Negros":
                System.out.println("Foco total!");
                int random = (int) (Math.random() * 101);
                if (random >= 50) {
                    System.out.println("Kokusen!");
                    inimigo.setVidaAtual((int) (Math.pow(Usuario.Forca, 2.5)));
                    Usuario.entrarZona(1);
                    System.out.println("+100 pontos!");
                    return 100;
                } else {
                    inimigo.setVidaAtual(Usuario.getForca());
                    System.out.println("+10 pontos!");
                    return 10;
                }
            case "Dez sombras":
                System.out.println("Mahoraga!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Proporcao":
                System.out.println("7:3!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Fala amaldicoada":
                System.out.println("Exploda!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Boogie Woogie":
                System.out.println("Palmas!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Feitico de projecao":
                System.out.println("24 frames!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Manipulacao de sangue":
                System.out.println("Sangue perfurante!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Manipulacao de espiritos amaldicoados":
                System.out.println("Uzumaki!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Chamas do desastre":
                System.out.println("Meteoro!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Construcao":
                System.out.println("Floresta!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
            case "Copia":
                System.out.println("você consegue ingerir um pedaço do seu oponente");
                Usuario.setTecnica(inimigo.getTecnica());
                System.out.println("agora voce tem a tecnica " + inimigo.getTecnica().getNome());
                System.out.println("+20 pontos!");
                return 20;
            default:
                System.out.println("Técnica desconhecida!");
                inimigo.setVidaAtual(poder);
                System.out.println("+20 pontos!");
                return 20;
        }
    }
}
