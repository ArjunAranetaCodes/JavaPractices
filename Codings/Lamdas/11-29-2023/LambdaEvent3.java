import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LambdaEvent3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Event Handling");

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setFocusable(true);
    }
}
