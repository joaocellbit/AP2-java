import Jogador.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Feiticeiro jogador1 = new Feiticeiro("Itadori",100, Grau.Grau_1, 4,100, 25, ListaTecnicas.PRINCIPE_DOS_RAIOS_NEGROS.getTecnica());
        Maldicao jogador2 = new Maldicao("Mahito", 150, Grau.Grau_Esp,2, 100, 20, ListaTecnicas.TRANSFIGURACAO_INERTE.getTecnica());
    if (jogador1.getAgilidade() > jogador2.getAgilidade()) {
        jogador1.setTurno(true);
        System.out.println("Jogador 1 começa");

    }else{
        jogador2.setTurno(true);
        System.out.println("Jogador 2 começa");
    }
    while (jogador1.getVidaAtual() > 0 && jogador2.getVidaAtual() > 0) {
        System.out.println("escolha sua opçao 1: Socar o inimigo, 2: Concentrar energia ,3: Usar Técnica , 4: Recuperar vida (Feitiçeiro gasta o dobro)");


        if (jogador1.getTurno()){
            System.out.println("Vez do jogador 1");
            int escolha = input.nextInt();
            switch (escolha) {
                case 1: System.out.println("jogador 1: "+ jogador1.getNome() + " soca jogador 2: "+jogador2.getNome() );
                    jogador1.Socar(jogador2, null);

                    break;
                case 2: System.out.println("Quanto de energia vc quer concentrar?");
                    int quantenergia = input.nextInt();
                    jogador1.setForca(quantenergia);
                    break;
                case 3: System.out.println("Usando técnica");
                jogador1.UsarTecnicaInata(jogador2);
            }
            jogador1.setTurno(false);
            jogador2.setTurno(true);

        }
        else if (jogador2.getTurno()){
            System.out.println("Vez do jogador 2");
            int escolha = input.nextInt();
            switch (escolha) {
                case 1: System.out.println("jogador 2: "+ jogador2.getNome() + " soca jogador 1: "+jogador1.getNome() );
                    jogador2.Socar(null, jogador1);

                    break;
                case 2: System.out.println("Quanto de energia vc quer concentrar?");
                    int quantenergia = input.nextInt();
                    jogador2.setForca(quantenergia);
                    break;
                case 3:System.out.println("Usando técnica");
                    jogador2.UsarTecnicaInata(jogador1);
            }
            jogador2.setTurno(false);
            jogador1.setTurno(true);
        }

    }
    input.close();



    }


}