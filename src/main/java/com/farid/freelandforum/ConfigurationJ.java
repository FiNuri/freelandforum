package com.farid.freelandforum;


import com.farid.freelandforum.dao.HikariCp;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationJ {

    @Bean()
    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("${database.url}");
        hikariConfig.setUsername("${database.username}");
        hikariConfig.setPassword("${database.password}");

        return hikariConfig;
    }

    @Bean
    public HikariCp hikariCp(HikariConfig hikariConfig){
        return new HikariCp(hikariConfig);
    }
}
