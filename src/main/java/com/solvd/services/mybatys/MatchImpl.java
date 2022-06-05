package com.solvd.services.mybatys;

import com.solvd.binary.Match;
import com.solvd.dao.interfaces.IMatchDao;
import com.solvd.services.interfaces.MatchService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MatchImpl extends AbsSession implements MatchService {
    private final static Logger LOGGER = LogManager.getLogger(MatchImpl.class);


    @Override
    public Match getMatch(long id) {
        Match match = null;
        try (SqlSession s = setSqlSession()) {
            IMatchDao matchDao = s.getMapper(IMatchDao.class);
            match = matchDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return match;
    }

    @Override
    public void delete(long id) {
        try (SqlSession s = setSqlSession()) {
            IMatchDao matchDao = s.getMapper(IMatchDao.class);
            matchDao.removeEntity(id);
            s.commit();
        }

    }

    @Override
    public void update(long id, Match m) {
        try (SqlSession s = setSqlSession()) {
            IMatchDao matchDao = s.getMapper(IMatchDao.class);
            matchDao.updateEntity(id, m);
            s.commit();
        }
    }

    @Override
    public void create(Match m) {
        try (SqlSession s = setSqlSession()) {
            IMatchDao matchDao = s.getMapper(IMatchDao.class);
            matchDao.saveEntity(m);
            s.commit();
        }
    }

    @Override
    public List<Match> getAllMatchs() {
        List<Match> matches=null;
        try (SqlSession s = setSqlSession()) {
            IMatchDao matchDao = s.getMapper(IMatchDao.class);
            matches = matchDao.getAll();
        }catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return matches;
    }
}
