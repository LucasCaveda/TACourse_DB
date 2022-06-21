package com.solvd.dao.impl;

import com.solvd.binary.Match;
import com.solvd.dao.interfaces.IMatchDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDao extends AbsConnection implements IMatchDao {
    private final static String SELECT_BY_ID = "SELECT * FROM `match` where id = ?";
    private final static String DELETE_BY_ID = "delete from `match` where id = ?";
    private final static String INSERT = "insert into `match` (id, q_goals, result, `date`, championship_id, stadium_id, football_team1_id, football_team2_id) values (?,?,?,?,?,?,?,?)";


    private final static Logger LOGGER = LogManager.getLogger(MatchDao.class);

    @Override
    public Match getEntityId(long id){
        Match m = new Match();
        ResultSet rs=null;
        PreparedStatement stmt=null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement(SELECT_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                m.setId(rs.getLong("id"));
                m.setqGoals(rs.getInt("q_goals"));
                m.setResult(rs.getString("result"));
                m.setDate(rs.getDate("date"));
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
        return m;
    }

    @Override
    public void saveEntity(Match match) {
        PreparedStatement stmt=null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement(INSERT);
            //parsing values
            stmt.setLong(1, match.getId());
            stmt.setInt(2, match.getqGoals());
            stmt.setString(3, match.getResult());
            stmt.setDate(4, (Date) match.getDate());
            stmt.setLong(5, match.getChampionship().getId());
            stmt.setLong(6, match.getStadium().getId());
            stmt.setLong(7, match.getFootballTeam1().getId());
            stmt.setLong(7, match.getFootballTeam2().getId());
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
    public void updateEntity(long id, Match entity) {
        PreparedStatement stmt=null;
        Connection con = getConnection();
        String result = entity.getResult();
        int qGoals = entity.getqGoals();
        String query = "UPDATE `match` SET result=" + result + ", set q_goals = " + qGoals + "where id = ?";
        try {
            stmt = con.prepareStatement(query);
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
    public void removeEntity(long id) {
        PreparedStatement stmt=null;
        Connection con = getConnection();
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
    public List<Match> getAll() {
        LOGGER.info("Not Available");
        return null;
    }
}
