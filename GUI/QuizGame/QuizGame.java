import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGame extends JFrame {
    private static final int TOTAL_QUESTIONS = 5;
    private static final int QUESTION_TIME_LIMIT = 15; // in seconds

    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timer timer;

    private JLabel questionLabel;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private JLabel timerLabel;
    private JLabel scoreLabel;

    private String[][] questions = {
            {"What is the capital of France?", "Paris", "Berlin", "London", "Madrid", "Paris"},
            {"Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn", "Mars"},
            {"What is the largest mammal on Earth?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus", "Blue Whale"},
            {"Who wrote 'Romeo and Juliet'?", "Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain", "William Shakespeare"},
            {"What is the currency of Japan?", "Yuan", "Won", "Yen", "Ringgit", "Yen"}
    };

    public QuizGame() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        questionLabel = new JLabel();
        optionGroup = new ButtonGroup();
        nextButton = new JButton("Next");
        timerLabel = new JLabel();
        scoreLabel = new JLabel("Score: 0");

        initializeTimer();

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });

        setLayout(new BorderLayout());
        add(questionLabel, BorderLayout.NORTH);
        add(createOptionsPanel(), BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
        add(timerLabel, BorderLayout.WEST);
        add(scoreLabel, BorderLayout.EAST);

        showNextQuestion();
        updateTimerLabel();

        setVisible(true);
    }

    private void initializeTimer() {
        timer = new Timer(1000, new ActionListener() {
            int timeRemaining = QUESTION_TIME_LIMIT;

            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimerLabel();
                timeRemaining--;

                if (timeRemaining < 0) {
                    timer.stop();
                    checkAnswer();
                    showNextQuestion();
                }
            }
        });
    }

    private JPanel createOptionsPanel() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        for (int i = 1; i <= 4; i++) {
            JRadioButton option = new JRadioButton();
            option.setActionCommand("Option " + i);
            optionGroup.add(option);
            optionsPanel.add(option);
        }

        return optionsPanel;
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < TOTAL_QUESTIONS) {
            String[] currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText(currentQuestion[0]);

            ButtonModel selectedOption = optionGroup.getSelection();
            if (selectedOption != null) {
                selectedOption.setSelected(false);
            }

            for (int i = 0; i < 4; i++) {
                JRadioButton option = (JRadioButton) optionGroup.getElements().nextElement();
                option.setText(currentQuestion[i + 1]);
            }

            timer.restart();
            currentQuestionIndex++;
        } else {
            endQuiz();
        }
    }

    private void checkAnswer() {
        String[] currentQuestion = questions[currentQuestionIndex - 1];
        String correctAnswer = currentQuestion[5];
        ButtonModel selectedOption = optionGroup.getSelection();

        if (selectedOption != null) {
            String selectedAnswer = selectedOption.getActionCommand().substring(7);

            if (selectedAnswer.equals(correctAnswer)) {
                score++;
            }
        }

        scoreLabel.setText("Score: " + score);
    }

    private void updateTimerLabel() {
        timerLabel.setText("Time: " + timer.getDelay() / 1000);
    }

    private void endQuiz() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Quiz Completed!\nYour Score: " + score, "Quiz Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizGame();
            }
        });
    }
}
