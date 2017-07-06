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
      for (int j = 0; j < currentField[i].length; j++) {
        if (j == 0) {
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
      currentField[rowNum + 1][columnNum * 2 + 1] = 1;
    } else if (player.equals("ai")) {
      currentField[rowNum + 1][columnNum * 2 + 1] = 0;
    }
  }

  public static boolean isPlaceTaken(String column, String row) {
    int columnNum = Integer.parseInt(column);
    int rowNum = Integer.parseInt(row);
    if (currentField[columnNum*2-1][rowNum*2-1] == 4) {
      return false;
    } else {
      return true;
    }
  }
}
