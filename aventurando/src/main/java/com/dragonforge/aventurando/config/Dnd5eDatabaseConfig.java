package com.dragonforge.aventurando.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.dragonforge.aventurando.sistemas.dnd5e.repositorios", // repositórios do DND5E
    entityManagerFactoryRef = "dnd5eEntityManager",
    transactionManagerRef = "dnd5eTransactionManager"
)
public class Dnd5eDatabaseConfig {
    @Bean
    @ConfigurationProperties("dnd5e.datasource")
    public DataSourceProperties dnd5eDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dnd5eDataSource() {
        return dnd5eDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dnd5eEntityManager(EntityManagerFactoryBuilder builder) {
        HashMap<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return builder
                .dataSource(dnd5eDataSource())
                .packages("com.dragonforge.aventurando.sistemas.dnd5e.models") // models do DND5E
                .persistenceUnit("dnd5e")
                .properties(props)
                .build();
    }

    @Bean
    public PlatformTransactionManager dnd5eTransactionManager(
            @Qualifier("dnd5eEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}