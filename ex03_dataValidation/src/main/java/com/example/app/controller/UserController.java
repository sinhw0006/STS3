package com.example.app.controller;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@InitBinder
	public void datebinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthDayBinder());
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneBinder());
	}

	@GetMapping("/join")
	public void join() {
		log.info("GET /join..");
	}

	@PostMapping("/join")
	public void join_post(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
		log.info("Post /join.." + userDto);
		if (!userDto.getPassword().equals(userDto.getRePassword())) {
			model.addAttribute("rePassword", "패스워드가 일치하지 않습니다.");
		}
		for (FieldError error : bindingResult.getFieldErrors()) {
			model.addAttribute(error.getField(), error.getDefaultMessage());
		}
	}

	public class BirthDayBinder extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if(text.isEmpty()) {
				text = LocalDate.now().toString();
			}
			LocalDate birthDay = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy~MM~dd"));
			setValue(birthDay);
		}
	}

	public class PhoneBinder extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if(text.isEmpty()) {
				text = "010-1234-5678";
			}
			String phone = text.replaceAll("-", "");
			setValue(phone);
		}
	}
}
