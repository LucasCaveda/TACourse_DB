package com.solvd.services.interfaces;

import com.solvd.binary.Referee;

import java.util.List;

public interface RefereeService {
    Referee getReferee(long id);

    void delete(long id);

    void update(long id, Referee r);

    void create(Referee r);

    List<Referee> getAllReferees();
}

