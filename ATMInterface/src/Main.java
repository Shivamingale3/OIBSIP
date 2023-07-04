import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField pinField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton balanceButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton transferButton;
    private JButton historyButton;
    private JButton exitButton;

    public Main() {
        setTitle("ATM Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // PIN label and text field
        JLabel pinLabel = new JLabel("Enter PIN: ");
        pinField = new JTextField(10);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Enter Password: ");
        passwordField = new JPasswordField(10);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Balance button
        balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(this);

        // Withdraw button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        // Deposit button
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        // Transfer button
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(this);

        // Transaction history button
        historyButton = new JButton("Transaction History");
        historyButton.addActionListener(this);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        // Add components to the frame
        add(pinLabel);
        add(pinField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(balanceButton);
        add(withdrawButton);
        add(depositButton);
        add(transferButton);
        add(historyButton);
        add(exitButton);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String pin = pinField.getText();
            String password = new String(passwordField.getPassword());

            // Perform login verification here
            // You can check the entered PIN and password against a database or other authentication mechanism

            // For now, let's just display a message dialog
            JOptionPane.showMessageDialog(this, "Logged in successfully!");
        } else if (e.getSource() == balanceButton) {
            // Retrieve account balance from the database or another data source
            double balance = 5000.0; // Example dummy value
            JOptionPane.showMessageDialog(this, "Your account balance is: $" + balance);
        } else if (e.getSource() == withdrawButton) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter the withdrawal amount:");

            if (amountStr != null && !amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);

                // Perform withdrawal logic here
                // Deduct the specified amount from the user's account

                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        } else if (e.getSource() == depositButton) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter the deposit amount:");

            if (amountStr != null && !amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);

                // Perform deposit logic here
                // Add the specified amount to the user's accountJOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        } else if (e.getSource() == transferButton) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter the transfer amount:");

            if (amountStr != null && !amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);

                // Perform transfer logic here
                // Deduct the specified amount from the user's account and transfer it to another account

                JOptionPane.showMessageDialog(this, "Transfer successful!");
            }
        } else if (e.getSource() == historyButton) {
            // Fetch transaction history from the database or another data source
            String[] transactions = {"Transaction 1", "Transaction 2", "Transaction 3"}; // Example dummy values

            StringBuilder sb = new StringBuilder();
            for (String transaction : transactions) {
                sb.append(transaction).append("\n");
            }

            JOptionPane.showMessageDialog(this, "Transaction History:\n" + sb.toString());
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main atmInterface = new Main();
            atmInterface.setVisible(true);
        });
    }
}