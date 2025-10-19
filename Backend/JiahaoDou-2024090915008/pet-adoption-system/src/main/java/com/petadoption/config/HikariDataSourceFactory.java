package com.petadoption.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class HikariDataSourceFactory implements DataSourceFactory {

    private HikariDataSource dataSource;

    @Override
    public void setProperties(Properties props) {
        // 把 db.properties 里的键值直接转给 Hikari
        HikariConfig config = new HikariConfig(props);
        this.dataSource = new HikariDataSource(config);
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}