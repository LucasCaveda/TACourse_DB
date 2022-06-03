package com.solvd.services.interfaces;

import com.solvd.binary.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayer(long id);

    void delete(long id);

    void update(long id, Player p);

    void create(Player p);

    List<Player> getAllPlayers();
}
