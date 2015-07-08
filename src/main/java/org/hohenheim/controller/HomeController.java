package org.hohenheim.controller;

import java.util.List;

import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.posting.Post;
import org.hohenheim.model.entity.posting.UserPost;
import org.hohenheim.services.GroupService;
import org.hohenheim.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController implements IController{
    
    @Autowired
    GroupService groupService;
    @Autowired 
    UserService userService;
    
//    @RequestMapping(method = RequestMethod.GET, value = "/profil")
//    public String action(){
//	
//	//TODO: checken ob benutzerkonto in der session liegt
//	System.out.println("hi");
//	
//	return "profil";
//    }
    
    @RequestMapping(method=RequestMethod.GET, value="/profil")
   	public ModelAndView showGroups() {
   		
   		//List<LGroup> groups = groupService.getUsersGroups(groupService.getUsernameOfCurrentUser());
//   		List<Post> posts = userService.getCurrentUserObject().createdPosts;
   		ModelAndView mv = new ModelAndView();
   	//	mv.addObject("groups", groups);
//   		mv.addObject("posts", posts);
   		return mv;
   	}
    
    @RequestMapping(method=RequestMethod.GET, value="/gruppenwahl/${aktuelleGruppe.name}")
	public String gruppeAusgewaehlt(@PathVariable("name") String name) {
	
		
		System.out.println("gruppe ausgewaehlt: "+name);
		//bestimmte gruppe auswählen
		return "gruppe";
	}
    
    @RequestMapping(value="/suche")
    public String suche() {
        return "suche";
    }
    
    @RequestMapping(value="/sucheStarten")
    public String sucheStarten() {
        // TODO: nach gruppen und personen suchen, die dem model Ã¼bergeben und anzeigen
        return "suche";
    }
     
}
