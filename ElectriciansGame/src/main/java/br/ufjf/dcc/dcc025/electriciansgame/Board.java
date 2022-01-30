/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.List;

/**
 *
 * @author savio
 */
public class Board {

    // ------------ Consts ------------
    public static int BOARD_LENGTH = 5;

    // --------- Atributes ---------
    private Piece[][] boardArray;

    // --------- Constructor ---------
    public Board() {
        this.boardArray = new Piece[BOARD_LENGTH][BOARD_LENGTH];
        fillBoard();
        
    }

    // --------- Methods --------
    //Setters
    public void setBoard(Piece board[][]) {
        this.boardArray = board;
    }
    
    
    //Getters

    public Piece[][] getBoard() {
        return this.boardArray;
    }
    
    //Others
    
    
    /**Método para obter uma peça do tabuleiro
    * @param line int - linha do tabuleiro onde está a peça
    * @param col int - coluna do tabuleiro onde está a peça
    * @return Piece - Peça que deseja obter
    */
    public Piece getPiece(int line, int col) throws ArrayIndexOutOfBoundsException{
        return boardArray[line][col];
        
    }
    
    /**Método para exibir todas as conexões entre peças existentes */
    public void printAllConexions(){
        for (int line = 0; line < BOARD_LENGTH; line++) {
                for (int col = 0; col < BOARD_LENGTH; col++) {
                    Piece p = boardArray[line][col];
                    if( p.typeId != "empty" ){
                      p.printPiecesConnected();
                    }
                }
        }
    }
    
    /**Método para preencher tabuleiro de peças vazia */
    private void fillBoard(){
        Piece empty = new PieceEmpty(0);
        for (int line = 0; line < BOARD_LENGTH; line++) {
            for (int col = 0; col < BOARD_LENGTH; col++) {
                boardArray[line][col] = empty;
            }
        }
    }
    
    /**Método para exibir tabuleiro */
    public void printBoard() {
        System.out.println(" \n  ====== BOARD ====== \n ");
        
        for (int line = 0; line < BOARD_LENGTH; line++) {
            for (int col = 0; col < BOARD_LENGTH; col++) {
                Piece p = this.boardArray[line][col];
                System.out.print(p.typeId + "("+  p.position  +") " + "id(" + p.id + ")   ");
            }
            System.out.print(" \n ");
        }
        
        System.out.println(" \n  ============== \n ");
    }
    
    /**Método para inserir uma peça no tabuleiro
    * @param line int - linha do tabuleiro onde deseja inserir a peça
    * @param col int - coluna do tabuleiro onde deseja inseri a peça
    * @param newPiece Piece - peça a ser inserida
    */
    public void insertPiece(Piece newPiece, int line, int col){
          try{
              boardArray[line][col] = newPiece;
              newPiece.setColumn(col);
              newPiece.setLine(line);
              newPiece.fillPiecesConnected(boardArray);
          }catch(ArrayIndexOutOfBoundsException e){
              System.out.print("Invalid position of board");
          }  
    }
    
    /**Método para verificar se o jogo terminou
    * @param phase Phase - Fase que o jogo se encontra
    * @return boolean - Retorna se o jogo terminou (true) ou não (false)
    */
    public boolean gameIsFinished(Phase phase){
        boolean finish = false;
        int exitPosition = phase.getExitPosition();
        int initPosition = phase.getInitPosition();
        
        Piece initialPiece = boardArray[initPosition][0];
        Piece finalPiece = boardArray[exitPosition][4];
        
        finish = auxGameIsFinished(initialPiece, initialPiece, finalPiece);
        
        System.out.println("Jogo terminou? " + finish);
        return finish;
    }
    
    /**Método recursivo auxiliar para percorrer a lista de conectados
    * @param pPrevious Piece - Peça anterior
    * @param pCurrent Piece - Peça atual
    * @param pFinal Piece - Peça na posição final do jogo
    * @return boolean - Retorna true quando encontra a peça final na lista de conectados
    */
    private boolean auxGameIsFinished(Piece pPrevious, Piece pCurrent, Piece pFinal){
        boolean response = false;
        List<Piece> p1connectdes = pCurrent.getPiecesConnected();
        
        for(Piece pAux : p1connectdes){
           if(pAux != pPrevious){
                if(pAux == pFinal) return true;
                response = auxGameIsFinished(pCurrent ,pAux, pFinal);
            } 
        }
        return response;
    }


}
