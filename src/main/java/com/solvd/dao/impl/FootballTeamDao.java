package com.solvd.dao.impl;

import com.solvd.binary.FootballTeam;
import com.solvd.dao.interfaces.ITeamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballTeamDao extends AbsConnection implements ITeamDao {
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;

    private final static Logger LOGGER = LogManager.getLogger(FootballTeamDao.class);

    public FootballTeamDao() {
        con=getConnection();
    }

    @Override
    public FootballTeam getEntityId(long id) {
        String query = "select * from Football_Team where id = ?";
        FootballTeam t = new FootballTeam();

        try {
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                //Mapping the object
                t.setId(rs.getLong("id"));
                t.setName(rs.getString("name"));
            }
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
        return t;
    }

    @Override
    public void saveEntity(FootballTeam team) {
        String query = "insert into football_team (id, name, technical_manager_id, stadium_id, president_id, city_id) values (?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(query);
            //parsing values
            stmt.setLong(1, team.getId());
            stmt.setString(2, team.getName());
            stmt.setLong(3, team.getTechnicalManager().getId());
            stmt.setLong(4, team.getStadium().getId());
            stmt.setLong(5, team.getPresident().getId());
            stmt.setLong(6, team.getCity().getIdCity());


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
    public void updateEntity(long id, FootballTeam entity) {
        LOGGER.info("Not Available");
    }

    @Override
    public void removeEntity(long id) {
        String query = "delete from FootballTeam where id = ?";
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
    public List<FootballTeam> getAll() throws SQLException {
        List<FootballTeam> teams = new ArrayList<>();
        String query = "SELECT * FROM `football_team`";
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                teams.add((FootballTeam) rs);
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            returnConnection(con);
            stmt.close();
            rs.close();
        }
        return teams;
    }
}
