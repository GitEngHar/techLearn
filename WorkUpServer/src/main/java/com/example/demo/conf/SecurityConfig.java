package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// 設定のアノテーション 起動時の1回だけJavaコンテナに登録される
@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login // フォーム認証を使う
				.permitAll()).authorizeHttpRequests(authz -> authz
					.requestMatchers("/rest/**").permitAll() // restAPI関連は認証不要
					.requestMatchers("/").permitAll() // トップページは認証不要
					.requestMatchers("/tran/**").permitAll() // restAPI関連は認証不要
					.anyRequest().authenticated() // 他のURLは認証必要
						);
		return http.build();
	}
}
