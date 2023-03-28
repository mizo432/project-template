package com.undecided.projectTemplate.shared.domaConfig;

import javax.sql.DataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomaConfig implements Config {

    private final DataSource dataSource;

    public DomaConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return new PostgresDialect();
    }
}

