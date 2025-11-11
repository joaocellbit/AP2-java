import Jogador.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o nome do jogador 1?");
        String Nome1 = input.nextLine();
        System.out.println("Qual o nome do jogador 2?");
        String Nome2 = input.nextLine();


        Feiticeiro jogador1 = new Feiticeiro(Nome1,100, Grau.Grau_1, 4,100, 25, ListaTecnicas.PRINCIPE_DOS_RAIOS_NEGROS.getTecnica());
        Maldicao jogador2 = new Maldicao(Nome2, 150, Grau.Grau_Esp,2, 100, 20, ListaTecnicas.TRANSFIGURACAO_INERTE.getTecnica());
        jogador1.Showall();
        jogador2.Showall();
        Partida partida = new Partida(jogador1,jogador2);
        partida.passarRodada();
    input.close();



    }


}