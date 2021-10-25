package com.cadabloom.infrastructure.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.cadabloom.infrastructure.persistence")
@EnableJpaRepositories("com.cadabloom.infrastructure.persistence.repository")
@EntityScan("com.cadabloom.infrastructure.persistence")
public class PersistenceConfiguration {

}
