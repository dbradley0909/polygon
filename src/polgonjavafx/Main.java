package polgonjavafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class Main extends Application {
  @Override 
  public void start(Stage primaryStage) {   
    
    Scene scene = new Scene(new MyPolygon(), 200, 200);
    primaryStage.setTitle("Polygon"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}

class MyPolygon extends Pane {
  private void paint() {
   
    Polygon polygon = new Polygon();
    polygon.setFill(Color.PINK);
    polygon.setStroke(Color.BLACK);
    ObservableList<Double> list = polygon.getPoints();
    
    double centerX = getWidth() / 2, centerY = getHeight() / 2;
    double radius = Math.min(getWidth(), getHeight()) * 0.4;

    
    for (int i = 0; i < 6; i++) {
      list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6)); 
      list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
    }     
    
    getChildren().clear(); // Clear pane
    getChildren().add(polygon); 
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paint();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paint();
  }
}