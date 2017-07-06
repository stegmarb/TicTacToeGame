import service.FieldVisualizer;

import java.util.Scanner;

public class GameStarter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = 0;
    String userCall = "";
    FieldVisualizer.visualizeField();
    for (int j = 0; j < 5; j++) {
      userCall = scanner.nextLine();
      if (FieldVisualizer.isPlaceTaken(userCall.split(" ")[0], userCall.split(" ")[1])) {
        System.out.println("Please chose other field, because this one is already taken");
        FieldVisualizer.visualizeField();
      } else {
        FieldVisualizer.changeField(userCall.split(" ")[0], userCall.split(" ")[1], "p");
        FieldVisualizer.visualizeField();
      }
    }
  }
}
