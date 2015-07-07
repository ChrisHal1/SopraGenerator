package org.hohenheim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GruppenController implements IController {

    @RequestMapping("/gruppeAnlegenImProfil")
    public String gruppeAnlegenImProfil() {
	// TODO Auto-generated method stub
	return "gruppeAnlegen";
    }

    @RequestMapping("/gruppeAnlegen")
    public String gruppeAnlegen() {
	// TODO Auto-generated method stub
	//gruppe der db hinzufügen, neue gruppe anzeigen
	return "gruppe";
    }
  
}
