import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PasswordManagerApp extends JFrame {

    private Map<String, String> passwordDatabase;

    private JTextField websiteField;
    private JPasswordField passwordField;
    private JTextArea displayArea;

    public PasswordManagerApp() {
        passwordDatabase = new HashMap<>();

        setTitle("Password Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        layoutComponents();

        setVisible(true);
    }

    private void initComponents() {
        websiteField = new JTextField(20);
        passwordField = new JPasswordField(20);
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JButton addButton = new JButton("Add Password");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPassword();
            }
        });

        JButton retrieveButton = new JButton("Retrieve Password");
        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrievePassword();
            }
        });

        JButton clearButton = new JButton("Clear Display");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearDisplay();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Website:"));
        panel.add(websiteField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(addButton);
        panel.add(retrieveButton);
        panel.add(clearButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void layoutComponents() {
        setLayout(new FlowLayout());
    }

    private void addPassword() {
        String website = websiteField.getText();
        String password = new String(passwordField.getPassword());

        if (!website.isEmpty() && !password.isEmpty()) {
            passwordDatabase.put(website, password);
            displayPasswords();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both website and password.");
        }
    }

    private void retrievePassword() {
        String website = websiteField.getText();
        String storedPassword = passwordDatabase.get(website);

        if (storedPassword != null) {
            JOptionPane.showMessageDialog(this, "Password for " + website + ": " + storedPassword);
        } else {
            JOptionPane.showMessageDialog(this, "Password not found for " + website);
        }
    }

    private void displayPasswords() {
        StringBuilder passwords = new StringBuilder();
        for (Map.Entry<String, String> entry : passwordDatabase.entrySet()) {
            passwords.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        displayArea.setText(passwords.toString());
    }

    private void clearFields() {
        websiteField.setText("");
        passwordField.setText("");
    }

    private void clearDisplay() {
        displayArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordManagerApp());
    }
}
