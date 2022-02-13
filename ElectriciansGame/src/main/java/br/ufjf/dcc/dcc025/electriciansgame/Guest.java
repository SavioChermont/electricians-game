package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.Scanner;

public class Guest implements User {
  private final String name = "Convidado";
  private final int id = 0;

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
    return true;
  }

  @Override
  public String getRole() {
    return "Guest";
  }

  public int getFunctions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("[1] - Jogar fase");
    System.out.println("[9] - Sair do jogo");
    return scan.nextInt();
  }
}
