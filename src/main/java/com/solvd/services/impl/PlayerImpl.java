package com.solvd.services.impl;

import com.solvd.binary.Player;
import com.solvd.dao.impl.PlayerDao;
import com.solvd.dao.interfaces.IPlayerDao;
import com.solvd.services.interfaces.PlayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerImpl implements PlayerService {
    private IPlayerDao player = new PlayerDao();

    private final static Logger LOGGER = LogManager.getLogger(PlayerImpl.class);

    @Override
    public Player getPlayer(long id) {
        Player p = null;
        try {
            p = player.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return p;
    }

    @Override
    public void delete(long id) {
        player.removeEntity(id);
    }

    @Override
    public void update(long id, Player p) {
        player.updateEntity(id, p);
    }

    @Override
    public void create(Player p) {
        player.saveEntity(p);
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players=null;
        try {
            players = player.getAll();
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        return players;
    }
}
