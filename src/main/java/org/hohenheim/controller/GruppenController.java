package org.hohenheim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GruppenController implements IController {

    @RequestMapping("/gruppeAnlegen")
    public String action() {
	// TODO Auto-generated method stub
	return "gruppeAnlegen";
    }

  
}
