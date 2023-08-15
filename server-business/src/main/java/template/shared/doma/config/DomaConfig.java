package template.shared.doma.config;

import lombok.NoArgsConstructor;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@NoArgsConstructor
public class DomaConfig implements Config {

    private DataSource dataSource;

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

