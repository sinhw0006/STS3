package com.ex00.init.Controller;

import javax.swing.text.LayeredHighlighter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class SimpleController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		log.info("GET /test1...");
	}
	
	@GetMapping("/test2")
	public String test2() {
		log.info("GET /test2...");
		return "test/abcd";
	}
	
	@RequestMapping(value = "/test3", method = {RequestMethod.GET,RequestMethod.POST})
	public void test3() {
		log.info("GET /test3...");
	}
	@DeleteMapping("/delete")
	public void test4() {
		log.info("GET /test3...");
	}
}
