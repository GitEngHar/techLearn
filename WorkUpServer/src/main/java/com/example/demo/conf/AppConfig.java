package com.example.demo.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 設定のアノテーション 起動時の1回だけJavaコンテナに登録される
@Configuration
@ConditionalOnProperty(name = "beantest.enable",havingValue = "true")
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
