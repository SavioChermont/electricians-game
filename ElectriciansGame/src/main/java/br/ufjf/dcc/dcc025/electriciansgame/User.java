package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.*;

public interface User {
  public static User getClassByRole(String role, String name, String userName, String password) {
    switch (role) {
      case "Admin":
        return new Admin(name, userName, password);
      case "Player":
        return new Player(name, userName, password);
      case "Guest":
        return new Guest();
    }
    return null;
  }

  public String getRole();

  public String getName();

  public int getId();

  public boolean validateLogin(String userName, String password);

  public int getFunctions();
}
