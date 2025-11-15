# Sistema de Batalha Jujutsu Kaisen ⚔️

## 📖 Descrição

Jogo de batalha por turnos inspirado em Jujutsu Kaisen, implementado em Java com foco nos pilares de Programação Orientada a Objetos (POO). O sistema permite combates entre Feiticeiros e Maldições, cada um com técnicas inatas únicas, sistema de energia, regeneração e expansão de domínio.

## 🎮 Funcionalidades Principais

### Sistema de Combate
- **Socos**: Ataque básico com chance de acertar baseada em agilidade
- **Técnicas Inatas**: 14 técnicas únicas com poderes especiais
- **Kokusen**: Ataque crítico poderoso (chance de ativar em zona)
- **Sistema de Zona**: Estado temporário que aumenta chance de Kokusen
- **Expansão de Domínio**: Acerto garantido (requer vida < 30 e 50 de energia)
- **Esquiva**: Baseada em agilidade + dado (1-10)

### Sistema de Energia
- **Concentração de Energia**: Converte energia em força temporariamente
- **Regeneração de Vida**: 
  - Feiticeiro: custo 2:1 (2 energia por 1 vida) via Energia Reversa
  - Maldição: custo 1:1 (1 energia por 1 vida)

### Sistema de Pontuação
- Soco normal: 10 pontos
- Kokusen: 100 pontos
- Técnica inata: 20 pontos

## 🎯 Técnicas Inatas Disponíveis

1. **Ilimitado** (Poder: 25) - "Azul!"
2. **Transfiguração Inerte** (Poder: 20) - "Tocado na alma!"
3. **Santuário** (Poder: 20) - "Desmantelar!"
4. **Príncipe dos Raios Negros** (Poder: 25) - 50% chance de Kokusen
5. **Dez Sombras** (Poder: 20) - "Mahoraga!"
6. **Proporção** (Poder: 20) - "7:3!"
7. **Fala Amaldiçoada** (Poder: 20) - "Exploda!"
8. **Boogie Woogie** (Poder: 22) - "Palmas!"
9. **Feitiço de Projeção** (Poder: 20) - "24 frames!"
10. **Manipulação de Sangue** (Poder: 21) - "Sangue perfurante!"
11. **Manipulação de Espíritos Amaldiçoados** (Poder: 23) - "Uzumaki!"
12. **Chamas do Desastre** (Poder: 20) - "Meteoro!"
13. **Construção** (Poder: 17) - "Floresta!"
14. **Cópia** (Poder: 0) - Copia a técnica do oponente

## 🏗️ Estrutura do Projeto

### Pilares de POO Implementados

#### ✅ Abstração
- Classes: `Jogador` (abstrata), `Feiticeiro`, `Maldicao`, `Tecnica`, `Partida`, `Participacao`, `Placar`
- Interface: `Regeneravel`
- Enums: `Grau`, `ListaTecnicas`

#### ✅ Encapsulamento
- Atributos `private`/`protected` com getters/setters
- Validações nos métodos de ação

#### ✅ Herança
```
Jogador (abstrata)
├── Feiticeiro
└── Maldicao
```

#### ✅ Polimorfismo
- `usarTecnicaInata()` sobrescrito em cada subclasse
- `regenerarVida()` implementado diferentemente por Feiticeiro/Maldição
- Referências de `Jogador` para diferentes tipos

#### ✅ Interface Própria
- `Regeneravel` implementada por `Feiticeiro` e `Maldicao`
- Métodos: `regenerarVida()`, `podeRegenerarVida()`, `getCustoRegeneracao()`

### Relacionamentos

- **1:1** - Partida ↔ Placar (composição)
- **1:N** - Partida → Jogadores
- **N:N** - Jogador ↔ Partida (via `Participacao`)

### Collections e Ordenação

- `List<Jogador>` com verificação de duplicidade
- `Map<Jogador, Integer>` para placar
- `jogadores.sort()` por agilidade (ordem decrescente)

## 📂 Estrutura de Arquivos

```
AP2/
├── src/
│   ├── Main.java                    # App interativo (menu + Scanner)
│   ├── Roteiro.java                 # App determinístico (demonstração)
│   ├── Partida.java                 # Sistema de turnos e combate
│   ├── Participacao.java            # Relacionamento N:N
│   └── Jogador/
│       ├── Jogador.java             # Classe abstrata base
│       ├── Feiticeiro.java          # Subclasse com Energia Reversa
│       ├── Maldicao.java            # Subclasse com Regeneração
│       ├── Regeneravel.java         # Interface de regeneração
│       ├── Tecnica.java             # Sistema de técnicas e domínio
│       ├── ListaTecnicas.java       # Enum com 14 técnicas
│       ├── Grau.java                # Enum de classificação
│       └── Placar.java              # Sistema de pontuação
└── README.md
```

## 🚀 Como Compilar e Executar

### Pré-requisitos
- Java JDK 11 ou superior
- Terminal/Prompt de Comando

### Compilação

```bash
# Navegue até a pasta do projeto
cd AP2

# Compile todos os arquivos Java
javac -d bin src/*.java src/Jogador/*.java
```

### Execução

#### App Interativo (Main.java)
```bash
# Execute o app com menu interativo
java -cp bin Main
```

**Funcionalidades:**
- Escolha nomes dos jogadores
- Selecione técnicas inatas (1-14)
- Sistema de turnos com 5 ações:
  1. Socar
  2. Usar Técnica Inata
  3. Concentrar Energia
  4. Regenerar Vida
  5. Expandir Domínio
- Placar e estatísticas finais

#### App Roteiro (Roteiro.java)
```bash
# Execute o roteiro de demonstração
java -cp bin Roteiro
```

**Demonstrações:**
- 18 cenários automatizados
- Testes de todas as mecânicas
- Exemplos de uso dos pilares de POO
- Validações e edge cases

## 🎲 Mecânicas de Jogo

### Sistema de Acerto/Esquiva
```
Total Atacante = Agilidade + Dado (1-10)
Total Defensor = Agilidade + Dado (1-10)

Se Total Defensor > Total Atacante → DESVIO
Senão → ACERTO
```

**Exceção:** Em Expansão de Domínio, todos os ataques acertam automaticamente.

### Graus de Poder
- **Grau 4** - Mais fraco
- **Grau 3**
- **Grau 2**
- **Grau 1**
- **Grau Especial** - Mais forte

### Condições de Vitória
- Reduzir a vida do oponente a 0
- Vencedor é determinado por:
  1. Jogador com vida > 0
  2. Placar de pontos

## 📊 Exemplo de Combate

```
=== RODADA 1 ===
Turno de Satoru Gojo
Escolha uma ação:
1 - Socar
2 - Usar Técnica Inata
3 - Concentrar Energia
4 - Regenerar Vida
5 - Expandir Domínio

> 2

Usando Tecnica
Satoru Gojo (Agi: 10 + Dado: 7 = 17)
Ryomen Sukuna (Agi: 12 + Dado: 5 = 17)
Ryomen Sukuna não conseguiu desviar da técnica!
Azul!
Ryomen Sukuna Leva o ataque
+20 pontos!
```

## 🛡️ Validações Implementadas

- ✅ Verificação de energia suficiente para ações
- ✅ Jogador morto não pode agir
- ✅ Limites de regeneração (não excede vida máxima)
- ✅ Verificação de duplicidade em partidas
- ✅ Requisitos para expansão de domínio (vida < 30, energia ≥ 50)
- ✅ Validação de nomes de jogadores

## 🎓 Conceitos de POO Demonstrados

### Abstração
- Classe `Jogador` define contrato para subclasses
- Método abstrato `usarTecnicaInata()`

### Encapsulamento
```java
private int vidaAtual;
public int getVidaAtual() { return vidaAtual; }
protected void setVidaAtual(int dano) { ... }
```

### Herança
```java
public class Feiticeiro extends Jogador { ... }
public class Maldicao extends Jogador { ... }
```

### Polimorfismo
```java
Jogador jogador1 = new Feiticeiro(...);
Jogador jogador2 = new Maldicao(...);
jogador1.usarTecnicaInata(jogador2); // Chamada polimórfica
```

### Interface
```java
public interface Regeneravel {
    void regenerarVida(int vidaDesejada);
    boolean podeRegenerarVida(int vidaDesejada);
    int getCustoRegeneracao();
}
```

### Collections
```java
List<Jogador> jogadores = new ArrayList<>();
Map<Jogador, Integer> pontos = new HashMap<>();
jogadores.sort((j1, j2) -> Integer.compare(j2.getAgilidade(), j1.getAgilidade()));
```

## 👨‍💻 Autores

Projeto desenvolvido para disciplina de Programação Orientada a Objetos.

## 📄 Licença

Este projeto é educacional e baseado na obra Jujutsu Kaisen de Gege Akutami.

---

**Desenvolvido com ☕ e Java**
