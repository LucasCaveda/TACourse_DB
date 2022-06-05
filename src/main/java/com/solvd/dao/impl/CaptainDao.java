package com.solvd.dao.impl;

import com.solvd.binary.Captain;
import com.solvd.dao.impl.AbsConnection;
import com.solvd.dao.interfaces.ICaptainDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CaptainDao extends AbsConnection implements ICaptainDao {

    private final static String SELECT_BY_ID = "SELECT * FROM `captain` where id_captain = ?";
    private final static String INSERT = "insert into `captain` (id_captain, name, lastname, football_team_id) values (?,?,?,?)";
    private final static String DELETE_BY_ID = "delete from `captain` where id_captain = ?";

    private final static Logger LOGGER = LogManager.getLogger(CaptainDao.class);

    @Override
    public Captain getEntityId(long id) throws SQLException {
        ResultSet rs=null;
        PreparedStatement stmt=null;
        Connection con = getConnection();
        Captain c= new Captain();
        try{
            stmt=con.prepareStatement(SELECT_BY_ID);
            stmt.setLong(1,id);
            rs=stmt.executeQuery();

            if(rs.next()){
                c.setId(rs.getLong("id_captain"));
                c.setName(rs.getString("name"));
                c.setLastname(rs.getString("lastname"));
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
        return c;
    }

    @Override
    public void saveEntity(Captain entity) {
        Connection con = getConnection();
        PreparedStatement stmt=null;
        try{
            stmt = con.prepareStatement(INSERT);
            stmt.setLong(1,entity.getId());
            stmt.setString(2,entity.getName());
            stmt.setString(3,entity.getLastname());
            stmt.setLong(4,entity.getFootballTeam().getId());
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
    public void updateEntity(long id, Captain entity) {
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
    public List<Captain> getAll() throws SQLException {
        LOGGER.info("Not Available");
        return null;
    }
}
