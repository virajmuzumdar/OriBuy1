package com.niit.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.entities.Product;
import com.niit.entities.User;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAOImpl;
	
	@ModelAttribute
	public Product initProduct()
	{
		return new Product();
	}

	@RequestMapping("/saveproduct")
	public ModelAndView submitForm(@ModelAttribute Product product) {
		productDAOImpl.addProduct(product);
		return new ModelAndView("redirect:/ViewProducts");
	}
	
	@RequestMapping("/ViewProducts")
	public ModelAndView viewproducts() {
		List<Product> list = productDAOImpl.getProducts();
		ModelAndView model = new ModelAndView("ViewProducts");
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = "/editproduct", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model) {
		Product product = productDAOImpl.getProdById(id);
		model.addAttribute("product", product);
		return ("EditProduct");
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("product") Product P,@RequestParam("id") int id) {
		productDAOImpl.update(P, id);
		return new ModelAndView("redirect:/ViewProducts");
	}

	@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
	public String deleteprod(@RequestParam("id") int id) {
		productDAOImpl.delete(id);
		return ("redirect:/ViewProducts");
	}
}
