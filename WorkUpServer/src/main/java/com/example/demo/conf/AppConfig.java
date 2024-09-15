package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 設定のアノテーション 起動時の1回だけJavaコンテナに登録される
@Configuration
public class AppConfig {
	
	// メソッド単位でBeanを登録する
	@Bean(name = "bean1")
	public String bean1() {
		return "Bean1";
	}
	
	@Bean(name = "bean2")
	public String bean2() {
		return "Bean2";
	}
	
}
