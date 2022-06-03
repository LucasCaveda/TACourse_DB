package com.solvd.services.impl;

import com.solvd.binary.Match;
import com.solvd.dao.impl.MatchDao;
import com.solvd.dao.interfaces.IMatchDao;
import com.solvd.services.interfaces.MatchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MatchImpl implements MatchService {

    private final static Logger LOGGER = LogManager.getLogger(MatchImpl.class);


    @Override
    public Match getMatch(long id) {
        IMatchDao match=new MatchDao();
        Match m = null;
        try {
            m = match.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return m;
    }

    @Override
    public void delete(long id) {
        IMatchDao match=new MatchDao();
        match.removeEntity(id);
    }

    @Override
    public void update(long id, Match m) {
        IMatchDao match=new MatchDao();
        match.updateEntity(id, m);
    }

    @Override
    public void create(Match m) {
        IMatchDao match=new MatchDao();
        match.saveEntity(m);
    }

    @Override
    public List<Match> getAllMatchs() {
        IMatchDao match=new MatchDao();
        List<Match> matchs = null;
        try {
            matchs = match.getAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return matchs;
    }
}
