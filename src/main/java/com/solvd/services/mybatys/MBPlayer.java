package com.solvd.services.mybatys;

import com.solvd.binary.Player;
import com.solvd.dao.interfaces.IPlayerDao;
import com.solvd.services.interfaces.PlayerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MBPlayer extends AbsSession implements PlayerService {

    private final static Logger LOGGER = LogManager.getLogger(MBPlayer.class);


    @Override
    public Player getPlayer(long id) {
        Player player = null;

        try (SqlSession s = setSqlSession()) {
            IPlayerDao playerDao = s.getMapper(IPlayerDao.class);
            player = playerDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return player;
    }

    @Override
    public void delete(long id) {
        try (SqlSession s = setSqlSession()) {
            IPlayerDao playerDao = s.getMapper(IPlayerDao.class);
            playerDao.removeEntity(id);
            s.commit();
        }
    }

    @Override
    public void update(long id, Player p) {
        try (SqlSession s = setSqlSession()) {
            IPlayerDao playerDao = s.getMapper(IPlayerDao.class);
            playerDao.updateEntity(id, p);
            s.commit();
        }
    }

    @Override
    public void create(Player p) {
        try (SqlSession s = setSqlSession()) {
            IPlayerDao playerDao = s.getMapper(IPlayerDao.class);
            playerDao.saveEntity(p);
            s.commit();
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = null;

        try (SqlSession s = setSqlSession()) {
            IPlayerDao playerDao = s.getMapper(IPlayerDao.class);
            players = playerDao.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return players;
    }
}
