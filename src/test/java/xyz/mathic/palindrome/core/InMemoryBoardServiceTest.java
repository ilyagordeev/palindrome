package xyz.mathic.palindrome.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryBoardServiceTest {

    BoardService boardService = InMemoryUserBoard.getINSTANCE();

    @Test
    public void putPhrase() {
        assertTrue(boardService.putPhrase("Ivan", "topot"));
        assertFalse(boardService.putPhrase("Ivan", "topot"));
        assertTrue(boardService.putPhrase("Ivan", "а роза упала на лапу Азора"));
        assertFalse(boardService.putPhrase("Ivan", "просто текст"));

        assertTrue(boardService.putPhrase("Mladich", "topottopot"));
        assertFalse(boardService.putPhrase("Mladich", "topottopot"));
        assertTrue(boardService.putPhrase("Mladich", "а роза упала на лапу Азора"));

        assertTrue(boardService.putPhrase("Korsich", "topottopot"));

        assertTrue(boardService.putPhrase("Σωκράτης", "Saippuakivikauppias"));

        assertTrue(boardService.putPhrase("Брюсов", "топот"));

        assertTrue(boardService.putPhrase("Краб", "010"));

        assertFalse(boardService.putPhrase("", "010"));
        assertFalse(boardService.putPhrase("   ", "010"));
        assertFalse(boardService.putPhrase("123", null));
        assertFalse(boardService.putPhrase(null, null));
    }

    @Test
    public void getLeaders() {
        assertArrayEquals(new Object[]{"Mladich", "Ivan", "Σωκράτης", "Korsich", "Брюсов"},
                boardService.getLeaders().stream().map(User::getName).toArray());

        assertArrayEquals(new Object[]{31, 26, 19, 10, 5},
                boardService.getLeaders().stream().map(User::getPoints).toArray());
   }
}