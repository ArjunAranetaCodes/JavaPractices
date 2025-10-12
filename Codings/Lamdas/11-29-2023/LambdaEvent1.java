import javax.swing.JButton;
import javax.swing.JFrame;

public class LambdaEvent1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Event Handling");
        JButton button = new JButton("Click me");

        button.addActionListener(e -> System.out.println("Button clicked!"));

        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
