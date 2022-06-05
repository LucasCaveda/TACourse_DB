package com.solvd.services.mybatys;

import com.solvd.binary.Captain;
import com.solvd.dao.interfaces.ICaptainDao;
import com.solvd.services.interfaces.CaptainService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CaptainImpl extends AbsSession implements CaptainService {

    private final static Logger LOGGER = LogManager.getLogger(CaptainImpl.class);


    @Override
    public Captain getCaptain(long id) {
        Captain captain = null;

        try (SqlSession s = setSqlSession()) {
            ICaptainDao captainDao = s.getMapper(ICaptainDao.class);
            captain = captainDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return captain;
    }

    @Override
    public void delete(long id) {
        try (SqlSession s = setSqlSession()) {
            ICaptainDao captainDao = s.getMapper(ICaptainDao.class);
            captainDao.removeEntity(id);
            s.commit();
        }
    }

    @Override
    public void update(long id, Captain c) {
        try (SqlSession s = setSqlSession()) {
            ICaptainDao captainDao = s.getMapper(ICaptainDao.class);
            captainDao.updateEntity(id, c);
        }
    }

    @Override
    public void create(Captain c) {
        try (SqlSession s = setSqlSession()) {
            ICaptainDao captainDao = s.getMapper(ICaptainDao.class);
            captainDao.saveEntity(c);
        }
    }

    @Override
    public List<Captain> getAllCaptains() {
        List<Captain> captains = null;
        SqlSession s = setSqlSession();
        ICaptainDao captainDao = s.getMapper(ICaptainDao.class);

        try {
            captains = captainDao.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return captains;
    }
}
