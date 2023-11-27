import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LambdaEvent7 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 300, 200);

        pane.setOnKeyTyped(e -> System.out.println("Key Typed: " + e.getCharacter()));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.show();
        pane.requestFocus();
    }
}
