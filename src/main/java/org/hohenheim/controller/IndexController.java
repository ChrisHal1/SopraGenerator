package org.hohenheim.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* @Controller Class
 * @Last Updated: 07.07 13:03 by @Simon
 * @Description:
 * Index Controller class, handles requests for home(index) page.
 */

@Controller
public class IndexController implements IController {

	@Autowired
	private GroupService groupService;

	/*
	 * landing page with automatic login.
	 */
	@RequestMapping(value = "/")
	public String index(Model model) {

		//this.groupService.createGroup("mygroup");
		model.addAttribute("user", groupService.getCurrentUserObject());

		return "index";
	}

	/*
	 * Get all groups of a specific user.
	 */
	@ModelAttribute("userGroups")
	public List<LGroup> getUserGroups() {
		return this.groupService.getUsersGroups(this.groupService.getUsernameOfCurrentUser());
	}

	/*
	 * 1. Get all groups, except those a specific user is already a member of OR
	 * 2. If a search parameter has been specified in the request, only groups matching the pattern are returned.
	 */
	@ModelAttribute("openGroups")
	public List<LGroup> getOpenGroups(HttpServletRequest request) {
		if (request.getParameter("key") != null && request.getParameter("key") != "")
			return this.groupService.search(request.getParameter("key"));
		else
			return this.groupService.getOpenGroups(this.groupService.getUsernameOfCurrentUser());
	}

}