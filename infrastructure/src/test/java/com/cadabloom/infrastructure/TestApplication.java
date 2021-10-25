package com.cadabloom.infrastructure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cadabloom.infrastructure.persistence.configuration.PersistenceConfiguration;

@SpringBootApplication
@Import(PersistenceConfiguration.class)
public class TestApplication {

}
