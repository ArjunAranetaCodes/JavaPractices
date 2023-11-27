import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LambdaEvent6 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 300, 200);

        pane.setOnMouseClicked(e -> System.out.println("Mouse Clicked at: " + e.getSceneX() + ", " + e.getSceneY()));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.show();
    }
}
