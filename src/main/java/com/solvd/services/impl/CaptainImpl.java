package com.solvd.services.impl;

import com.solvd.binary.Captain;
import com.solvd.dao.impl.CaptainDao;
import com.solvd.dao.interfaces.ICaptainDao;
import com.solvd.services.interfaces.CaptainService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CaptainImpl implements CaptainService {

    private final static Logger LOGGER = LogManager.getLogger(CaptainService.class);

    @Override
    public Captain getCaptain(long id) {
        Captain captain=null;
        ICaptainDao cap = new CaptainDao();
        try {
            captain = cap.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return captain;
    }

    @Override
    public void delete(long id) {
        ICaptainDao cap = new CaptainDao();
        cap.removeEntity(id);
    }

    @Override
    public void update(long id, Captain c) {
        ICaptainDao cap = new CaptainDao();
        cap.updateEntity(id,c);
    }

    @Override
    public void create(Captain c) {
        ICaptainDao cap = new CaptainDao();
        cap.saveEntity(c);
    }

    @Override
    public List<Captain> getAllCaptains() {
        ICaptainDao cap = new CaptainDao();
        List<Captain> captains=null;
        try {
        captains = cap.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return captains;
    }
}
