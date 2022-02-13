package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.Scanner;

public class Player implements User {
  private String name;
  private int id;
  private String userName;
  private String password;

  Player(String name, String userName, String password) {
    this.name = name;
    this.numberPlayers++;
    this.id = numberPlayers;
    this.userName = userName;
    this.password = password;
  }

  public static int numberPlayers = 0;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public boolean validateLogin(String userName, String password) {
    return userName.equals(this.userName) && password.equals(this.password);
  }

  @Override
  public String getRole() {
    return "Player";
  }

  public int getFunctions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("[1] - Jogar fase");
    System.out.println("[2] - Ver records");
    System.out.println("[8] - Auto-deletar");
    System.out.println("[9] - Sair do jogo");
    return scan.nextInt();
  }
}
