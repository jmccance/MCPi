package jmccance;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import jmccance.view.MCPiWindow;

/**
 * Hello world!
 *
 */
public class App extends Application {

  public static void main(String... args) {
    Application.launch(args);
  }

  @Override
  public void start(final Stage primaryStage) {
    final int WIDTH = 800;
    final int HEIGHT = 600;

    final Group root = new Group();
    final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

}
