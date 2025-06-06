package com.ex00.init.DiTests;


import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ex00.init.config.PersonCompoent;
import com.ex00.init.domain.DTO.PersonDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DiTests {

	@Autowired
	PersonDTO personDTO1;
	
	@Autowired
	PersonDTO person03;
	
	@Autowired
	PersonDTO p04;
	
	@Autowired
	PersonCompoent personCompoent;
	
	
//	@Test
//	void test() {
//		System.out.println(person03);
//		System.out.println(personDTO1);
//		System.out.println(p04);
//		System.out.println(personCompoent);
//	}
	
	@Autowired
	private ApplicationContext applicationContext;
	@Test
	public void test2() {
		assertNotNull(applicationContext);
		System.out.println(applicationContext.getBean("personDTO1"));
	}
	

}
