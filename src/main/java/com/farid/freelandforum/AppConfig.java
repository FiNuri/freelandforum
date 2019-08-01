package com.farid.freelandforum;


import com.farid.freelandforum.dao.HikariCp;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${database.className}")
    private String driverClassName;
    @Value("${database.url}")
    private String jdbcURL;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        return new PropertyPlaceholderConfigurer();
    }

    @Bean
    public HikariConfig hikariConfig(){

        HikariConfig  hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(jdbcURL);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return  hikariConfig;

    }

    @Bean
    public HikariCp hikariCp(){
        return new HikariCp(hikariConfig());
    }
}
