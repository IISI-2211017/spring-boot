package com.multiDB.a.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multiDB.a.dao.ProductDao;
import com.multiDB.a.entity.Product;

@Configuration
@EnableJpaRepositories( //
	basePackageClasses = ProductDao.class, //
	entityManagerFactoryRef = "aEntityManagerFactory", //
	transactionManagerRef = "aTransactionManager"
)
@EnableTransactionManagement
public class Aconfig {

	@Bean("aDataSource")
	@Primary
	@ConfigurationProperties("app.datasource.a")
	public DataSource aDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("aEntityManagerFactory")
	@Primary
    public LocalContainerEntityManagerFactoryBean aEntityManagerFactory(
    		@Qualifier("aDataSource") DataSource aDataSource,
    		EntityManagerFactoryBuilder builder) {
        return builder //
        .dataSource(aDataSource) //
        .packages(Product.class) //
        .persistenceUnit("aDs") //
        .build();
    }

	@Bean("aTransactionManager")
	@Primary
	public PlatformTransactionManager aTransactionManager(
	        @Qualifier("aEntityManagerFactory") LocalContainerEntityManagerFactoryBean aEntityManagerFactory) {
	    return new JpaTransactionManager(aEntityManagerFactory.getObject());
	}

}