package weinfeld.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScrabbleFrame extends JFrame {

    private final JTextField wordField;
    private final JLabel answerLabel;
    private WordCheck dictionary;

    public ScrabbleFrame() throws FileNotFoundException {

        dictionary = new WordCheck("dictionary.txt");
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 40));

        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        answerLabel.setOpaque(true);

        add(wordField);
        add(checkButton);
        add(answerLabel);

        try {
            System.out.println(System.currentTimeMillis());
            dictionary = new WordCheck("dictionary.txt");
            System.out.println(System.currentTimeMillis());
        } catch (FileNotFoundException e) {

        }

    }

    public void checkWord(){

        boolean isInDictionary = dictionary.isWord(wordField.getText());
        answerLabel.setText(String.valueOf(isInDictionary));

        answerLabel.setBackground(isInDictionary ? Color.green : Color.red);

    }

    public static void main(String[] args) throws FileNotFoundException {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);

    }
}
