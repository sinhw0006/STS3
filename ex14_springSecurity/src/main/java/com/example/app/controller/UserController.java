package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.config.auth.PrincipalDetails;
import com.example.app.domain.dto.UserDto;
import com.example.app.domain.service.UserServiceImpl;
import com.mysql.cj.Session;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("UserController dataBinder ..." + webDataBinder);
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneEditor());
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthdayEditor());
	}
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join..");
		
	}
	@PostMapping("/join")
	public String join_post(@Valid UserDto dto,BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
		log.info("POST /join.." + dto);
		
		for(FieldError error : bindingResult.getFieldErrors()) {
			log.info("Error Field : "+error.getField()+" Error Msg : "+error.getDefaultMessage());
			model.addAttribute(error.getField(),error.getDefaultMessage());
			return "/join";
		}
		boolean isJoin = userServiceImpl.userJoin(dto);
		
		if(isJoin) {
			redirectAttributes.addFlashAttribute("message","회원가입 성공");
			return "redirect:/login";
		} else {
			return "/join";
		}
		
	}
	
	private static class PhoneEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			text=text.replaceAll("-", "");
			setValue(text);
		}
		
	}
	
	private static class BirthdayEditor extends PropertyEditorSupport{

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			LocalDate date = null;
			if(text.isEmpty()) {
				date = LocalDate.now();
			}else {
				//yyyy#MM#dd -> yyyy-MM-dd(LocalDate format)
				text = text.replaceAll("~", "-");
				date = LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));		
			}
			
			setValue(date);
		}
	}
	
//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal Principal principal) {
//		log.info("user Page..." + principal);
//	}
	@GetMapping("/user")
	public void user(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Value : "+authentication.getName());
		log.info("Value : "+authentication.getAuthorities());
		model.addAttribute("username",authentication.getName());
		model.addAttribute("auth", authentication);
	}
	
	@GetMapping("/manager")
	public void manager() {
		log.info("user Page...");
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("user Page...");
	}
	
	@GetMapping("/login")
	public void login(HttpSession session) {
		log.info("login Page...");
		session.removeAttribute("message");
	}
}



