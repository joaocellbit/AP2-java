import Jogador.*;
import java.util.Scanner;

public class Main {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Tecnica escolherTecnica(Scanner input, String nomeJogador) {
        System.out.println("\n" + nomeJogador + ", escolha sua técnica inata:");
        System.out.println("1 - Ilimitado");
        System.out.println("2 - Transfiguração Inerte");
        System.out.println("3 - Santuário");
        System.out.println("4 - Príncipe dos Raios Negros");
        System.out.println("5 - Dez Sombras");
        System.out.println("6 - Proporção");
        System.out.println("7 - Fala Amaldiçoada");
        System.out.println("8 - Boogie Woogie");
        System.out.println("9 - Feitiço de Projeção");
        System.out.println("10 - Manipulação de Sangue");
        System.out.println("11 - Manipulação de Espíritos Amaldiçoados");
        System.out.println("12 - Chamas do Desastre");
        System.out.println("13 - Construção");
        System.out.println("14 - Cópia");
        
        int escolha = 0;
        boolean valido = false;
        
        while (!valido) {
            System.out.print("Digite o número da técnica (1-14): ");
            if (input.hasNextInt()) {
                escolha = input.nextInt(); 
                input.nextLine();
                if (escolha >= 1 && escolha <= 14) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida. Escolha entre 1 e 14.");
                }
            } else {
                System.out.println("Por favor, digite um número válido.");
                input.nextLine();
            }
        }
        
        switch (escolha) {
            case 1: return ListaTecnicas.ILIMITADO.getTecnica();
            case 2: return ListaTecnicas.TRANSFIGURACAO_INERTE.getTecnica();
            case 3: return ListaTecnicas.SANTUARIO.getTecnica();
            case 4: return ListaTecnicas.PRINCIPE_DOS_RAIOS_NEGROS.getTecnica();
            case 5: return ListaTecnicas.DEZ_SOMBRAS.getTecnica();
            case 6: return ListaTecnicas.PROPORCAO.getTecnica();
            case 7: return ListaTecnicas.FALA_AMALDICOADA.getTecnica();
            case 8: return ListaTecnicas.BOOGIE_WOOGIE.getTecnica();
            case 9: return ListaTecnicas.FEITICO_DE_PROJECAO.getTecnica();
            case 10: return ListaTecnicas.MANIPULACAO_DE_SANGUE.getTecnica();
            case 11: return ListaTecnicas.MANIPULACAO_DE_ESPIRITOS_AMALDICOADOS.getTecnica();
            case 12: return ListaTecnicas.CHAMAS_DO_DESASTRE.getTecnica();
            case 13: return ListaTecnicas.CONSTRUCAO.getTecnica();
            case 14: return ListaTecnicas.COPIA.getTecnica();
            default: return ListaTecnicas.ILIMITADO.getTecnica();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean validname = false;
        String Nome1="";
        String Nome2 ="";
        while (!validname) {
            System.out.println("Qual o nome do jogador 1?");
            Nome1 = input.nextLine();
            if (Nome1.trim().isEmpty() || Nome1 == null || isInteger(Nome1)|| isFloat(Nome1)) {
                System.out.println("Nome inválido. Tente novamente.");
            } else {
                validname = true;
            }
        }
        validname = false;
        while (!validname) {
            System.out.println("Qual o nome do jogador 2?");
            Nome2 = input.nextLine();
            if (Nome2.trim().isEmpty() || Nome2 == null || isInteger(Nome2)|| isFloat(Nome2)) {
                System.out.println("Nome inválido. Tente novamente.");
            } else {
                validname = true;
            }
        }
        
       
        Tecnica tecnicaJogador1 = escolherTecnica(input, Nome1);
        Tecnica tecnicaJogador2 = escolherTecnica(input, Nome2);
        
        int random_energy1 = (int) (Math.random() * 100)+50;
        int random_energy2 = (int) (Math.random() * 100)+50;
        System.out.println("Jogador 1 terá " + random_energy1 + " de energia inicial.");
        System.out.println("Jogador 2 terá " + random_energy2 + " de energia inicial.");    

        Feiticeiro jogador1 = new Feiticeiro(Nome1,random_energy1, Grau.Grau_1, (int) (Math.random() * 10)+2,150, (int) (Math.random() * 10)+1, tecnicaJogador1);
        Maldicao jogador2 = new Maldicao(Nome2, random_energy2, Grau.Grau_Esp,(int) (Math.random() * 10)+2, 150, (int) (Math.random() * 10)+1, tecnicaJogador2);
        jogador1.Showall();
        jogador2.Showall();
        
        Partida partida = new Partida(jogador1,jogador2);
        partida.passarRodada();
        partida.acoesTurno();
    



    }


}