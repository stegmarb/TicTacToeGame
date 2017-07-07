import service.FieldVisualizer;

import java.util.Scanner;

public class GameStarter {
  public static void main(String[] args) {
    boolean winner = false;
    String currentPlayer = "p";
    Scanner scanner = new Scanner(System.in);
    String userCall = "";
    FieldVisualizer.visualizeField();
    while (!winner) {
      if (currentPlayer.equals("p")) {
        System.out.println("Player X's turn!");
      } else if (currentPlayer.equals("c")) {
        System.out.println("Player O's turn!");
      }
      userCall = scanner.nextLine();
      try {
        if (FieldVisualizer.isPlaceTaken(userCall.split(" ")[0], userCall.split(" ")[1])) {
          System.out.println("Please chose other field, because this one is already taken");
          FieldVisualizer.visualizeField();
        } else {
          FieldVisualizer.changeField(userCall.split(" ")[0], userCall.split(" ")[1], currentPlayer);
          FieldVisualizer.visualizeField();
          winner = FieldVisualizer.fiveInRow(currentPlayer);
          if (currentPlayer.equals("p")) {
            currentPlayer = "c";
          } else if (currentPlayer.equals("c")) {
            currentPlayer = "p";
          }
        }
      } catch (Exception e) {
        System.out.println("Please use only <column number> <row number> format");
      }
    }
    if (currentPlayer.equals("c")) {
      System.out.println("Player X Wins");
    } else if (currentPlayer.equals("p")) {
      System.out.println("Player O Wins");
    }
  }
}
