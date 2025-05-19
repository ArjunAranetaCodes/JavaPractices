import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {

    private JTextField amountTextField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultLabel;

    private static final double USD_TO_EUR_RATE = 0.85;
    private static final double USD_TO_GBP_RATE = 0.73;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();

        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 80, 25);
        panel.add(amountLabel);

        amountTextField = new JTextField();
        amountTextField.setBounds(100, 20, 150, 25);
        panel.add(amountTextField);

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyLabel.setBounds(20, 60, 120, 25);
        panel.add(fromCurrencyLabel);

        String[] currencies = {"USD", "EUR", "GBP"};
        fromCurrencyComboBox = new JComboBox<>(currencies);
        fromCurrencyComboBox.setBounds(150, 60, 100, 25);
        panel.add(fromCurrencyComboBox);

        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyLabel.setBounds(20, 100, 120, 25);
        panel.add(toCurrencyLabel);

        toCurrencyComboBox = new JComboBox<>(currencies);
        toCurrencyComboBox.setBounds(150, 100, 100, 25);
        panel.add(toCurrencyComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(280, 60, 100, 25);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        panel.add(convertButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 140, 300, 25);
        panel.add(resultLabel);

        add(panel);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
            double result = convert(amount, fromCurrency, toCurrency);
            resultLabel.setText("Result: " + amount + " " + fromCurrency + " = " + result + " " + toCurrency);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convert(double amount, String fromCurrency, String toCurrency) {
        double rate = 1.0; // Default to same currency
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            rate = USD_TO_EUR_RATE;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            rate = USD_TO_GBP_RATE;
        } // Add more conversion rates as needed

        return amount * rate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterApp();
            }
        });
    }
}
