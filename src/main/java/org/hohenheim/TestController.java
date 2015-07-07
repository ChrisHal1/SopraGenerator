package org.hohenheim;

import org.hibernate.SessionFactory;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.services.BaseService;
import org.hohenheim.util.ROLE;
import org.hohenheim.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public String hi(
	    @RequestParam(value = "name", required = false, defaultValue = "World") String name,
	    Model model) {
	
    
	User usr = new User("Test", "hallo", "simon.schoenwaelder@mx.de", ROLE.ROLE_ADMIN);
	//model.addAttribute("name", t);
	return "index";
    }
}
