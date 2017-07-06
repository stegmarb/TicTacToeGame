package service;

import model.Field;

import java.util.HashMap;

public class FieldVizualizer {

  private static Field field = new Field();
  private static int[][] currentField = field.getField();
  private static HashMap decoder = field.getDecoder();

  public static void visualizeField() {
    for (int i = 0; i < currentField.length; i++) {
      for (int j = 0; j < currentField[i].length; j++) {
        System.out.print(decoder.get(currentField[i][j]));
      }
      System.out.println();
    }
  }

  public static void changeField(int column, int row, String player) {
    if (player.equals("p")) {
    currentField[row][column*2-1] = 1;
  } else if (player.equals("ai")){
    currentField[row][column*2-1] = 0;
    }
  }
}
