package com.solvd.dao.impl;

import com.solvd.binary.Referee;
import com.solvd.dao.interfaces.IRefereeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class RefereeDao extends AbsConnection implements IRefereeDao {
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    private final static String SELECT_BY_ID = "SELECT * FROM `referee` where id_referee = ?";
    private final static String INSERT = "insert into `referee` (id_referee, name, lastname, birthday, match_id) values (?,?,?,?,?)";


    private final static Logger LOGGER = LogManager.getLogger(CaptainDao.class);

    @Override
    public Referee getEntityId(long id) throws SQLException {
        Referee r = new Referee();
        try {
            stmt = con.prepareStatement(SELECT_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                r.setId(rs.getLong("id_referee"));
                r.setName(rs.getString("name"));
                r.setLastname(rs.getString("lastname"));
                r.setBirthday(rs.getDate("birthday"));
            }
        }catch (SQLException e){
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
        return r;
    }

    @Override
    public void saveEntity(Referee entity) {
        try {
            stmt = con.prepareStatement(INSERT);
            stmt.setLong(1,entity.getId());
            stmt.setString(2,entity.getName());
            stmt.setString(3,entity.getLastname());
            stmt.setDate(4, (Date) entity.getBirthday());
            stmt.setLong(5,entity.getMatch().getId());
            stmt.executeUpdate();
        }catch (SQLException e) {
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
    public void updateEntity(long id, Referee entity) {
        LOGGER.info("Not Available");
    }

    @Override
    public void removeEntity(long id) {
        LOGGER.info("Not Available");
    }

    @Override
    public List<Referee> getAll() throws SQLException {
        LOGGER.info("Not Available");
        return null;
    }
}
