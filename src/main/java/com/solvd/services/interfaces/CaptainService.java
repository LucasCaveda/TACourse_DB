package com.solvd.services.interfaces;

import com.solvd.binary.Captain;

import java.util.List;

public interface CaptainService {
    Captain getCaptain(long id);

    void delete(long id);

    void update(long id,Captain c);

    void create(Captain c);

    List<Captain> getAllCaptains();
}
