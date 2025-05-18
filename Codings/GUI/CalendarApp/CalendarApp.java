import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CalendarApp extends JFrame {
    private Map<String, String> events;

    public CalendarApp() {
        events = new HashMap<>();

        // Initialize the GUI components
        initComponents();

        // Set frame properties
        setTitle("Calendar App");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        // Create components
        JTextArea textArea = new JTextArea();
        JButton addButton = new JButton("Add Event");

        // Create a calendar panel
        JPanel calendarPanel = new JPanel(new GridLayout(6, 7));

        // Add day labels
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            calendarPanel.add(new JLabel(day, JLabel.CENTER));
        }

        // Add day buttons
        for (int i = 1; i <= 42; i++) {
            JButton dayButton = new JButton();
            dayButton.addActionListener(new DayButtonListener());
            calendarPanel.add(dayButton);
        }

        // Add action listener to the "Add Event" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = JOptionPane.showInputDialog(CalendarApp.this, "Enter date (YYYY-MM-DD):");
                if (date != null && !date.isEmpty()) {
                    String event = JOptionPane.showInputDialog(CalendarApp.this, "Enter event:");
                    if (event != null && !event.isEmpty()) {
                        events.put(date, event);
                        updateCalendar();
                    }
                }
            }
        });

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(textArea, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }

    private void updateCalendar() {
        // Update day buttons with events
        Container container = getContentPane();
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton dayButton = (JButton) component;
                String text = dayButton.getText();
                if (!text.isEmpty()) {
                    String event = events.get(text);
                    dayButton.setToolTipText(event);
                    dayButton.setForeground(Color.BLUE);
                }
            }
        }
    }

    private class DayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String date = source.getText();
            String event = events.get(date);
            String message = (event != null) ? "Events for " + date + ":\n" + event : "No events for " + date;
            JOptionPane.showMessageDialog(CalendarApp.this, message);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalendarApp();
            }
        });
    }
}
