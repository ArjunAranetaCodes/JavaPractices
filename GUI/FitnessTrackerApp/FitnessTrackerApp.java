import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessTrackerApp {
    private JFrame frame;
    private JTextField workoutField;
    private JTextField stepsField;
    private JTextArea logArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            new FitnessTrackerApp().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Fitness Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        createInputPanel();
        createLogPanel();

        frame.setVisible(true);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        JLabel workoutLabel = new JLabel("Workout:");
        workoutField = new JTextField();
        JLabel stepsLabel = new JLabel("Daily Steps:");
        stepsField = new JTextField();
        JButton logButton = new JButton("Log Activity");

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logActivity();
            }
        });

        inputPanel.add(workoutLabel);
        inputPanel.add(workoutField);
        inputPanel.add(stepsLabel);
        inputPanel.add(stepsField);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(logButton);

        frame.add(inputPanel, BorderLayout.NORTH);
    }

    private void createLogPanel() {
        logArea = new JTextArea();
        logArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(logArea);

        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void logActivity() {
        String workout = workoutField.getText();
        String steps = stepsField.getText();

        if (!workout.isEmpty() && !steps.isEmpty()) {
            String logEntry = "Workout: " + workout + ", Steps: " + steps + "\n";
            logArea.append(logEntry);
            workoutField.setText("");
            stepsField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter both workout and steps information.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
