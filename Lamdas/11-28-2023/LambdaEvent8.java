import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LambdaEvent8 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click me");

        // Handling button click using lambda
        button.setOnAction(e -> System.out.println("Button clicked!"));

        // Handling mouse click using lambda
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Mouse Clicked"));

        // Handling mouse enter using lambda
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> System.out.println("Mouse Entered"));

        // Combining multiple handlers using lambda expression
        button.addEventHandler(ActionEvent.ACTION, (EventHandler<ActionEvent>) e -> {
            System.out.println("Event Type: " + e.getEventType());
            e.consume(); // Consume the event to prevent further handling
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
