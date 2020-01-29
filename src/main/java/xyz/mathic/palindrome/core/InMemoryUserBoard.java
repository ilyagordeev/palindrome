package xyz.mathic.palindrome.core;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализация интерфейса ядра игры inMemory
 */
public class InMemoryUserBoard implements BoardService {

    private Set<User> users;
    public static final InMemoryUserBoard INSTANCE = new InMemoryUserBoard();

    private InMemoryUserBoard() {
        this.users = new HashSet<>();
    }

    public static InMemoryUserBoard getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public List<User> getLeaders() {
        return users.stream()
                .sorted(Comparator.comparing(User::getPoints).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public boolean putPhrase(String username, String phrase) {
        var user = getUser(username);
        String norm = BoardService.normalizePalindrome(phrase);
        if (BoardService.isPalindrome(norm)) {
            return user.addPhrase(norm);
        }
        return false;
    }

    private User getUser(String username) {
        User user = users.stream()
                .filter(u -> u.getName().equals(username))
                .findFirst()
                .orElse(new User(username));
        users.add(user);
        return user;
    }
}
