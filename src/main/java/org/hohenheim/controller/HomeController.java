package org.hohenheim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController implements IController{
    @RequestMapping(method = RequestMethod.GET, value = "/profil")
    public String action(){
	
	//TODO: checken ob benutzerkonto in der session liegt
	System.out.println("hi");
	
	return "profil";
    }
    
    @RequestMapping(value="/suche")
    public String suche() {
        return "suche";
    }
    
    @RequestMapping(value="/sucheStarten")
    public String sucheStarten() {
        // TODO: nach gruppen und personen suchen, die dem model übergeben und anzeigen
        return "suche";
    }
    
}