import Jogador.*;

import java.util.Collection;
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
        input.close();
        int random = (int) (Math.random() * 100)+1;

        Feiticeiro jogador1 = new Feiticeiro(Nome1,random, Grau.Grau_1, (int) (Math.random() * 10)+1,150, (int) (Math.random() * 10)+1, ListaTecnicas.PRINCIPE_DOS_RAIOS_NEGROS.getTecnica());
        Maldicao jogador2 = new Maldicao(Nome2, random, Grau.Grau_Esp,(int) (Math.random() * 10)+1, 150, (int) (Math.random() * 10)+1, ListaTecnicas.TRANSFIGURACAO_INERTE.getTecnica());
        jogador1.Showall();
        jogador2.Showall();
        
        Partida partida = new Partida(jogador1,jogador2);
        partida.passarRodada();
        partida.acoesTurno();
    



    }


}