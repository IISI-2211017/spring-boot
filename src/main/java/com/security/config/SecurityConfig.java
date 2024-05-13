package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public AuthenticationProvider authenticationProvider(
	            UserDetailsService userDetailsService,
	            BCryptPasswordEncoder passwordEncoder
	    ) {
	        var provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService);
	        provider.setPasswordEncoder(passwordEncoder);
	        return provider;
	    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(registry -> {
//	            registry.requestMatchers(HttpMethod.POST, "/users").permitAll();
//	            registry.requestMatchers(HttpMethod.GET, "/users/?*").hasAnyAuthority("ADMIN", "NORMAL");
//	            registry.requestMatchers(HttpMethod.GET, "/users").hasAuthority("ADMIN");
	            registry.anyRequest().permitAll();
	        })
	        .csrf(AbstractHttpConfigurer::disable);  // 禁用 CSRF 防護
//	        .formLogin();  // 開啟內建登入頁面 (僅用於測試)
	    return http.build();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}