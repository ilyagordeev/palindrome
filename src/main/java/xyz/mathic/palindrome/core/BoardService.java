package xyz.mathic.palindrome.core;

import java.util.List;

/**
 * Интерфейс ядра игры
 */
public interface BoardService {
    /**
     * Доска лидеров
     * @return список из 5 лидеров игры
     */
    List<User> getLeaders();

    /**
     *
     * @param username имя пользователя
     * @param phrase фраза/слово, предполагаемый палиндром
     * @return true если палиндром и этот пользователь его ещё не использовал
     */
    boolean putPhrase(String username, String phrase);

    /**
     * Метод проверки на палиндромность
     * @param palindrome предполагаемый палиндром после нормализации
     * @return true если палиндром
     */
    static boolean isPalindrome(final String palindrome) {
        int length = palindrome.length();
        for (int i = 0; i < length / 2; i++) {
            if (palindrome.charAt(i) == palindrome.charAt(length - 1 - i)) {
                if (i == length/2 - 1) return true;
            } else break;
        }
        return false;
    }

    /**
     * Метод удаления пробелов и приведения к нижнему регистру
     * @param palindrome предполагаемый палиндром
     * @return строка без пробелов
     */
    static String normalizePalindrome(final String palindrome) {
        if (palindrome == null || palindrome.isBlank()) return "";
        return palindrome.replaceAll("(?U)[\\pP\\s]", "").toLowerCase();
    }
}
