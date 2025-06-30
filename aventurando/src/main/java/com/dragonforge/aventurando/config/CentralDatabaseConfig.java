package com.dragonforge.aventurando.config;

import javax.sql.DataSource;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
	basePackages = "com.dragonforge.aventurando.central.repositorios", // repositórios do banco principal
	entityManagerFactoryRef = "aventurandoEntityManager",
	transactionManagerRef = "aventurandoTransactionManager"
)
public class CentralDatabaseConfig {
	@Primary
	@Bean
	@ConfigurationProperties("aventurando.datasource")
	public DataSourceProperties aventurandoDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource aventurandoDataSource() {
		return aventurandoDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean(name = "aventurandoEntityManager")
	public LocalContainerEntityManagerFactoryBean aventurandoEntityManager(EntityManagerFactoryBuilder builder) {
		HashMap<String, Object> props = new HashMap<>();
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

		return builder
				.dataSource(aventurandoDataSource())
				.packages("com.dragonforge.aventurando.central.models") // models do banco principal
				.persistenceUnit("aventurando")
				.properties(props)
				.build();
	}

	@Primary
	@Bean(name = "aventurandoTransactionManager")
	public PlatformTransactionManager aventurandoTransactionManager(
			@Qualifier("aventurandoEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory.getObject());
	}
}