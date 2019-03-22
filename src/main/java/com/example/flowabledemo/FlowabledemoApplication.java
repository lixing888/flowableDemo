package com.example.flowabledemo;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author lixing
 */
@SpringBootApplication
public class FlowabledemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowabledemoApplication.class, args);
	}

	@Bean
	public InitializingBean initializingBean(RepositoryService repositoryService) {
		return () -> {
			List<Deployment> list = repositoryService.createDeploymentQuery().list();
			// where '1' is expected
			System.err.println("Deployment size: " + list.size());
		};
	}


}
