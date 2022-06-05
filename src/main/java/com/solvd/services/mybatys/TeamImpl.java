package com.solvd.services.mybatys;

import com.solvd.binary.FootballTeam;
import com.solvd.dao.interfaces.ITeamDao;
import com.solvd.services.interfaces.TeamService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class TeamImpl extends AbsSession implements TeamService {

    private final static Logger LOGGER = LogManager.getLogger(TeamImpl.class);


    @Override
    public FootballTeam getTeam(long id) {
        FootballTeam team = null;

        try (SqlSession s = setSqlSession()) {
            ITeamDao teamDao = s.getMapper(ITeamDao.class);
            team = teamDao.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return team;
    }

    @Override
    public void delete(long id) {
        try (SqlSession s = setSqlSession()) {
            ITeamDao teamDao = s.getMapper(ITeamDao.class);
            teamDao.removeEntity(id);
            s.commit();
        }
    }

    @Override
    public void update(long id, FootballTeam t) {
        try (SqlSession s = setSqlSession()) {
            ITeamDao teamDao = s.getMapper(ITeamDao.class);
            teamDao.updateEntity(id,t);
            s.commit();
        }
    }

    @Override
    public void create(FootballTeam t) {
        try (SqlSession s = setSqlSession()) {
            ITeamDao teamDao = s.getMapper(ITeamDao.class);
            teamDao.saveEntity(t);
            s.commit();
        }
    }

    @Override
    public List<FootballTeam> getAllTeams() {
        List<FootballTeam> teams=null;

        try (SqlSession s = setSqlSession()) {
            ITeamDao teamDao = s.getMapper(ITeamDao.class);
            teams = teamDao.getAll();
        }catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return teams;
    }
}
