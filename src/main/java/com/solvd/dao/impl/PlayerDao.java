package com.solvd.dao.impl;

import com.solvd.binary.Player;
import com.solvd.dao.interfaces.IPlayerDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao extends AbsConnection implements IPlayerDao {
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    private final static String SELECT = "SELECT * FROM `player`";
    private final static String SELECT_BY_ID = "SELECT * FROM `player` where id_player = ?";
    private final static String DELETE_BY_ID = "DELETE from `player` where id_player = ?";
    private final static String INSERT = "INSERT into `player` (id_player, `name`, lastname, birthday, shirt_number, banns, goals, football_team_id) values (?,?,?,?,?,?,?,?)";
    private final static String UPDATE = "UPDATE `player` SET `name`= ?, lastname = ?, birthday = ?, shirt_number = ?, banns = ?, goals = ? WHERE id_player = ?";


    private final static Logger LOGGER = LogManager.getLogger(PlayerDao.class);

    public PlayerDao() {
        con = getConnection();
    }

    @Override
    public Player getEntityId(long id) {
        Player p = new Player();

        try {
            stmt = con.prepareStatement(SELECT_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                p.setId(rs.getLong("id_player"));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString("lastname"));
                p.setBirthday(rs.getDate("birthday"));
                p.setShirtNumber(rs.getInt("shirt_number"));
                p.setBanns(rs.getInt("banns"));
                p.setGoals(rs.getInt("goals"));
                p.setFootballTeamId(rs.getLong("football_team_id"));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            if (stmt != null) {
                try {
                    stmt.close();
                    rs.close();
                } catch (SQLException e) {
                    LOGGER.info(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
        return p;
    }

    @Override
    public void saveEntity(Player entity) {
        try {
            stmt = con.prepareStatement(INSERT);
            stmt.setLong(1, entity.getId());
            stmt.setString(2, entity.getName());
            stmt.setString(3, entity.getLastname());
            stmt.setDate(4, (Date) entity.getBirthday());
            stmt.setInt(5, entity.getShirtNumber());
            stmt.setInt(6, entity.getBanns());
            stmt.setInt(7, entity.getGoals());
            stmt.setLong(8, entity.getFootballTeamId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOGGER.info(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void updateEntity(long id, Player entity) {
        try {
            stmt = con.prepareStatement(UPDATE);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getLastname());
            stmt.setDate(3, (Date) entity.getBirthday());
            stmt.setInt(4, entity.getShirtNumber());
            stmt.setInt(5, entity.getBanns());
            stmt.setInt(6, entity.getGoals());
            stmt.setLong(7, entity.getFootballTeamId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOGGER.info(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void removeEntity(long id) {
        try {
            stmt = con.prepareStatement(DELETE_BY_ID);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOGGER.info(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Player> getAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        try {
            stmt = con.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                players.add((Player) rs);
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            stmt.close();
            rs.close();
        }
        return players;
    }
}
