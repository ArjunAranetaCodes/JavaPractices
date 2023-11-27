import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LambdaEvent10 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> options =
                FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");

        ComboBox<String> comboBox = new ComboBox<>(options);

        // Using lambda for selection change listener
        comboBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        System.out.println("Selected: " + newValue));

        StackPane root = new StackPane();
        root.getChildren().add(comboBox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Lambda Event Handling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
