package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.entities.Product;
import com.niit.entities.User;

@Controller
public class HelloController {
	@RequestMapping({ "/", "home" })
	public String mainpage() {
		return "index";
	}

	@RequestMapping("/Contact")
	public String contactpage() {
		return "Contact";
	}

	@RequestMapping("/About")
	public String aboutpage() {
		return "About";
	}
	

	@RequestMapping({ "/Register", "NewUser" })
	public String registerpage(Model model1) {
		model1.addAttribute("user", new User());
		return "Register";
	}

	@RequestMapping("/RegSuccess")
	public String regsuccess() {
		return "RegSuccess";
	}

	@RequestMapping("/NewProd")
	public String newproduct(Model model) {
		model.addAttribute("product", new Product());
		return "AddProduct";
	}
}
