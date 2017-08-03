import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class Lab13Test {

    @Test
    public void testAllMisses() {
        Lab13 game = new Lab13();
        String input = "--|--|--|--|--|--|--|--|--|--||";
        int expected = 0;
        int result = game.scoreGame(input);
        assertEquals(expected, result);

    }

    @Ignore
    @Test
    public void test1PinInFrame1(){
        Lab13 game = new Lab13();
        String input = "1-|--|--|--|--|--|--|--|--|--||";
        int expected = 1;
        int result = game.scoreGame(input);
        assertEquals(expected, result);

    }


    @Ignore
    @Test
    public void testAllStrikes(){
        Lab13 game = new Lab13();
        String input = "X|X|X|X|X|X|X|X|X|X||XX";
        int expected = 300;
        int result = game.scoreGame(input);
        assertEquals(expected, result);

    }

    @Ignore
    @Test
    public void testEveryFrame5AndSpare(){
        Lab13 game = new Lab13();
        String input = "-5|-5|-5|-5|-5|-5|-5|-5|-5|-/||3";
        int expected = 58;
        int result = game.scoreGame(input);
        assertEquals(expected, result);

    }


}