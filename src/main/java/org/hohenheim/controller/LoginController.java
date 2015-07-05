package org.hohenheim.controller;

import java.util.List;

import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.UserRepository;
import org.hohenheim.services.GroupService;
import org.hohenheim.util.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@Autowired
	UserRepository rep;
	
	public LoginController() {
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		Model model) {
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
 
		return "login";
 
	}

}
