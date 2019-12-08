package com.farid.freelandforum;


import com.farid.freelandforum.dao.HikariCp;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String jdbcURL;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("spring.datasource.password")
    private String password;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        return new PropertyPlaceholderConfigurer();
    }

    @Bean(name = "hikariConfig")
    public HikariConfig hikariConfig(){

        HikariConfig  hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcURL);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return  hikariConfig;

    }

    @Bean
    @DependsOn("hikariConfig")
    public HikariCp hikariCp(){
        return new HikariCp(hikariConfig());
    }
}
