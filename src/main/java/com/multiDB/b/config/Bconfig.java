package com.multiDB.b.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multiDB.b.dao.BookDao;
import com.multiDB.b.entity.Book;


@Configuration
@EnableJpaRepositories( //
	basePackageClasses = BookDao.class, //
	entityManagerFactoryRef = "bEntityManagerFactory", //
	transactionManagerRef = "bTransactionManager"
)
@EnableTransactionManagement
public class Bconfig {

	@Bean("bDataSource")
	@ConfigurationProperties("app.datasource.b")
	public DataSource aDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("bEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bEntityManagerFactory(
    		@Qualifier("bDataSource") DataSource bDataSource,
    		EntityManagerFactoryBuilder builder) {
        return builder //
        .dataSource(bDataSource) //
        .packages(Book.class) //
        .persistenceUnit("bDs") //
        .build();
    }

	@Bean("bTransactionManager")
	public PlatformTransactionManager bTransactionManager(
	        @Qualifier("bEntityManagerFactory") LocalContainerEntityManagerFactoryBean bEntityManagerFactory) {
	    return new JpaTransactionManager(bEntityManagerFactory.getObject());
	}

}