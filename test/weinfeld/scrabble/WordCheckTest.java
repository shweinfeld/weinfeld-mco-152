package weinfeld.scrabble;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


public class WordCheckTest {

    @Test
    public void existingWord() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck("dictionary.txt");

        //when
        boolean isWord = word.isWord("SOVIETIZING");

        //then
        assertTrue(isWord);

    }

    @Test
    public void notAWord() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck("dictionary.txt");

        //when
        boolean isWord = word.isWord("FANTABULOUSLY");

        //then
        assertFalse(isWord);
    }

    @Test
    public void caseTest() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck("dictionary.txt");

        //when
        boolean isWord = word.isWord("wOnDeR");

        //then
        assertTrue(isWord);
    }
}