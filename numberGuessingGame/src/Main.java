import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {
    private JLabel lblRange, lblGuess, lblResult;
    private JTextField txtRange, txtGuess;
    private JButton btnGuess;

    private int lower, upper;
    private int secretNumber;

    public Main() {
        setTitle("Random Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lblRange = new JLabel("Enter the range (e.g., 1-100):");
        add(lblRange);

        txtRange = new JTextField(10);
        add(txtRange);

        lblGuess = new JLabel("Enter your guess:");
        add(lblGuess);

        txtGuess = new JTextField(10);
        add(txtGuess);

        btnGuess = new JButton("Guess");
        add(btnGuess);

        lblResult = new JLabel("");
        add(lblResult);

        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
    }

    private void playGame() {
        String rangeInput = txtRange.getText();
        String[] rangeValues = rangeInput.split("-");

        try {
            lower = Integer.parseInt(rangeValues[0]);
            upper = Integer.parseInt(rangeValues[1]);

            // Generate a random number within the given range
            secretNumber = generateRandomNumber(lower, upper);

            int guess = Integer.parseInt(txtGuess.getText());

            if (guess == secretNumber) {
                lblResult.setText("Congratulations! You guessed the correct number.");
            } else if (guess < secretNumber) {
                lblResult.setText("Too low! Try a higher number.");
            } else {
                lblResult.setText("Too high! Try a lower number.");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid range or guess. Please enter valid integers.");
        }
    }

    private int generateRandomNumber(int lower, int upper) {
        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main game = new Main();
                game.setVisible(true);
            }
        });
    }
}