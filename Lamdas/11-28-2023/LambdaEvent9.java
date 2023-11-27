import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LambdaEvent9 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();

        // Using lambda for change listener
        textField.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("Text changed: " + newValue));

        StackPane root = new StackPane();
        root.getChildren().add(textField);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
