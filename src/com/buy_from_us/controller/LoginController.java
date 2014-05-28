package com.buy_from_us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.buy_from_us.form.Authentication;
import com.buy_from_us.form.UserFormBacker;
import com.buy_from_us.model.Category;
import com.buy_from_us.service.ProductService;
import com.buy_from_us.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/welcome")
	public String getData(){
		return "log-in";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request){
		request.getSession().invalidate();
		return "log-in";
	}
	
	@RequestMapping(value="/log-in",method=RequestMethod.POST)
	public String validateLogin(HttpServletRequest request, 
			UserFormBacker user, Model model){
		String username = user.getUsername();
		String password = user.getPassword();
		
		Authentication auth = 
				userService.isUserAuthenticated(username, password);
		
		model.addAttribute("authMessage", auth.getMessage());
		model.addAttribute("role",auth.getRole());
		
		String landingPage = auth.getLandingPage(); 
		//if ("view-products".equals(landingPage)) {
			List<Category> categoryList = productService.getAllCategoies();
			model.addAttribute("categoryList", categoryList);
		//}
		
		if (auth.isSuccessful()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
		}
			
		return landingPage;
	}	

}
