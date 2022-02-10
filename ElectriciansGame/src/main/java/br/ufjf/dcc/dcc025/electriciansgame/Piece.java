/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

/**
 *
 * @author savio
 *  ---- TYPES OF PIECE ----
 * Piece Cross - 4 output and 1 solution
 * Piece Knee - 2 output (90°) and 4 solution
 * Piece Link - 2 output (180°) and 2 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Piece {
    public static Piece getClassByString(String name) {
        switch (name) {
            case "knee":
                return new PieceKnee();
            case "cross":
                return new PieceCross();
            case "link":
                return new PieceLink();
            default:
                new PieceEmpty();
        }
        return null;
    }

    /* ---------- Attr -------------- */
    private List<Character> currentOutputs = new ArrayList<>();
    private List<Piece> piecesConnected = new ArrayList<>();
    private int boardLine = -100;
    private int boardColumn = -100;
    public int position = 0;
    public String typeId;
    public int id;

    /*
     * --------- Constructor ---------
     * 
     * /* ---------- Setters -------------
     */
    protected void setCurrentOutputs(List<Character> newCurrentOutputs) {
        this.currentOutputs = newCurrentOutputs;
    }

    public abstract void setPosition(int position);

    public void setLine(int line) {
        if (line > Board.BOARD_LENGTH || line < 0) {
            System.out.print("Erro. Tentando setar linha inválida");
        }
        boardLine = line;
    }

    public void setColumn(int col) {
        if (col > Board.BOARD_LENGTH || col < 0) {
            System.out.print("Erro. Tentando setar linha inválida");
        }
        boardColumn = col;
    }

    /* ----------- Getters ------------- */

    public List<Character> getCurrentOutputs() {
        return this.currentOutputs;
    }

    public int getPosition() {
        return this.position;
    }

    public List<Piece> getPiecesConnected() {
        return piecesConnected;
    }

    public int getLine() {
        return boardLine;
    }

    public int getColumn() {
        return boardColumn;
    }

    /* ----------- Others Methods ---------- */

    /**
     * Método para adicionar uma peça a lista de peças conectadas
     * 
     * @param piece Piece - peça a ser adicionada
     */
    public void addPiecesConnected(Piece piece) {
        piecesConnected.add(piece);
    }

    /**
     * Método para remover uma peça da lista de peças conectadas
     * 
     * @param piece Piece - peça a ser removida
     */
    private void removePiecesConnected(Piece piece) {
        piecesConnected.remove(piece);
    }

    /**
     * Método para resetar a lista de peças conectadas, removendo também na lista da
     * peça vizinha
     */
    public void resetPiecesConnected() {
        Iterator<Piece> it = piecesConnected.iterator();
        while (it.hasNext()) {
            Piece p = it.next();
            p.removePiecesConnected(this);
            it.remove();
        }
    }

    /** Método para exibir a lista de peças conectadas */
    public void printPiecesConnected() {
        System.out.print("Peça " + this.id + " está conectada as seguintes peças: ");
        piecesConnected.forEach((Piece p) -> {
            System.out.print(p.id + ", ");
        });

        System.out.print(" \n ");
    }

    /**
     * Método para preencher a lista de peças conectada
     * 
     * @param boardArray Piece[][] - matriz que representa o tabuleiro
     */
    public void fillPiecesConnected(Piece[][] boardArray) {
        // Checa se peça está conectada na posição cima (Up)
        if (currentOutputs.contains('u')) {
            try {
                Piece neighboorPiece = boardArray[boardLine - 1][boardColumn];
                auxConnectPieces(neighboorPiece, 'd');
            } catch (ArrayIndexOutOfBoundsException e) {
                /*
                 * System.out.println(" HERE 02 " + (boardLine+1) + boardColumn +
                 * "\n Execeção: " + e);
                 */ }
        }

        // Checa se peça está conectada na posição baixo (Down)
        if (currentOutputs.contains('d')) {
            try {
                Piece neighboorPiece = boardArray[boardLine + 1][boardColumn];
                auxConnectPieces(neighboorPiece, 'u');
            } catch (ArrayIndexOutOfBoundsException e) {
                /*
                 * System.out.println(" HERE 02 " + (boardLine+1) + boardColumn +
                 * "\n Execeção: " + e);
                 */ }
        }

        // Checa se peça está conectada na posição direita (Right)
        if (currentOutputs.contains('r')) {
            try {
                Piece neighboorPiece = boardArray[boardLine][boardColumn + 1];
                auxConnectPieces(neighboorPiece, 'l');
            } catch (ArrayIndexOutOfBoundsException e) {
                /*
                 * System.out.println(" HERE 02 " + (boardLine+1) + boardColumn +
                 * "\n Execeção: " + e);
                 */ }

        }

        // Checa se peça está conectada na posição esquerda (Left)
        if (currentOutputs.contains('l')) {
            try {
                Piece neighboorPiece = boardArray[boardLine][boardColumn - 1];
                auxConnectPieces(neighboorPiece, 'r');
            } catch (ArrayIndexOutOfBoundsException e) {
                /*
                 * System.out.println(" HERE 02 " + (boardLine+1) + boardColumn +
                 * "\n Execeção: " + e);
                 */ }
        }

    }

    /**
     * Método auxiliar que irá obter uma peça vizinha e verificar se está conectada
     * a Peça Principal (this)
     * 
     * @param neighboorPiece Piece - peça vizinha
     * @param auxDirection   char - direção que a peça vizinha deve ter para estar
     *                       conectada a Peça Principal (this)
     * 
     */
    public void auxConnectPieces(Piece neighboorPiece, char auxDirection) {
        List<Character> auxOutputs = neighboorPiece.getCurrentOutputs();
        List<Piece> auxPiecesConnected = neighboorPiece.getPiecesConnected();

        // Se entrar no if, quer dizer que estão conectados
        if (auxOutputs.contains(auxDirection)) {
            // Se uma peça ainda não está na lista conectadas da outra peça, adiciona

            System.out.println(" Peça " + this.id + " está conectada a peça " + neighboorPiece.id);

            if (!auxPiecesConnected.contains(this)) {
                neighboorPiece.addPiecesConnected(this);
            }

            if (!piecesConnected.contains(neighboorPiece)) {
                this.addPiecesConnected(neighboorPiece);
            }
        }
    }

    /**
     * Método trocar a posição de uma peça
     * 
     * @param pos        int - nova posição
     * @param boardArray Piece[][] - matriz que representar o tabuleiro
     */

}
