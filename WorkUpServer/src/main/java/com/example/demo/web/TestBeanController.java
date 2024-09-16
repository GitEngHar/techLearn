package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BeanService;
import com.example.demo.service.HelloBean;

@RestController
@RequestMapping("/")
public class TestBeanController {
	// ComponentでBean化した HelloBean をDIする
	@Autowired
	HelloBean helloBean;
	
	// Config BeanでBean化した Bean1 をDIする
	@Autowired
	@Qualifier("bean1")
	String bean1;
	
	// Config BeanでBean化した Bean2 をDIする
	@Autowired
	@Qualifier("bean2")
	String bean2;
	
	
	@Autowired
	BeanService beanService;
	
	/* HelloBeanの動作を確認する */
	@GetMapping("")
	public String rootHandler() {
		helloBean.hello();
		return "OK";
	}
	
	/* メソッド単位でBean化したクラスの動作確認(Bean1) */
	@GetMapping("bean1")
	public String bean1Handler() {
		System.out.println(this.bean1);
		return this.bean1;
	}
	
	/* メソッド単位でBean化したクラスの動作確認(Bean2) */
	@GetMapping("bean2")
	public String bean2Handler() {
		System.out.println(this.bean2);
		return this.bean2;
	}
	
	@GetMapping("beanrep")
	public String beanRepositoryHandler() {
		String beanText = beanService.getTestBeanById().getBeantext();
		System.out.println(beanText);
		return beanText;
	}
}
