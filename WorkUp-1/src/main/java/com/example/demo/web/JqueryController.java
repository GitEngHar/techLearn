package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.JqueryEntity;
import com.example.demo.service.JqueryService;
@RequestMapping("jq")	
@Controller
public class JqueryController {
	@Autowired
	JqueryService jqueryService;
		
	@GetMapping("")
	public String top(Model model) {
		JqueryForm jqForm = new JqueryForm();
		model.addAttribute("jqueryform", jqForm);
		return "index";
	}
	
	@PostMapping("/postdata")
	public String resultData(@ModelAttribute JqueryForm jqForm
			,Model model) {
		System.out.println(jqForm.getName());
		return "redirect:/jq";
	}
	
	//DBの挙動確認用
	@GetMapping("/confjqdb")
	public String ConfirmJqueryDB() {
		// Serviceクラスでオブジェクト取得
		JqueryEntity jqData = jqueryService.getjqData(1);
		System.out.println(jqData);
		return "redirect:/jq";
	}
	
	//ajaxリダイレクト確認用
	@GetMapping("/confajax")
	public String ConfirmJqueryDB(Model model) {
		return "confajax";
	}
	
	// cacheの値更新
//	@PostMapping("/updatecache/{@status}")
//	public String (Model model) {
//		return "confajax";
//	}
}
