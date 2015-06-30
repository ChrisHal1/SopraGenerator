package org.hohenheim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController implements IController{
    @RequestMapping(method = RequestMethod.GET)
    public String action(){
	
	//TODO bentutzerkonto bei korrektheit in die session legen
	return "index";
    }

   
}