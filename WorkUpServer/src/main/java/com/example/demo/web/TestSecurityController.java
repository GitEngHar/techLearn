package com.example.demo.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.SecretInfomation;
import com.example.demo.service.SecretInfomationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class TestSecurityController {
	private final SecretInfomationService secretInfomationService;
	
	@GetMapping("")
	public String indexHandler() {
		return "top";
	}
	
	@GetMapping("hogepage")
	public String hogePageHandler() {
		return "hoge";
	}
	
	@GetMapping("adminpage")
	public String adminPageHandler() {
		return "admin";
	}
	
	@GetMapping("secretpage")
	public String secretPageHandler(Model model,@AuthenticationPrincipal UserDetails user) {
		// ユーザー権限検査(Adminであるか)
		boolean isAdmin = user.getAuthorities().stream()
			      .anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()));
		SecretInfomation secretInfomation = isAdmin ? secretInfomationService.getSecretInfo() : new SecretInfomation(0,"閲覧不可能");
		model.addAttribute("secretInfomation",secretInfomation);
		return "secret";
	}
	

	
}
