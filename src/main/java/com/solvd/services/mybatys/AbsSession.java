package com.solvd.services.mybatys;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public abstract class AbsSession {
    public SqlSession setSqlSession() {
        Reader r = null;
        try {
            r = Resources.getResourceAsReader("mybatisConfig.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(r);
        SqlSession s = sql.openSession();
        return s;
    }
}
