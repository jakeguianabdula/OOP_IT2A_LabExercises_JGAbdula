import javax.swing.*;
import javax.swing.border.*;
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
        // Use system L&F for a cleaner look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Ensure label text is visible on the dark UI: set default JLabel color
        UIManager.put("Label.foreground", new Color(230, 230, 230));
        // Make combo box text clearly visible
        UIManager.put("ComboBox.foreground", Color.BLACK);
        UIManager.put("ComboBox.background", Color.WHITE);

        setTitle("Math Challenge Game");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Settings Panel
        settingsPanel = new JPanel();
        settingsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(60, 63, 65), 2),
            "Game Settings",
            0, 0,
            new Font("SansSerif", Font.BOLD, 14),
            Color.WHITE
        ));
        settingsPanel.setLayout(new FlowLayout());
        settingsPanel.setBackground(new Color(40, 44, 52)); // dark panel bg

        operatorCombo = new JComboBox<>(new String[]{"Addition (+)", "Subtraction (-)", "Multiplication (*)", "Division (/)", "Modulo (%)"});
        levelCombo = new JComboBox<>(new String[]{"Easy (1-50)", "Medium (50-150)", "Hard (150-300)"});

        // ensure combo boxes text is visible on the dark theme
        operatorCombo.setForeground(Color.BLACK);
        operatorCombo.setBackground(Color.WHITE);
        operatorCombo.setOpaque(true);
        levelCombo.setForeground(Color.BLACK);
        levelCombo.setBackground(Color.WHITE);
        levelCombo.setOpaque(true);

        // Update displayed problem immediately when level OR operator selection changes
        levelCombo.addActionListener(e -> {
            generateProblem();
            problemActive = false;
        });
        operatorCombo.addActionListener(e -> {
            generateProblem();
            problemActive = false;
        });

        startButton = new JButton("Start Game");
        resetButton = new JButton("Reset Score");

        // Button styling (ensure text is visible)
        startButton.setBackground(new Color(0, 153, 76));
        startButton.setForeground(Color.WHITE);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setFont(startButton.getFont().deriveFont(Font.BOLD, 14f));

        resetButton.setBackground(new Color(220, 120, 20));
        resetButton.setForeground(Color.WHITE);
        resetButton.setOpaque(true);
        resetButton.setBorderPainted(false);
        resetButton.setFocusPainted(false);
        resetButton.setFont(resetButton.getFont().deriveFont(Font.BOLD, 14f));

        settingsPanel.add(new JLabel("Operator:") {{ setForeground(Color.WHITE); }});
        settingsPanel.add(operatorCombo);
        settingsPanel.add(new JLabel("Level:") {{ setForeground(Color.WHITE); }});
        settingsPanel.add(levelCombo);
        settingsPanel.add(startButton);
        settingsPanel.add(resetButton);

        // Problem Panel
        problemPanel = new JPanel();
        problemPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(60, 63, 65), 2),
            "Solve the Problem",
            0, 0,
            new Font("SansSerif", Font.BOLD, 14),
            Color.WHITE
        ));
        problemPanel.setLayout(new FlowLayout());
        problemPanel.setBackground(new Color(20, 24, 40));

        num1Field = new JTextField(5);
        num1Field.setEditable(false);
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        num1Field.setFont(new Font("Arial", Font.BOLD, 34));
        num1Field.setBackground(new Color(250, 250, 240));
        num1Field.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),2));

        operatorField = new JTextField(3);
        operatorField.setEditable(false);
        operatorField.setHorizontalAlignment(JTextField.CENTER);
        operatorField.setFont(new Font("Arial", Font.BOLD, 34));
        operatorField.setBackground(new Color(230, 240, 255));
        operatorField.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),2));

        num2Field = new JTextField(5);
        num2Field.setEditable(false);
        num2Field.setHorizontalAlignment(JTextField.CENTER);
        num2Field.setFont(new Font("Arial", Font.BOLD, 34));
        num2Field.setBackground(new Color(250, 250, 240));
        num2Field.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),2));

        answerField = new JTextField(10);
        answerField.setFont(new Font("Arial", Font.PLAIN, 25));
        answerField.setBorder(BorderFactory.createMatteBorder(2,2,2,2, new Color(120,120,160)));

        submitButton = new JButton("Submit Answer");
        submitButton.setBackground(new Color(10, 120, 200));
        submitButton.setForeground(Color.WHITE);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);

        scoreLabel = new JLabel("Correct: 0 | Incorrect: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scoreLabel.setForeground(new Color(255, 215, 0));

        // replace inline JLabel(" = ") so we can ensure it's visible
        JLabel equalsLabel = new JLabel(" = ");
        equalsLabel.setForeground(Color.WHITE);
        equalsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        problemPanel.add(num1Field);
        problemPanel.add(operatorField);
        problemPanel.add(num2Field);
        problemPanel.add(equalsLabel);
        problemPanel.add(answerField);
        problemPanel.add(submitButton);
        problemPanel.add(scoreLabel);

        // Message Panel
        messagePanel = new JPanel();
        messagePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(60, 63, 65), 2),
            "Feedback",
            0, 0,
            new Font("SansSerif", Font.BOLD, 14),
            Color.WHITE
        ));
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setBackground(new Color(15, 18, 30));

        messageLabel = new JLabel("Select settings and click Start Game!", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        messageLabel.setForeground(new Color(180, 200, 255));
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(12, 15, 25));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        messagePanel.add(messageLabel, BorderLayout.CENTER);

        // Add panels to frame
        add(settingsPanel, BorderLayout.NORTH);
        add(problemPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        // Event Listeners
        startButton.addActionListener(e -> startGame());
        submitButton.addActionListener(e -> checkAnswer());
        resetButton.addActionListener(e -> resetScore());

        // show an initial problem based on default settings
        generateProblem();

        setLocationRelativeTo(null);
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
            // ensure meaningful subtraction (non-negative)
            if (num1 < num2) { int t = num1; num1 = num2; num2 = t; }
            correctAnswer = num1 - num2;
        } else if ("Multiplication (*)".equals(operator)) {
            selectedOperator = "*";
            correctAnswer = num1 * num2;
        } else if ("Division (/)".equals(operator)) {
            selectedOperator = "/";
            // Ensure num2 is not zero and num1 is divisible by num2, pick both in range
            do {
                num1 = random.nextInt(max - min + 1) + min;
                num2 = random.nextInt(max - min + 1) + min;
            } while (num2 == 0 || num1 % num2 != 0);
            correctAnswer = num1 / num2;
        } else if ("Modulo (%)".equals(operator)) {
            selectedOperator = "%";
            // Ensure num2 is not zero and < num1 (for clearer results)
            do {
                num1 = random.nextInt(max - min + 1) + min;
                num2 = random.nextInt(max - min + 1) + min;
            } while (num2 == 0);
            if (num1 < num2) { int t = num1; num1 = num2; num2 = t; }
            correctAnswer = num1 % num2;
        }

        num1Field.setText(String.valueOf(num1));
        operatorField.setText(selectedOperator);
        num2Field.setText(String.valueOf(num2));
    }

    private void checkAnswer() {
        // allow submitting even if Start wasn't pressed; ensure there is a problem to evaluate
        if (num1Field.getText().isEmpty() || operatorField.getText().isEmpty() || num2Field.getText().isEmpty()) {
            messageLabel.setText("No problem available. Choose level/operator or click Start Game.");
            messageLabel.setForeground(new Color(255, 200, 80));
            messageLabel.setBackground(new Color(40, 30, 10));
            return;
        }

        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());

            if (userAnswer == correctAnswer) {
                correctCount++;
                messageLabel.setText("Correct! " + messages[random.nextInt(messages.length)]);
                messageLabel.setForeground(new Color(40, 220, 100));
                messageLabel.setBackground(new Color(10, 30, 10));
            } else {
                incorrectCount++;
                messageLabel.setText("Incorrect. The answer was " + correctAnswer + ". " + messages[random.nextInt(messages.length)]);
                messageLabel.setForeground(new Color(255, 120, 120));
                messageLabel.setBackground(new Color(50, 10, 10));
            }
            updateScore();

            // Automatically show a new random problem after submission
            generateProblem();
            answerField.setText("");
            problemActive = true;
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number.");
            messageLabel.setForeground(new Color(255, 200, 80));
            messageLabel.setBackground(new Color(40, 30, 10));
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
        messageLabel.setForeground(new Color(180, 200, 255));
        messageLabel.setBackground(new Color(12, 15, 25));
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
