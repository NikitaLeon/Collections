package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player petya = new Player(1,"Пётр", 300);
        Player sasha = new Player(2, "Александр", 200);
        Game game = new Game();

        game.register(petya);
        game.register(sasha);

        int expected = 1;
        int actual = game.round("Пётр", "Александр" );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Player raf = new Player(3,"Рафис", 100);
        Player sasha = new Player(2, "Александр", 200);
        Game game = new Game();

        game.register(raf);
        game.register(sasha);

        int expected = 2;
        int actual = game.round("Рафис", "Александр" );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {
        Player raf = new Player(3,"Рафис", 100);
        Player sergey = new Player(4, "Сергей", 100);
        Game game = new Game();

        game.register(raf);
        game.register(sergey);

        int expected = 0;
        int actual = game.round("Рафис", "Сергей" );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstNotRegistered() {
        Player petya = new Player(1, "Пётр", 300);
        Player sergey = new Player(4, "Сергей", 100);
        Game game = new Game();

        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Пётр", "Сергей"));
    }

    @Test
    public void secondNotRegistered() {
        Player petya = new Player(1, "Пётр", 300);
        Player sergey = new Player(4, "Сергей", 100);
        Game game = new Game();

        game.register(sergey);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Пётр", "Сергей"));
    }
}
