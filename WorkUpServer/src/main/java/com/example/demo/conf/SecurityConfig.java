package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 設定のアノテーション 起動時の1回だけJavaコンテナに登録される
@Configuration
public class SecurityConfig {
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	InMemoryUserDetailsManager userDetailsService() {
//		
//		UserDetails admin = User
//				.withUsername("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//		UserDetails hoge = User
//				.withUsername("hoge2")
//				.password(passwordEncoder().encode("hoge2"))
//				.roles("USER")
//				.build();
//		
//		System.out.printf("admin -> [%s]\n", passwordEncoder().encode("admin"));
//		System.out.printf("hoge2 -> [%s]\n", passwordEncoder().encode("hoge2"));
//		
//		return new InMemoryUserDetailsManager(admin,hoge);
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login // フォーム認証を使う
				.permitAll()).authorizeHttpRequests(authz -> authz
					.requestMatchers("/rest/**").permitAll() // restAPI関連は認証不要
					.requestMatchers("/").permitAll() // トップページは認証不要
					.requestMatchers("/tran/**").permitAll() // restAPI関連は認証不要
					.requestMatchers("/adminpage/**").hasRole("ADMIN")
					.requestMatchers("/hogepage/**").hasRole("ADMIN")
					.requestMatchers("/hogepage/**").hasRole("USER")
					.anyRequest().authenticated() // 他のURLは認証必要
						);
		return http.build();
	}
	
}
