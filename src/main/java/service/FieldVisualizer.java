package service;

import model.Field;

import java.util.HashMap;

public class FieldVisualizer {

  private static Field field = new Field();
  private static int[][] currentField = field.getField();
  private static HashMap decoder = field.getDecoder();

  public static void visualizeField() {
    System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
    for (int i = 0; i < currentField.length; i++) {
      for (int j = 0; j < currentField[i].length; j++) {
        if (i != 0 && i != 11 && j == 0) {
          System.out.print((i-1) + "" + decoder.get(currentField[i][j]));
        } else {
          System.out.print(decoder.get(currentField[i][j]));
        }
      }
      System.out.println();
    }
  }

  public static void changeField(int column, int row, String player) {
    if (player.equals("p")) {
    currentField[row+1][column*2+1] = 1;
  } else if (player.equals("ai")){
    currentField[row+1][column*2+1] = 0;
    }
  }
}
