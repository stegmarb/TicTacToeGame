import service.FieldVizualizer;

public class GameStarter {
  public static void main(String[] args) {
    FieldVizualizer.changeField(5,5, "p");
    FieldVizualizer.changeField(6,6, "ai");
    FieldVizualizer.changeField(5,6, "p");
    FieldVizualizer.visualizeField();
  }
}
