package ru.netology.javaqa.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();
        player1 = new Player(1, "Alice", 100);
        player2 = new Player(2, "Bob", 80);
        player3 = new Player(3, "Charlie", 100);

        game.register(player1);
        game.register(player2);
        // player3 пока не регистрируем — он будет добавлен в нужном тесте
    }

    @Test
    void shouldReturn1WhenFirstPlayerStronger() {
        int result = game.round("Alice", "Bob");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2WhenSecondPlayerStronger() {
        int result = game.round("Bob", "Alice");
        assertEquals(2, result);
    }

    @Test
    void shouldReturn0WhenStrengthsEqual() {
        game.register(player3);               // регистрируем Charlie
        int result = game.round("Alice", "Charlie");
        assertEquals(0, result);
    }

    @Test
    void shouldThrowExceptionWhenFirstPlayerNotRegistered() {
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Unknown", "Alice")
        );
        assertEquals("Игрок Unknown не зарегистрирован", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSecondPlayerNotRegistered() {
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Unknown")
        );
        assertEquals("Игрок Unknown не зарегистрирован", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBothPlayersNotRegistered() {
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Unknown1", "Unknown2")
        );

        assertEquals("Игрок Unknown1 не зарегистрирован", exception.getMessage());
    }
}