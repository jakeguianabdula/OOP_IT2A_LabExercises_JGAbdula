import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame {
    private JPanel settingsPanel, problemPanel, messagePanel;
    private JTextField num1Field, num2Field, operatorField, answerField;
    private JButton startButton, submitButton, resetButton;
    private JComboBox<String> operatorCombo, levelCombo;
    private JLabel messageLabel, scoreLabel;
    private int num1, num2, correctAnswer;
    private String selectedOperator;
    private Random random = new Random();
    private int correctCount = 0, incorrectCount = 0;
    private boolean problemActive = false;

    private String[] messages = {
        "Great job! Keep it up!",
        "Oops, not quite right. Try again!",
        "You're doing awesome!",
        "Think carefully!",
        "Math is fun, right?"
    };

    public ArithmeticGame() {
        setTitle("Math Challenge Game");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Settings Panel
        settingsPanel = new JPanel();
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Game Settings"));
        settingsPanel.setLayout(new FlowLayout());

        operatorCombo = new JComboBox<>(new String[]{"Addition (+)", "Subtraction (-)", "Multiplication (*)", "Division (/)", "Modulo (%)"});
        levelCombo = new JComboBox<>(new String[]{"Easy (1-50)", "Medium (50-150)", "Hard (150-300)"});

        startButton = new JButton("Start Game");
        resetButton = new JButton("Reset Score");

        settingsPanel.add(new JLabel("Operator:"));
        settingsPanel.add(operatorCombo);
        settingsPanel.add(new JLabel("Level:"));
        settingsPanel.add(levelCombo);
        settingsPanel.add(startButton);
        settingsPanel.add(resetButton);

        // Problem Panel
        problemPanel = new JPanel();
        problemPanel.setBorder(BorderFactory.createTitledBorder("Solve the Problem"));
        problemPanel.setLayout(new FlowLayout());

        num1Field = new JTextField(5);
        num1Field.setEditable(false);
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        num1Field.setFont(new Font("Arial", Font.BOLD, 30));

        operatorField = new JTextField(3);
        operatorField.setEditable(false);
        operatorField.setHorizontalAlignment(JTextField.CENTER);
        operatorField.setFont(new Font("Arial", Font.BOLD, 30));

        num2Field = new JTextField(5);
        num2Field.setEditable(false);
        num2Field.setHorizontalAlignment(JTextField.CENTER);
        num2Field.setFont(new Font("Arial", Font.BOLD, 30));

        answerField = new JTextField(10);
        answerField.setFont(new Font("Arial", Font.PLAIN, 25));

        submitButton = new JButton("Submit Answer");

        scoreLabel = new JLabel("Correct: 0 | Incorrect: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));

        problemPanel.add(num1Field);
        problemPanel.add(operatorField);
        problemPanel.add(num2Field);
        problemPanel.add(new JLabel(" = "));
        problemPanel.add(answerField);
        problemPanel.add(submitButton);
        problemPanel.add(scoreLabel);

        // Message Panel
        messagePanel = new JPanel();
        messagePanel.setBorder(BorderFactory.createTitledBorder("Feedback"));
        messagePanel.setLayout(new BorderLayout());

        messageLabel = new JLabel("Select settings and click Start Game!", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));

        messagePanel.add(messageLabel, BorderLayout.CENTER);

        // Add panels to frame
        add(settingsPanel, BorderLayout.NORTH);
        add(problemPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        // Event Listeners
        startButton.addActionListener(e -> startGame());
        submitButton.addActionListener(e -> checkAnswer());
        resetButton.addActionListener(e -> resetScore());

        setVisible(true);
    }

    private void startGame() {
        generateProblem();
        answerField.setText("");
        messageLabel.setText(messages[random.nextInt(messages.length)]);
        problemActive = true;
    }

    private void generateProblem() {
        int min = 1, max = 50;
        String level = (String) levelCombo.getSelectedItem();
        if ("Medium (50-150)".equals(level)) {
            min = 50; max = 150;
        } else if ("Hard (150-300)".equals(level)) {
            min = 150; max = 300;
        }

        num1 = random.nextInt(max - min + 1) + min;
        num2 = random.nextInt(max - min + 1) + min;

        String operator = (String) operatorCombo.getSelectedItem();
        if ("Addition (+)".equals(operator)) {
            selectedOperator = "+";
            correctAnswer = num1 + num2;
        } else if ("Subtraction (-)".equals(operator)) {
            selectedOperator = "-";
            correctAnswer = num1 - num2;
        } else if ("Multiplication (*)".equals(operator)) {
            selectedOperator = "*";
            correctAnswer = num1 * num2;
        } else if ("Division (/)".equals(operator)) {
            selectedOperator = "/";
            // Ensure num2 is not zero and num1 is divisible by num2
            do {
                num2 = random.nextInt(max) + 1;
            } while (num2 == 0 || num1 % num2 != 0);
            correctAnswer = num1 / num2;
        } else if ("Modulo (%)".equals(operator)) {
            selectedOperator = "%";
            // Ensure num2 is not zero
            while (num2 == 0) {
                num2 = random.nextInt(max - min + 1) + min;
            }
            correctAnswer = num1 % num2;
        }

        // For subtraction and modulo, ensure num1 > num2
        if (("-".equals(selectedOperator) || "%".equals(selectedOperator)) && num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
            if ("-".equals(selectedOperator)) {
                correctAnswer = num1 - num2;
            } else if ("%".equals(selectedOperator)) {
                correctAnswer = num1 % num2;
            }
        }

        num1Field.setText(String.valueOf(num1));
        operatorField.setText(selectedOperator);
        num2Field.setText(String.valueOf(num2));
    }

    private void checkAnswer() {
        if (!problemActive) return;

        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            problemActive = false;
            if (userAnswer == correctAnswer) {
                correctCount++;
                messageLabel.setText("Correct! Well done.");
            } else {
                incorrectCount++;
                messageLabel.setText("Incorrect. The answer was " + correctAnswer + ".");
            }
            updateScore();
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    private void updateScore() {
        scoreLabel.setText("Correct: " + correctCount + " | Incorrect: " + incorrectCount);
    }

    private void resetScore() {
        correctCount = 0;
        incorrectCount = 0;
        updateScore();
        messageLabel.setText("Score reset. Select settings and start a new game!");
        num1Field.setText("");
        operatorField.setText("");
        num2Field.setText("");
        answerField.setText("");
        problemActive = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArithmeticGame());
    }
}
