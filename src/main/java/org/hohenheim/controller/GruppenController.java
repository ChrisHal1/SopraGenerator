package org.hohenheim.controller;

import org.hohenheim.services.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GruppenController implements IController {

    @RequestMapping(value = "/gruppeAnlegenImProfil", method = RequestMethod.GET)
    public String gruppeAnlegenImProfil() {
	// TODO Auto-generated method stub
	return "gruppeAnlegen";
    }

    @RequestMapping(value = "/gruppeAnlegen", method = RequestMethod.GET)
    public String gruppeAnlegen() {
	// TODO Auto-generated method stub
	// gruppe der db hinzufügen, neue gruppe anzeigen
	return "gruppe";
    }

    @RequestMapping(value = "/gruppeAnlegenImProfil", method = RequestMethod.POST)
    public String gruppeAnlegenPost(@ModelAttribute("gruppenname") String gruppenname,
	    @ModelAttribute("beschreibung") String beschreibung,
	    @ModelAttribute("lernfach") String lernfach,
	    @ModelAttribute("themengebiet") String themengebiet,
	    BindingResult resutlt) {
	// TODO Auto-generated method stub
	System.out.println(gruppenname);
	System.out.println(beschreibung);
	System.out.println(lernfach);
	System.out.println(themengebiet);
	return "gruppe";
    }
}
