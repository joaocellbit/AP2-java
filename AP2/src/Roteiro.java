import Jogador.*;

public class Roteiro {
    public static void main(String[] args) {
        System.out.println("=== ROTEIRO DE DEMONSTRAÇÃO - SISTEMA DE BATALHA JUJUTSU KAISEN ===\n");
        
        // ========== DEMONSTRAÇÃO 1: CRIAÇÃO DE JOGADORES ==========
        System.out.println("--- 1. CRIAÇÃO DE PERSONAGENS ---");
        
        Feiticeiro gojo = new Feiticeiro(
            "Satoru Gojo", 
            100, 
            Grau.Grau_Esp, 
            15, 
            200, 
            10, 
            ListaTecnicas.ILIMITADO.getTecnica()
        );
        
        Maldicao sukuna = new Maldicao(
            "Ryomen Sukuna", 
            120, 
            Grau.Grau_Esp, 
            18, 
            180, 
            12, 
            ListaTecnicas.SANTUARIO.getTecnica()
        );
        
        System.out.println("Feiticeiro criado: " + gojo.getNome() + " - Grau: " + gojo.getGrau());
        System.out.println("Maldição criada: " + sukuna.getNome() + " - Grau: " + sukuna.getGrau());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 2: EXIBIÇÃO DE STATUS COMPLETO ==========
        System.out.println("--- 2. STATUS INICIAL DOS COMBATENTES ---");
        gojo.Showall();
        sukuna.Showall();
        
        // ========== DEMONSTRAÇÃO 3: ATAQUES BÁSICOS (SOCAR) ==========
        System.out.println("--- 3. DEMONSTRAÇÃO DE SOCOS ---");
        System.out.println("\n>> " + gojo.getNome() + " ataca " + sukuna.getNome() + " com soco!");
        gojo.Socar(sukuna);
        System.out.println("Vida de " + sukuna.getNome() + " após soco: " + sukuna.getVidaAtual());
        
        System.out.println("\n>> " + sukuna.getNome() + " contra-ataca " + gojo.getNome() + " com soco!");
        sukuna.Socar(gojo);
        System.out.println("Vida de " + gojo.getNome() + " após soco: " + gojo.getVidaAtual());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 4: CONCENTRAÇÃO DE ENERGIA ==========
        System.out.println("--- 4. DEMONSTRAÇÃO DE CONCENTRAÇÃO DE ENERGIA ---");
        System.out.println("\n>> " + gojo.getNome() + " concentra 30 pontos de energia!");
        System.out.println("Força antes: " + gojo.getForca());
        System.out.println("Energia antes: " + gojo.getEnergia());
        gojo.setEnergiaConcentrada(30);
        System.out.println("Força depois: " + gojo.getForca());
        System.out.println("Energia depois: " + gojo.getEnergia());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 5: TÉCNICAS INATAS ==========
        System.out.println("--- 5. DEMONSTRAÇÃO DE TÉCNICAS INATAS ---");
        System.out.println("\n>> " + gojo.getNome() + " usa técnica inata: " + gojo.getTecnica().getNome());
        System.out.println("Vida de " + sukuna.getNome() + " antes: " + sukuna.getVidaAtual());
        gojo.usarTecnicaInata(sukuna);
        System.out.println("Vida de " + sukuna.getNome() + " depois: " + sukuna.getVidaAtual());
        
        System.out.println("\n>> " + sukuna.getNome() + " usa técnica inata: " + sukuna.getTecnica().getNome());
        System.out.println("Vida de " + gojo.getNome() + " antes: " + gojo.getVidaAtual());
        sukuna.usarTecnicaInata(gojo);
        System.out.println("Vida de " + gojo.getNome() + " depois: " + gojo.getVidaAtual());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 6: SISTEMA DE ZONA ==========
        System.out.println("--- 6. DEMONSTRAÇÃO DO SISTEMA DE ZONA ---");
        System.out.println("\n>> Forçando entrada em ZONA para " + sukuna.getNome());
        sukuna.entrarZona(2);
        System.out.println("Status da Zona: " + sukuna.getZona());
        System.out.println("Energia após entrar em zona: " + sukuna.getEnergia());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 7: ATUALIZAÇÃO DE TURNO ==========
        System.out.println("--- 7. DEMONSTRAÇÃO DE ATUALIZAÇÃO DE FIM DE TURNO ---");
        System.out.println("\n>> Passando turno para atualizar estados...");
        gojo.atualizarFimDeTurno();
        sukuna.atualizarFimDeTurno();
        System.out.println("✓ Estados atualizados");
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 8: MÚLTIPLAS TÉCNICAS DISPONÍVEIS ==========
        System.out.println("--- 8. DEMONSTRAÇÃO DE VARIEDADE DE TÉCNICAS ---");
        
        Feiticeiro yuji = new Feiticeiro(
            "Yuji Itadori", 
            80, 
            Grau.Grau_1, 
            20, 
            150, 
            15, 
            ListaTecnicas.PRINCIPE_DOS_RAIOS_NEGROS.getTecnica()
        );
        
        Maldicao mahito = new Maldicao(
            "Mahito", 
            90, 
            Grau.Grau_Esp, 
            12, 
            160, 
            8, 
            ListaTecnicas.TRANSFIGURACAO_INERTE.getTecnica()
        );
        
        System.out.println("✓ " + yuji.getNome() + " possui técnica: " + yuji.getTecnica().getNome());
        System.out.println("✓ " + mahito.getNome() + " possui técnica: " + mahito.getTecnica().getNome());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 9: SEQUÊNCIA DE COMBATE COMPLETA ==========
        System.out.println("--- 9. SEQUÊNCIA DE COMBATE COMPLETA ---");
        System.out.println("\n>> Iniciando combate entre " + yuji.getNome() + " e " + mahito.getNome());
        
        System.out.println("\nTurno 1:");
        yuji.Socar(mahito);
        mahito.Socar(yuji);
        
        System.out.println("\nTurno 2:");
        yuji.setEnergiaConcentrada(15);
        mahito.usarTecnicaInata(yuji);
        
        System.out.println("\nTurno 3:");
        yuji.usarTecnicaInata(mahito);
        mahito.Socar(yuji);
        
        System.out.println("\n>> Status após combate:");
        yuji.Showall();
        mahito.Showall();
        
        // ========== DEMONSTRAÇÃO 10: ENUMS E SUAS VARIAÇÕES ==========
        System.out.println("--- 10. DEMONSTRAÇÃO DE GRAUS E TÉCNICAS (ENUMS) ---");
        System.out.println("\nGraus disponíveis:");
        for (Grau grau : Grau.values()) {
            System.out.println("  - " + grau.getGraus() + " (ID: " + grau.getId() + ")");
        }
        
        System.out.println("\nAlgumas técnicas disponíveis:");
        System.out.println("  - " + ListaTecnicas.ILIMITADO.getTecnica().getNome() + " (Poder: " + ListaTecnicas.ILIMITADO.getTecnica().getPoder() + ")");
        System.out.println("  - " + ListaTecnicas.DEZ_SOMBRAS.getTecnica().getNome() + " (Poder: " + ListaTecnicas.DEZ_SOMBRAS.getTecnica().getPoder() + ")");
        System.out.println("  - " + ListaTecnicas.BOOGIE_WOOGIE.getTecnica().getNome() + " (Poder: " + ListaTecnicas.BOOGIE_WOOGIE.getTecnica().getPoder() + ")");
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 11: PARTIDA COMPLETA ==========
        System.out.println("--- 11. DEMONSTRAÇÃO DE PARTIDA (SISTEMA DE TURNOS) ---");
        
        Feiticeiro megumi = new Feiticeiro(
            "Megumi Fushiguro", 
            70, 
            Grau.Grau_2, 
            10, 
            140, 
            11, 
            ListaTecnicas.DEZ_SOMBRAS.getTecnica()
        );
        
        Maldicao jogo = new Maldicao(
            "Jogo", 
            100, 
            Grau.Grau_Esp, 
            14, 
            170, 
            9, 
            ListaTecnicas.CHAMAS_DO_DESASTRE.getTecnica()
        );
        
        System.out.println("Criando partida entre " + megumi.getNome() + " e " + jogo.getNome());
        Partida partida = new Partida(megumi, jogo);
        System.out.println("Partida criada! Rodada: " + partida.getRodada());
        partida.passarRodada();
        System.out.println("Rodada avançada para: " + partida.getRodada());
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 12: SISTEMA DE ESQUIVA BASEADO EM AGILIDADE ==========
        System.out.println("--- 12. DEMONSTRAÇÃO DE SISTEMA DE ESQUIVA ---");
        System.out.println("\nTeste de esquiva - quanto maior a agilidade, maior a chance de desviar:");
        
        Feiticeiro personagemRapido = new Feiticeiro(
            "Velocista", 
            100, 
            Grau.Grau_1, 
            10, 
            150, 
            20,  // Agilidade muito alta
            ListaTecnicas.BOOGIE_WOOGIE.getTecnica()
        );
        
        Maldicao personagemLento = new Maldicao(
            "Lentão", 
            100, 
            Grau.Grau_2, 
            15, 
            150, 
            3,   // Agilidade muito baixa
            ListaTecnicas.CONSTRUCAO.getTecnica()
        );
        
        System.out.println("\n>> " + personagemLento.getNome() + " (Agi: 3) tenta acertar " + personagemRapido.getNome() + " (Agi: 20):");
        personagemLento.Socar(personagemRapido);
        
        System.out.println("\n>> " + personagemRapido.getNome() + " (Agi: 20) contra-ataca " + personagemLento.getNome() + " (Agi: 3):");
        personagemRapido.Socar(personagemLento);
        
        System.out.println("\n>> Teste de esquiva com técnicas:");
        System.out.println(personagemLento.getNome() + " (Agi: 3) tenta usar técnica em " + personagemRapido.getNome() + " (Agi: 20):");
        personagemLento.usarTecnicaInata(personagemRapido);
        
        System.out.println("\n>> " + personagemRapido.getNome() + " (Agi: 20) usa técnica em " + personagemLento.getNome() + " (Agi: 3):");
        personagemRapido.usarTecnicaInata(personagemLento);
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 13: REGENERAÇÃO (ENERGIA REVERSA E REGENERAR) ==========
        System.out.println("--- 13. DEMONSTRAÇÃO DE REGENERAÇÃO ---");
        
        // Reduzir vida dos personagens para testar regeneração
        gojo.setVidaAtual(100);  // Reduz 100 de vida
        sukuna.setVidaAtual(80); // Reduz 80 de vida
        
        System.out.println("\n>> Estado antes da regeneração:");
        System.out.println(gojo.getNome() + " - Vida: " + gojo.getVidaAtual() + ", Energia: " + gojo.getEnergia());
        System.out.println(sukuna.getNome() + " - Vida: " + sukuna.getVidaAtual() + ", Energia: " + sukuna.getEnergia());
        
        System.out.println("\n>> " + gojo.getNome() + " (Feiticeiro) usa Energia Reversa para regenerar 30 de vida:");
        gojo.energiaReversa(30);
        
        System.out.println("\n>> " + sukuna.getNome() + " (Maldição) regenera 25 de vida:");
        sukuna.regenerar(25);
        System.out.println();
        
        // Teste de limites
        System.out.println(">> Teste de limites - tentando regenerar mais que o possível:");
        gojo.energiaReversa(500);  // Tentará regenerar mais que vida máxima permite
        
        System.out.println("\n>> Teste de energia insuficiente:");
        Feiticeiro feiticeiroCansado = new Feiticeiro(
            "Exausto", 
            5,  // Pouca energia
            Grau.Grau_1, 
            10, 
            100, 
            10, 
            ListaTecnicas.ILIMITADO.getTecnica()
        );
        feiticeiroCansado.setVidaAtual(50);  // Reduz vida
        System.out.println("Tentando regenerar 50 de vida com apenas 5 de energia:");
        feiticeiroCansado.energiaReversa(50);  // Só conseguirá regenerar 2 (5 energia / 2)
        System.out.println();
        
        // ========== DEMONSTRAÇÃO 14: POLIMORFISMO ==========
        System.out.println("--- 14. DEMONSTRAÇÃO DE POLIMORFISMO ---");
        System.out.println("\nUsando referência de Jogador para diferentes tipos:");
        
        Jogador jogador1 = gojo;  // Feiticeiro como Jogador
        Jogador jogador2 = sukuna; // Maldicao como Jogador
        
        System.out.println("Jogador 1 (Feiticeiro): " + jogador1.getNome() + " - Técnica: " + jogador1.getTecnica().getNome());
        System.out.println("Jogador 2 (Maldição): " + jogador2.getNome() + " - Técnica: " + jogador2.getTecnica().getNome());
        
        System.out.println("\nAmbos usando técnica inata através da referência Jogador:");
        jogador1.usarTecnicaInata(jogador2);
        jogador2.usarTecnicaInata(jogador1);
        System.out.println();
        
        // ========== RESUMO FINAL ==========
        System.out.println("=== RESUMO FINAL DA DEMONSTRAÇÃO ===");
        System.out.println("✓ Abstração: Classes Jogador, Feiticeiro, Maldicao, Tecnica, Partida, etc.");
        System.out.println("✓ Encapsulamento: Atributos privados/protected com getters/setters");
        System.out.println("✓ Herança: Jogador (abstrata) → Feiticeiro e Maldicao");
        System.out.println("✓ Polimorfismo: usarTecnicaInata() sobrescrito, referências de Jogador");
        System.out.println("✓ Enums: Grau e ListaTecnicas");
        System.out.println("✓ Collections: List em Partida, Map em Placar");
        System.out.println("✓ Relacionamentos: 1:1 (Partida-Placar), 1:N (Partida-Jogadores)");
        System.out.println("✓ Sistema de Esquiva: Baseado em agilidade + dado (1-10) para socos E técnicas");
        System.out.println("✓ Regeneração: Energia Reversa (Feiticeiro 2:1) e Regenerar (Maldição 1:1)");
        System.out.println("\n=== FIM DO ROTEIRO ===");
    }
}
