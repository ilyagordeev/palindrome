package xyz.mathic.palindrome.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardServiceTest {

    @Test
    public void isPalindrome() {
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("а роза упала на лапу Азора")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("Я — арка края")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("О, лета тело!")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("Аргентина манит негра")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("Колесо. Жалко поклаж. Оселок.")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("топот")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("то/][()@#%&*:;{}пот?")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("0110")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("vo v as")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("написать логическое ядро")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("  ")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("A")));
    }
}