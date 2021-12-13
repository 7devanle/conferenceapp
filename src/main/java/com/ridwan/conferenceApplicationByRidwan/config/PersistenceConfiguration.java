package com.ridwan.conferenceApplicationByRidwan.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.username("postgres");
//        builder.password("dymond");
//        builder.url("jdbc:postgresql://localhost:5432/conference_app");
//        System.out.println("ARE THERE ANGELS IN HELL?");
//        return builder.build();
//    }
}
//jdbc:postgresql://localhost:5432/conference_app