package dev.alexanastasyev.dbapp_languagesschool.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceBuilder<HikariDataSource> dataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/app_lang_school_db");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("1234");
        return dataSourceBuilder.build();
    }

}
