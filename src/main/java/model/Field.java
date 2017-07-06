package model;

import java.util.HashMap;
import java.util.Map;

public class Field {
  private int[] [] field = {
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

  private HashMap decoder = new HashMap<Integer, String>() {
    {
      put(0, " ");
      put(1, "X");
      put(2, "O");
    }
  };

  public Field () {
     }

  public int[][] getField() {
    return field;
  }

  public void setField(int[][] field) {
    this.field = field;
  }

  public HashMap getDecoder() {
    return decoder;
  }

  public void setDecoder(HashMap decoder) {
    this.decoder = decoder;
  }
}
