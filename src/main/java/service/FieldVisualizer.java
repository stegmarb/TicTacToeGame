package service;

import model.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FieldVisualizer {

  private static Field field = new Field();
  private static int[][] currentField = field.getField();
  private static HashMap decoder = field.getDecoder();
  public static int count = 0;

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
    } else if (player.equals("c")) {
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

  public static boolean isNotAllowed(int column, int row) {
    if (column < 0 || column > 9 || row < 0 || row > 9) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean fiveInRow(String player) {
    boolean finalAnswer = false;
    boolean[] results = new boolean[4];
    for (int i = 0; i < currentField.length; i++) {
      for (int j = 0; j < currentField[i].length; j++) {
        if (isThereSignHorizontal(j, i, player) || isThereSignVertical(j, i, player) || isThereSignNegativeDiagonal(j, i, player) || isThereSignPositiveDiagonal(j, i, player)) {
          finalAnswer = true;
        }
      }
    }
    return finalAnswer;
  }

  public static boolean isPlayer(int column, int row, String player) {
    if (player.equals("p") && currentField[row][column] == 1) {
      return true;
    } else if (player.equals("c") && currentField[row][column] == 2) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isThereSignHorizontal(int column, int row, String player) {
    int counter = 0;
    boolean finalAnswer = false;
    boolean[] result = new boolean[5];
    for (int i = 0; i < 5; i++) {
      if (isNotAllowed(column + i, row)) {
        result[i] = false;
      } else if (isPlayer(column + i, row, player)) {
        result[i] = true;
      } else {
        result[i] = false;
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        counter++;
      }
    }
    return counter == 5;
  }

  public static boolean isThereSignVertical(int column, int row, String player) {
    int counter = 0;
    boolean finalAnswer = false;
    boolean[] result = new boolean[5];
    for (int i = 0; i < 5; i++) {
      if (isNotAllowed(column, row + i)) {
        result[i] = false;
      } else if (isPlayer(column, row + i, player)) {
        result[i] = true;
      } else {
        result[i] = false;
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        counter++;
      }
    }
    return counter == 5;
  }

  public static boolean isThereSignPositiveDiagonal(int column, int row, String player) {
    int counter = 0;
    boolean finalAnswer = false;
    boolean[] result = new boolean[5];
    for (int i = 0; i < 5; i++) {
      if (isNotAllowed(column + i, row - i)) {
        result[i] = false;
      } else if (isPlayer(column + i, row - i, player)) {
        result[i] = true;
      } else {
        result[i] = false;
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        counter++;
      }
    }
    return counter == 5;
  }

  public static boolean isThereSignNegativeDiagonal(int column, int row, String player) {
    int counter = 0;
    boolean finalAnswer = false;
    boolean[] result = new boolean[5];
    for (int i = 0; i < 5; i++) {
      if (isNotAllowed(column + i, row + i)) {
        result[i] = false;
      } else if (isPlayer(column + i, row + i, player)) {
        result[i] = true;
      } else {
        result[i] = false;
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        counter++;
      }
    }
    return counter == 5;
  }
}

