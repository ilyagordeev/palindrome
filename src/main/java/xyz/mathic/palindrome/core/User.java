package xyz.mathic.palindrome.core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Пользователь, допускает добавление только новых фраз, очки добавляются автоматом
 * При реализации работы с JPA потребуется добавление пустого конструктора и сеттеров
 */
public class User {
    private String name;
    private Set<String> phrases;
    private int points;

    public User(String name) {
        this.name = name;
        this.phrases = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Метод добавления новой фразы и рассчета очков.
     * Проверка фразы/слова на палиндромность производится в классе {@link InMemoryUserBoard}
     *
     * @param phrase уже проверенный палиндром
     * @return false если эта фраза уже использовалась
     */
    public boolean addPhrase(String phrase) {
        if (this.phrases.add(phrase)) {
            points += phrase.length();
            return true;
        }
        return false;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
