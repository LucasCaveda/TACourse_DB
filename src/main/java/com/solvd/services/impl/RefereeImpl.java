package com.solvd.services.impl;

import com.solvd.binary.Referee;
import com.solvd.dao.impl.RefereeDao;
import com.solvd.dao.interfaces.IRefereeDao;
import com.solvd.services.interfaces.CaptainService;
import com.solvd.services.interfaces.RefereeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class RefereeImpl implements RefereeService {
    private IRefereeDao rDao = new RefereeDao();

    private final static Logger LOGGER = LogManager.getLogger(CaptainService.class);


    @Override
    public Referee getReferee(long id) {
        Referee r = null;
        try {
            r = rDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return r;
    }

    @Override
    public void delete(long id) {
        rDao.removeEntity(id);
    }

    @Override
    public void update(long id, Referee r) {
        rDao.updateEntity(id, r);
    }

    @Override
    public void create(Referee r) {
        rDao.saveEntity(r);
    }

    @Override
    public List<Referee> getAllReferees() {
        List<Referee> referees = null;
        try {
            referees = rDao.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return referees;
    }
}
