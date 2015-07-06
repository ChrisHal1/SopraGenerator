package org.hohenheim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.services.GroupService;
import org.hohenheim.util.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController implements IController {

	@Autowired
	private GroupService groupService;

	@RequestMapping(value = "/")
	public String index(Model model) {

		User user = groupService.getCurrentUserObject();
		// Hibernate.initialize(user);
		this.groupService.createGroup("mygroup");
		model.addAttribute("user", user);
		model.addAttribute("admin", this.groupService.getCurrentUserObject().isAdmin());

		return "index";
	}

	@ModelAttribute("userGroups")
	public List<LGroup> getUserGroups() {
		return this.groupService.getUsersGroups(this.groupService.getUsernameOfCurrentUser());
	}

	@ModelAttribute("openGroups")
	public List<LGroup> getOpenGroups(HttpServletRequest request) {
		if (request.getParameter("key") != null && request.getParameter("key") != "")
			return this.groupService.search(request.getParameter("key"));
		else
			return this.groupService.getOpenGroups(this.groupService.getUsernameOfCurrentUser());
	}

}