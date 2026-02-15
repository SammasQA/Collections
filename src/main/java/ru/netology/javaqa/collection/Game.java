package ru.netology.javaqa.collection;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> registeredPlayers = new ArrayList<>();

    // Регистрация игрока
    public void register(Player player) {
        registeredPlayers.add(player);
    }

    // Проведение раунда между двумя игроками по именам
    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength2 > strength1) {
            return 2;
        } else {
            return 0;
        }
    }

    // метод для поиска игрока по имени
    private Player findPlayerByName(String name) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}