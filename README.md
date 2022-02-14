# Electricians Game :electric_plug:

## Visão Geral :open_book:

Trabalho Prático de Orientações a Objeto do período 2021.3 da UFJF. Implementação de um jogo chamado Electricians Game, inspirado no Plumber Game, um puzzle game onde o objetivo principal é conectar um determinado número de peças até que complete um circuito.

## Rodar o Projeto :computer:

1. Clonar o repositório
2. Iniciar o arquivo Game.java


## Entendendo o repositório :nerd_face:

Seção para explicar sobre o funcionamento das classes

1. Board:
    - Responsável por armazenar o tabuleiro. 
    - Possui o atributo **boardArray** matriz do tipo _Piece_, que armzena as peças que irão compor o jogo
    - Possui diversos métodos documentados. Os principais são: 
      - getPiece : Retorna a peça em determinada posição da matriz;
      - insertPiece : Insere peçã em determinad posição da matriz;
      - gameIsFinished : Retorna um valor booleano para caso o jogo tenha chegado ao fim;
    
2. Piece:
    - Classe abstrata responsável por criar métodos e atributos comuns a todos os tipos de peça. 
    - Possui diversos atributos. São eles:
      - currentOutputs : Lista que armzena as possíveis saídas da peça de acordo com sua posição
      - piecesConnected : Lista que armazena as peças que estão ligadas a esta
      - boardLine e boardColumn : Guarda a linha e coluna, respecitivamente, da peça no tabuleiro
      - position : Armazena a posição da peça
      - typeId : Armazena o tipo da peça (knee, cross, link)
    - Possui diversos métodos documentados. Os principais são: 
      - fillPiecesConnected : Preenche a lista de peças conectadas a uma determinada Peça
      - resetPiecesConnected : Método para resetar a lista de peças conectadas, removendo também na lista da peça vizinha

2.1 Piece Cross:
   - Herda a classe Piece e sobresceve o méotdo setPosition.
   - Essa peça possui 4 saídas e somente 1 solução.
   - Tem o formato de uma cruz
   - - Posições válidas:
         1 - Up,Left, Right, Down. Ex : + 

2.2 Piece Knee:
   - Herda a classe Piece e sobresceve o méotdo setPosition.
   - Essa peça possui 2 saídas e 4 soluções.
   - Tem o formato de um joelho (⅂)
   - Posições válidas:
         1 - Up and Left. Ex : ⅃
         2 - Up and Right. Ex  : L
         3 - Down and Left,. Ex  : ⅂
         4 - Down and Right. Ex  ℾ  
         
 2.3 Piece Link:
   - Herda a classe Piece e sobresceve o méotdo setPosition.
   - Essa peça possui 2 saídas e 2 soluções.
   - Tem o formato de uma reta (-)
   - Posições válidas:
       1 - Up and Down. Ex : I
       2 - Left and Right. Ex : -
         
  2.4 Piece Empty:
   - Herda a classe Piece e sobresceve o méotdo setPosition.
   - Essa peça não possui nenhuma saída e nenhuma solução
   - Representa um espaço vazio no tabuleiro


 3. Game:
   - Classe principal, responsável por executar o jogo.
