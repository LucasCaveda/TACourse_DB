package com.solvd.dao.interfaces;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    
    T getEntityId(@Param ("id")long id) throws SQLException;
    void saveEntity(T entity);
    void updateEntity(@Param("id") long id, @Param("entity") T entity);
    void removeEntity(@Param("id") long id);
    List<T> getAll() throws SQLException;
}
