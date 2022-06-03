package com.solvd.services.interfaces;

import com.solvd.binary.Match;

import java.util.List;

public interface MatchService {
    Match getMatch(long id);

    void delete(long id);

    void update(long id, Match m);

    void create(Match m);

    List<Match> getAllMatchs();
}
