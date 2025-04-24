package com.ex00.init.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ex00.init.domain.DTO.PersonDTO;

@Configuration
public class PersonDTOBeanConfig {
	
	@Bean
	public PersonDTO person03() {
		
		return PersonDTO.builder()
				.age(11235)
				.username("aa")
				.addr("315")
				.build();
		
		//return new PersonDTO("김박사", 44, "서울");
	}
	@Bean(name = "p04")
	public PersonDTO person04() {
		return new PersonDTO("박효신", 40, "대구");
	}
}
