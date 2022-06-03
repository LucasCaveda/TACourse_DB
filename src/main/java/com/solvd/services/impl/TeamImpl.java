package com.solvd.services.impl;

import com.solvd.binary.FootballTeam;
import com.solvd.dao.impl.FootballTeamDao;
import com.solvd.dao.interfaces.ITeamDao;
import com.solvd.services.interfaces.TeamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeamImpl implements TeamService {

    private final static Logger LOGGER = LogManager.getLogger(TeamImpl.class);

    @Override
    public FootballTeam getTeam(long id) {
        ITeamDao team= new FootballTeamDao();
        FootballTeam t = null;
        try {
            t = team.getEntityId(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return t;
    }

    @Override
    public void delete(long id) {
        ITeamDao team= new FootballTeamDao();
        team.removeEntity(id);
    }

    @Override
    public void update(long id, FootballTeam t) {
        ITeamDao team= new FootballTeamDao();
        team.updateEntity(id, t);
    }

    @Override
    public void create(FootballTeam t) {
        ITeamDao team= new FootballTeamDao();
        team.saveEntity(t);
    }

    @Override
    public List<FootballTeam> getAllTeams() {
        ITeamDao team= new FootballTeamDao();
        List<FootballTeam> teams = null;
        try {
            teams = team.getAll();
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        return teams;
    }
}
