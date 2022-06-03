package com.solvd.services.interfaces;

import com.solvd.binary.FootballTeam;
import com.solvd.dao.impl.FootballTeamDao;

import java.util.List;

public interface TeamService {
    FootballTeam getTeam(long id);

    void delete(long id);

    void update(long id, FootballTeam t);

    void create(FootballTeam t);

    List<FootballTeam> getAllTeams();
}
