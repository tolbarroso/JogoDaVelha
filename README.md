# JogoDaVelha

Este é um simples jogo da velha multiplayer implementado em Java, que permite dois jogadores jogarem online.

## Funcionalidades

- Permite que dois jogadores joguem o jogo da velha online.
- Utiliza sockets para comunicação entre o servidor e os clientes.
- Implementa a lógica do jogo da velha para determinar o vencedor ou empate.

## Como Executar

1. Clone este repositório:
git clone https://github.com/tolbarroso/JogoDaVelha.git


2. Compile os arquivos Java:
java `Servidor.java` `JogoDaVelha.java`


3. Inicie o servidor:
java `Servidor`


4. Os jogadores devem se conectar ao servidor utilizando um cliente que suporte sockets (por exemplo, um cliente Java).

## Como Jogar

1. Após iniciar o servidor, dois jogadores devem se conectar ao servidor.
2. O servidor irá atribuir X para o primeiro jogador e O para o segundo jogador.
3. Os jogadores alternam entre si para fazer suas jogadas.
4. O primeiro jogador a conseguir formar uma linha, coluna ou diagonal com três de seus símbolos vence o jogo.
5. Se todas as células do tabuleiro estiverem preenchidas e não houver um vencedor, o jogo termina em empate.

## Como Contribuir

Se você quiser contribuir com melhorias para este projeto, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature (`git checkout -b feature/nova-feature`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/nova-feature`).
5. Crie um novo Pull Request.

## Autor

Carol Barroso
