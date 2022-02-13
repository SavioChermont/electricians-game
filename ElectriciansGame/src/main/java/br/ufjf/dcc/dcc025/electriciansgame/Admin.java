package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.Scanner;

public class Admin implements User {
  private String name;
  private int id;
  private String userName;
  private String password;

  Admin(String name, String userName, String password) {
    this.name = name;
    this.numberAdmins++;
    this.id = numberAdmins;
    this.userName = userName;
    this.password = password;
  }

  public static int numberAdmins = 0;

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
    return "Admin";
  }

  public int getFunctions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("[1] - Criar fase");
    System.out.println("[1] - Ver records");
    System.out.println("[8] - Auto-deletar");
    System.out.println("[9] - Sair do jogo");
    return scan.nextInt();
  }
}
