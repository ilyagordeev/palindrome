package xyz.mathic.palindrome.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardServiceTest {

    @Test
    public void isPalindrome() {
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("vo v as")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("написать логическое ядро")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("а роза упала на лапу Азора")));
        assertTrue(BoardService.isPalindrome(BoardService.normalizePalindrome("топот")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("  ")));
        assertFalse(BoardService.isPalindrome(BoardService.normalizePalindrome("A")));
    }
}