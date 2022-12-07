package org.venusPj.projectTemplate.shared.doma;

import javax.sql.DataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomaConfig implements Config {

    private static final DomaConfig CONFIG = new DomaConfig();

    private final Dialect dialect;

    private DataSource dataSource;

    private DomaConfig() {
        dialect = new PostgresDialect();
        dataSource = new LocalTransactionDataSource(
            "jdbc:h2:mem:tutorial;DB_CLOSE_DELAY=-1", "sa", null);
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static DomaConfig singleton() {
        return CONFIG;
    }
}
