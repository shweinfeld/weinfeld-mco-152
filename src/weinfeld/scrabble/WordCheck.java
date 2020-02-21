package weinfeld.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCheck {
    private Map<String, String> dictionary = new HashMap<>();


    public WordCheck() throws FileNotFoundException {
        File scrabbleDictionary = new File("C:\\Users\\shana\\Downloads\\dictionary.txt");
        Scanner scanner = new Scanner(scrabbleDictionary);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int i = line.indexOf(' ');
            if (i > -1) {
                String word = line.substring(0, i);
                String def = line.substring(i);
                dictionary.put(word, def);
            }
            else {
                dictionary.put(line, "");
            }


        }
    }

    public boolean isWord(String word) {
        return dictionary.containsKey(word.toUpperCase());
    }

    public void printDictionary() {
        System.out.println(dictionary);
    }

}
