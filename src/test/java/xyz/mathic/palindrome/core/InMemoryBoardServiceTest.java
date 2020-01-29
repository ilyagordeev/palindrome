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
    }

    @Test
    public void getLeaders() {
        assertArrayEquals(new Object[]{"Mladich", "Ivan", "Korsich"}, boardService.getLeaders().stream().map(User::getName).toArray());
        assertArrayEquals(new Object[]{31, 26, 10}, boardService.getLeaders().stream().map(User::getPoints).toArray());
   }
}