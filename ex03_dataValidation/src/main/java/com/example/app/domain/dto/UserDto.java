package com.example.app.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	@NotBlank(message="userid 를 입력하세요")
	@Size(min = 2,max = 10,message = "최소 2글자에서 최대 10글자를 입력해주세요")
	private String userid;		//유저ID
	
	@NotBlank(message="password 를 입력하세요")
	private String password;	//패스워드
	
	@NotBlank(message="rePassword 를 입력하세요")
	private String rePassword;	//패스워드확인
	
	@NotBlank(message="username 를 입력하세요")
	private String username;	//유저이름
	
	@NotBlank(message="phone 를 입력하세요")
	@Pattern(regexp = "^01[016789]-\\d{3,4}-\\d{4}$", message = "유효한 전화번호 형식이 아닙니다.")
	private String phone;		//전화번호
	
	@NotBlank(message="zipcode 를 입력하세요")
	@Size(min = 5, max = 5, message = "유효한 우편번호가 아닙니다.")
	private String zipcode;		//우편번호
	
	@NotBlank(message="addr1 를 입력하세요")
	private String addr1;		//기본주소
	
	@NotBlank(message="addr2 를 입력하세요")
	private String addr2;		//상세주소
	
	@NotNull(message="birthday 를 입력하세요")
	@Past(message = "유효하지 않은 생일 입니다.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthday;	//생년월일(yyyy-MM-dd)
}
