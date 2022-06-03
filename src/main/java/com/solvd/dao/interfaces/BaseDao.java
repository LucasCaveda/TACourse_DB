package com.solvd.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    
    T getEntityId(long id) throws SQLException;
    void saveEntity(T entity);
    void updateEntity(long id, T entity);
    void removeEntity(long id);
    List<T> getAll() throws SQLException;
}
