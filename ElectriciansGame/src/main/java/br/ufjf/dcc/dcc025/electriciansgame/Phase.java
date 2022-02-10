/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

/**
 *
 * @author savio
 */
import java.util.*;

public class Phase {
  private int exitPosition;
  private int initPosition;
  private Board board;
  private String level;
  private String name;
  // --------- Constructor ---------

  public Phase(String name, String level, int exitPosition, int initPosition) {
    this.name = name;
    this.level = level;
    this.initPosition = initPosition;
    this.exitPosition = exitPosition;
    this.board = new Board();
  }

  // --------- Getters ---------
  public int getExitPosition() {
    return exitPosition;
  }

  public int getInitPosition() {
    return initPosition;
  }

  // --------- Setters ---------
  public boolean setExitPosition(int position) {
    if (position >= 0 && position < Board.BOARD_LENGTH)
      exitPosition = position;
    else
      return false;
    return true;
  }

  public boolean setInitPosition(int position) {
    if (position >= 0 && position < Board.BOARD_LENGTH)
      initPosition = position;
    else
      return false;
    return true;
  }

  /* ----------- Others Methods ---------- */
  public void createGame(List<Piece> pieces, List<Integer> lines, List<Integer> columns) {
    for (int i = 0; i < pieces.size(); i++)
      this.board.insertPiece(pieces.get(i), lines.get(i), columns.get(i));
  }

  public String getName() {
    return this.name;
  }

  public String getLevel() {
    return this.level;
  }

  public Board getBoard() {
    return this.board;
  }
}
