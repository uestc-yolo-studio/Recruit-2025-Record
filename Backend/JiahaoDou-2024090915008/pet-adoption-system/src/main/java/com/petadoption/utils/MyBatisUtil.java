package com.petadoption.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static final SqlSessionFactory FACTORY;
    static {
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            FACTORY = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession() {
        return FACTORY.openSession(); // 默认手动提交
    }
    public static SqlSession openSession(boolean autoCommit) {
        return FACTORY.openSession(autoCommit); // 按需自动提交
    }
}
