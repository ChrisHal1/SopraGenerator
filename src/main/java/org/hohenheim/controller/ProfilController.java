package org.hohenheim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfilController implements IController {

    @RequestMapping("/login")
    public String action() {

	// TODO bentutzerkonto bei korrektheit in die session legen
	return "profil";
    }

}