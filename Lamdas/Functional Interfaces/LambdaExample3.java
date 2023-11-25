import javax.swing.JButton;
import javax.swing.JFrame;

public class LambdaExample3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Example");
        JButton button = new JButton("Click Me");

        button.addActionListener(e -> System.out.println("Button clicked!"));

        frame.getContentPane().add(button);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
