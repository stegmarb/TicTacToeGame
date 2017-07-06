package service;

import model.Field;

import java.util.HashMap;

public class FieldVisualizer {

  private static Field field = new Field();
  private static int[][] currentField = field.getField();
  private static HashMap decoder = field.getDecoder();

  public static void visualizeField() {
    System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
    System.out.println("  _ _ _ _ _ _ _ _ _ _");
    for (int i = 0; i < currentField.length; i++) {
      for (int j = -1; j < currentField[i].length - 1; j++) {
        if (j == -1) {
          System.out.print(i + "|");
        } else {
          System.out.print(decoder.get(currentField[i][j]) + "|");
        }
      }
      System.out.println();
    }
    System.out.println("  ¯ ¯ ¯ ¯ ¯ ¯ ¯ ¯ ¯ ¯");
  }

  public static void changeField(String column, String row, String player) {
    int columnNum = Integer.parseInt(column);
    int rowNum = Integer.parseInt(row);
    if (player.equals("p")) {
      currentField[rowNum][columnNum] = 1;
    } else if (player.equals("ai")) {
      currentField[rowNum][columnNum] = 2;
    }
  }

  public static boolean isPlaceTaken(String column, String row) {
    int columnNum = Integer.parseInt(column);
    int rowNum = Integer.parseInt(row);
    if (currentField[rowNum][columnNum] == 0) {
      System.out.println(false);
      return false;
    } else {
      System.out.println(true);
      return true;
    }
  }
}
