package org.venusPj.projectTemplate.shared.doma;

import jakarta.activation.DataSource;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;

@Configuration
public class DomaConfig implements Config {

    private static final DomaConfig CONFIG = new DomaConfig();

    private final Dialect dialect;

    private DataSource dataSource;
    private TransactionManager transactionManager;

    @VisibleForTesting
    public DomaConfig() {
        dialect = new PostgresDialect();
        dataSource = new LocalTransactionDataSource("jdbc:postgresql://localhost:5432/sample",
            "user", "password");
        transactionManager = new LocalTransactionManager(
            dataSource.getLocalTransaction(getJdbcLogger()));
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
