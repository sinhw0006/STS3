package com.example.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.app.config.auth.PrincipalDetailsService;
import com.example.app.config.auth.exceptionHandler.CustomAccessDeniedHandler;
import com.example.app.config.auth.exceptionHandler.CustomAutenticationEntryPoint;
import com.example.app.config.auth.loginHandler.CustomFailureHandler;
import com.example.app.config.auth.loginHandler.CustomLoginSuccessHandler;
import com.example.app.config.auth.logoutHandler.AddLogoutHandler;
import com.example.app.config.auth.logoutHandler.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PrincipalDetailsService principalDetailsService;
	
	@Autowired
	DataSource dataSource3;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		//권한체크
		http
			.authorizeRequests()
			.antMatchers("/","/join","/login").permitAll()
			.antMatchers("/user").hasRole("USER")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/admin").hasRole("ADMIN")
			.anyRequest()
			.authenticated();
		
		//로그인
		http.formLogin()
		.loginPage("/login")
		.successHandler(new CustomLoginSuccessHandler())
		.failureHandler(new CustomFailureHandler())
		.permitAll();
		
		//로그아웃
		http.logout()
		.addLogoutHandler(new AddLogoutHandler())
		.logoutSuccessHandler(new CustomLogoutSuccessHandler())
		.permitAll();
		
		//예외처리
		
		http.exceptionHandling()
			.authenticationEntryPoint(new CustomAutenticationEntryPoint()) // 미인증 예외처리
			.accessDeniedHandler(new CustomAccessDeniedHandler()); // 권한부족 예외처리
		
		http.rememberMe()
		.key("rememberMeKey")
		.rememberMeParameter("remember-me")
		.alwaysRemember(false)
		.tokenValiditySeconds(60*60*24)
		.tokenRepository(null);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl reop = new JdbcTokenRepositoryImpl();
		reop.setDataSource(dataSource3);
		return null;
	}

}
