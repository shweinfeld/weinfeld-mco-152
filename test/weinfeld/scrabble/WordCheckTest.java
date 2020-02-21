package weinfeld.scrabble;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;


public class WordCheckTest {

    @Test
    public void existingWord() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck();

        //when
        boolean isWord = word.isWord("SOVIETIZING");

        //then
        assertEquals(true, isWord);

    }

    @Test
    public void notAWord() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck();

        //when
        boolean isWord = word.isWord("FANTABULOUSLY");

        //then
        assertEquals(false, isWord);
    }

    @Test
    public void caseTest() throws FileNotFoundException {

        //given
        WordCheck word = new WordCheck();

        //when
        boolean isWord = word.isWord("wOnDeR");

        //then
        assertEquals(true, isWord);
    }
}