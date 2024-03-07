package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Pet;
/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 5, 2024
 */

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Pet pet() {
		Pet bean = new Pet("Dog", "Oreo", "Me");

		return bean;
	}
}
