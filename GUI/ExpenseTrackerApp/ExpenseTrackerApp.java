import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ExpenseTrackerApp extends JFrame {
    private JTextField expenseTextField;
    private JComboBox<String> categoryComboBox;
    private JButton addExpenseButton;
    private JTextArea expenseListTextArea;
    private Map<String, Double> expenseMap;

    public ExpenseTrackerApp() {
        super("Expense Tracker");

        expenseMap = new HashMap<>();

        // Initialize components
        expenseTextField = new JTextField(15);
        categoryComboBox = new JComboBox<>(new String[]{"Food", "Utilities", "Entertainment", "Others"});
        addExpenseButton = new JButton("Add Expense");
        expenseListTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(expenseListTextArea);

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(new JLabel("Expense:"));
        add(expenseTextField);
        add(new JLabel("Category:"));
        add(categoryComboBox);
        add(addExpenseButton);
        add(scrollPane);

        // Add action listeners
        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void addExpense() {
        String expenseDescription = expenseTextField.getText().trim();
        if (expenseDescription.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid expense description.");
            return;
        }

        double expenseAmount;
        try {
            expenseAmount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the expense amount:"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.");
            return;
        }

        String category = (String) categoryComboBox.getSelectedItem();

        // Update the expense map
        if (expenseMap.containsKey(category)) {
            expenseMap.put(category, expenseMap.get(category) + expenseAmount);
        } else {
            expenseMap.put(category, expenseAmount);
        }

        // Update the expense list text area
        updateExpenseListTextArea();

        // Clear the input fields
        expenseTextField.setText("");
    }

    private void updateExpenseListTextArea() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Category\t\tAmount\n");
        stringBuilder.append("-----------------------------\n");
        for (Map.Entry<String, Double> entry : expenseMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("\t\t").append(entry.getValue()).append("\n");
        }
        expenseListTextArea.setText(stringBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExpenseTrackerApp());
    }
}
