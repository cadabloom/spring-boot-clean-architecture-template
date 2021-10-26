package com.cadabloom.app;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import com.cadabloom.infrastructure.persistence.configuration.PersistenceConfiguration;

import core.features.product.commands.deleteallproduct.DeleteAllProductCommandHandler;
import core.features.product.queries.getproductdetail.GetProductDetailQueryHandler;
import core.mediatior.RequestMediator;
import core.mediatior.RequestHandler;
import core.mediatior.TestHandler;

@SpringBootApplication
@Import(PersistenceConfiguration.class)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory -> {
            genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
        };
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("core.contracts", "com.cadabloom.infrastructure", "core.features");
    }

    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
            .getClassName()
            .endsWith("Model");
    }
    
    @Bean
    RequestMediator Mediator(List<RequestHandler> requestHandlers) {
    	List<RequestHandler> handlers = new ArrayList<>();
    	handlers.addAll(requestHandlers);
		handlers.add(new TestHandler()); //remove this line later, for demo purposes only
		RequestMediator mediator = new RequestMediator(handlers);
		return mediator;
    }

}
