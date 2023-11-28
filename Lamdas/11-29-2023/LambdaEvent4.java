import javax.swing.*;
import java.awt.event.ActionEvent;

public class LambdaEvent4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Event Handling");
        JButton button = new JButton("Click me");

        Timer timer = new Timer(1000, (ActionEvent e) -> System.out.println("Timer Tick"));
        timer.start();

        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
