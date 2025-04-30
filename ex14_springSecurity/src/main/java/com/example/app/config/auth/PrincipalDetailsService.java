package com.example.app.config.auth;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userMapper.selectAt(username);
		if(userDto==null)
			throw new UsernameNotFoundException(username + "은 존재하지 않는 계정입니다.");
		return new PrincipalDetails(userDto);
	}
	
}
