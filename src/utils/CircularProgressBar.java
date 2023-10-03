package utils;

import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

public class CircularProgressBar extends StackPane {
  private ProgressBar progressBar;

  public CircularProgressBar() {
    progressBar = new ProgressBar();
    getChildren().add(progressBar);
    progressBar.setPrefSize(200, 200);
    setStyle(
        "-fx-background-color: transparent;" +
            "-fx-padding: 0px;" +
            "-fx-border-width: 0px;");
    progressBar.setStyle(
        "-fx-background-color: transparent;" +
            "-fx-padding: 0px;" +
            "-fx-border-width: 0px;");
  }

  public ProgressBar getProgressBar() {
    return progressBar;
  }
}
