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

    private final static Logger LOGGER = LogManager.getLogger(FootballTeamDao.class);
    private final static String SELECT_BY_ID = "select * from Football_Team where id = ?";
    private final static String DELETE_BY_ID = "delete from FootballTeam where id = ?";
    private final static String INSERT = "insert into football_team (id, name, technical_manager_id, stadium_id, president_id, city_id) values (?,?,?,?,?,?)";


    @Override
    public FootballTeam getEntityId(long id) {
        Connection con = getConnection();
        ResultSet rs=null;
        PreparedStatement stmt=null;
        FootballTeam t = new FootballTeam();

        try {
            stmt = con.prepareStatement(SELECT_BY_ID);
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
        Connection con = getConnection();
        ResultSet rs=null;
        PreparedStatement stmt=null;
        try {
            stmt = con.prepareStatement(INSERT);
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
        Connection con = getConnection();
        PreparedStatement stmt=null;
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
    public List<FootballTeam> getAll() {
        LOGGER.info("Not Available");
        return null;
    }
}
