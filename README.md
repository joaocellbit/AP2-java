# AP2 – Sistema de Batalha em Turnos (Jujutsu Kaisen)

Projeto da disciplina de Programação Orientada a Objetos (AP2) em Java, modelando um **sistema de luta em turnos** inspirado em *Jujutsu Kaisen*. O foco é demonstrar os principais conceitos de POO (abstração, encapsulamento, herança, polimorfismo, relacionamentos, collections, etc.) em um jogo de console.

## Visão geral do jogo

* Um **Feiticeiro Jujutsu** enfrenta uma **Maldição** em um combate em turnos.
* Cada **Jogador** possui:

  * nome, vida, energia amaldiçoada, força, agilidade;
  * **Grau** (rank, ex.: Grau 4, Grau 3, ...);
  * uma **Técnica Inata** escolhida de um `enum` de técnicas famosas.
* Em cada turno, o jogador pode:

  * **Socar** o oponente;
  * **Concentrar energia** para aumentar força/energia;
  * **Usar técnica inata**;
  * (Opcional no teu código) **Recuperar vida** com algum custo.
* O combate termina quando a vida de um dos dois chega a 0.

## Estrutura do projeto

```text
AP2-java/
  src/
    Main.java                # aplicação interativa (menu com Scanner)
    Roteiro.java             # (quando criado) aplicação de roteiro, sem Scanner
    Participacao.java        # classe associativa Jogador <-> Partida
    Partida.java             # representa uma luta (1:N jogadores)
    Placar.java              # controla pontuação/estatísticas da luta
    Jogador/
      Jogador.java           # classe abstrata base
      Feiticeiro.java        # subclasse de Jogador (feiticeiro jujutsu)
      Maldicao.java          # subclasse de Jogador (espírito amaldiçoado)
      Tecnica.java           # representação de uma técnica inata
      Grau.java              # enum de graus (Grau 4, Grau Especial, etc.)
      ListaTecnicas.java     # enum de técnicas famosas de Jujutsu Kaisen
```

> Se o nome de alguma classe `main` for diferente no seu código (por exemplo, `AppInterativo` em vez de `Main`), ajuste os comandos abaixo para o nome real da classe.

## Conceitos de POO demonstrados

* **Abstração**

  * Várias classes de domínio: `Jogador`, `Feiticeiro`, `Maldicao`, `Tecnica`, `Partida`, `Placar`, `Participacao`.
  * `Grau` e `ListaTecnicas` modelam conceitos do universo de Jujutsu Kaisen.
* **Encapsulamento**

  * Atributos privados nas classes de domínio.
  * Métodos garantem invariantes (vida não negativa, controle da "zona", etc.).
* **Herança**

  * `Jogador` é uma classe abstrata; `Feiticeiro` e `Maldicao` estendem `Jogador`.
* **Polimorfismo**

  * Métodos definidos em `Jogador` e sobrescritos nas subclasses (por exemplo, uso da técnica inata).
  * Uso de variáveis/coleções do tipo `Jogador` para armazenar diferentes personagens concretos.
* **Relacionamentos**

  * 1:1: `Partida` ↔ `Placar`.
  * 1:N: `Partida` → lista de `Jogador`.
  * N:N: `Jogador` ↔ `Partida` via `Participacao` (classe associativa), com vínculo bidirecional.
* **Collections e ordenação**

  * Uso de `List`, `Set` ou `Map` para guardar jogadores, participações e pontos.
  * Ordenação para exibir ranking ou estatísticas.

## Requisitos

* **Java Development Kit (JDK) 17+** instalado.
* Opcional, mas recomendado: uma IDE como **IntelliJ IDEA**, **VS Code com Extensão Java** ou **Eclipse**.

## Como compilar e executar (linha de comando)

Abaixo, um exemplo genérico assumindo que todos os arquivos `.java` estão dentro da pasta `src/`:

### 1. Compilar

No terminal, dentro da pasta raiz do projeto (`AP2-java/`):

```bash
# Linux / macOS (bash)
javac -d out $(find src -name "*.java")
```

No Windows, você pode:

* Usar o **PowerShell** para coletar todos os `.java`:

```powershell
# PowerShell (a partir da pasta do projeto)
Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName } | javac -d out @-
```

Se preferir algo mais simples, você também pode entrar em `src/` e compilar manualmente, por exemplo:

```bash
cd src
javac -d ../out *.java Jogador/*.java
```

> O importante é que **todos os `.java` sejam compilados** para dentro da pasta `out/`.

### 2. Executar a aplicação interativa (console com menu)

Depois de compilar, vá para a pasta `out/`:

```bash
cd out
```

E execute a classe principal interativa **Main** (ela está no pacote padrão, direto em `src/`):

```bash
java Main
```

Essa aplicação abre o **menu de combate** no console, onde você escolhe as ações do feiticeiro e da maldição turno a turno.

### 3. Executar a aplicação de roteiro (execução fixa)

Quando você criar a segunda aplicação (por exemplo, `Roteiro.java` também em `src/`), basta garantir que ela tenha um método `public static void main(String[] args)` e rodar:

````bash
java Roteiro
``` (execução fixa)

Para o segundo app (roteiro), faça o mesmo procedimento, mas chamando a outra classe `main`:

```bash
# se Roteiro estiver no pacote padrão
java Roteiro

# se estiver em um pacote (ex.: Jogador)
java Jogador.Roteiro
````

Esse app executa uma sequência fixa de ações (por exemplo, alguns turnos predefinidos) para demonstrar as regras de forma determinística, facilitando correção.

## Como executar em uma IDE

1. **Importar o projeto** na IDE ("Open Folder" ou "Open Project" na raiz `AP2-java/`).
2. Garantir que a IDE esteja usando **JDK 17 ou superior**.
3. Localizar a classe `Main` (aplicação interativa):

   * Clique com o botão direito e escolha **Run 'Main.main()'**.
4. Localizar a classe `Roteiro` (aplicação de roteiro):

   * Clique com o botão direito e escolha **Run 'Roteiro.main()'**.

## Como jogar (aplicação interativa)

1. Ao rodar `Main`, o programa instancia um **feiticeiro** e uma **maldição** com graus, atributos e técnicas definidos.
2. O jogo decide quem começa (por exemplo, com base na **agilidade**).
3. Em cada turno, o jogador da vez escolhe uma ação no menu:

   * `1` – Socar o inimigo;
   * `2` – Concentrar energia (melhorar força/energia amaldiçoada);
   * `3` – Usar a técnica inata;
   * `4` – (se implementado) Recuperar vida com algum custo.
4. Algumas ações podem ativar estados especiais, como **ZONA**, que ampliam o dano por 1 turno.
5. O combate termina quando a vida de um dos dois chega a **0**; o programa exibe o vencedor.

## Observações finais

* Este projeto foi construído com foco em **didática de POO** para a AP2, não em balanceamento perfeito de jogo.
* O código e a modelagem foram pensados para deixar claro para o avaliador onde estão:

  * abstração, encapsulamento, herança e polimorfismo;
  * os diferentes tipos de relacionamentos (1:1, 1:N, N:N);
  * uso de `enum`, collections e ordenação.
* Ajuste livremente valores de dano, custos de energia e lista de técnicas para deixar a jogabilidade mais divertida ou mais fiel ao anime.
