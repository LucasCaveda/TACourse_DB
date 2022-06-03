package com.solvd.services.mybatys;

import com.solvd.binary.Referee;
import com.solvd.dao.impl.RefereeDao;
import com.solvd.dao.interfaces.IRefereeDao;
import com.solvd.services.interfaces.RefereeService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MBReferee extends AbsSession implements RefereeService {
    private final static Logger LOGGER = LogManager.getLogger(MBReferee.class);


    @Override
    public Referee getReferee(long id) {
        Referee referee = null;

        try (SqlSession s = setSqlSession()) {
            IRefereeDao refereeDao = s.getMapper(IRefereeDao.class);
            referee = refereeDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return referee;
    }

    @Override
    public void delete(long id) {
        try (SqlSession s = setSqlSession()) {
            IRefereeDao refereeDao = s.getMapper(IRefereeDao.class);
            refereeDao.removeEntity(id);
            s.commit();
        }
    }

    @Override
    public void update(long id, Referee r) {
        try (SqlSession s = setSqlSession()) {
            IRefereeDao refereeDao = s.getMapper(IRefereeDao.class);
            refereeDao.updateEntity(id, r);
            s.commit();
        }
    }

    @Override
    public void create(Referee r) {
        try (SqlSession s = setSqlSession()) {
            IRefereeDao refereeDao = s.getMapper(IRefereeDao.class);
            refereeDao.saveEntity(r);
            s.commit();
        }
    }

    @Override
    public List<Referee> getAllReferees() {
        List<Referee> referees = null;
        try (SqlSession s = setSqlSession()) {
            IRefereeDao refereeDao = s.getMapper(IRefereeDao.class);
            referees=refereeDao.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return referees;
    }
}
