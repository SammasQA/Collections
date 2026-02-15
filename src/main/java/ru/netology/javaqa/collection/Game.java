package ru.netology.javaqa.collection;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Map<String, Player> registeredPlayers = new HashMap<>();

    public void register(Player player) {
        registeredPlayers.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = registeredPlayers.get(playerName1);
        Player player2 = registeredPlayers.get(playerName2);

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
}