import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LambdaEvent5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click me");
        button.setOnAction(e -> System.out.println("Button clicked!"));

        primaryStage.setScene(new Scene(button, 200, 200));
        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.show();
    }
}
