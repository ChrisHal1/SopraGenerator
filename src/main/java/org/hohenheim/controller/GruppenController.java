package org.hohenheim.controller;

import java.util.List;

import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.repository.UserRepository;
import org.hohenheim.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GruppenController implements IController {
    
    @Autowired
	GroupService groupService;

    @RequestMapping(value = "/gruppeAnlegenImProfil", method = RequestMethod.GET)
    public String gruppeAnlegenImProfil() {
	// TODO Auto-generated method stub
	return "gruppeAnlegen";
    }

//    @RequestMapping(value = "/gruppeAnlegen", method = RequestMethod.GET)
//    public String gruppeAnlegen() {
//	// TODO Auto-generated method stub
//	// gruppe der db hinzufügen, neue gruppe anzeigen
//	return "gruppe";
//    }

    @RequestMapping(value = "/gruppeAnlegenImProfil", method = RequestMethod.POST)
    public String gruppeAnlegenPost(@ModelAttribute("gruppenname") String gruppenname,
	    @ModelAttribute("beschreibung") String beschreibung,
	    @ModelAttribute("lernfach") String lernfach,
	    @ModelAttribute("themengebiet") String themengebiet,
	    BindingResult resutlt) {
	// TODO gruppe anlegen mit service
	System.out.println(gruppenname);
	System.out.println(beschreibung);
	System.out.println(lernfach);
	System.out.println(themengebiet);
	return "gruppe";
    }
    
    @RequestMapping(value = "/nutzerDerGruppeHinzufuegen", method = RequestMethod.POST)
    public String neuenNutzerDerGruppeHinzufuegen(@ModelAttribute("nutzerDerGruppeHinzufuegen") String nutzername,
	    BindingResult resutlt) {
	// TODO prüfen ob gruppe schon voll ist, falls ja, nachricht, sonst: nutzer hinzufügen

	return "gruppe";
    }
    
    
    @RequestMapping(value = "/diskussionErstellen", method = RequestMethod.POST)
    public String diskussionErstellen(@ModelAttribute("titleOfDiscussion") String titleOfDiscussion,
	    BindingResult resutlt) {
	// TODO neuer GroupPost
	
	
	return "gruppe";
    }
    
   
}
