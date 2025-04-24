package com.ex00.init.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/aa")
	public String aa() {
		
		return "{\"message\": \"Test\"}";
	}
}
