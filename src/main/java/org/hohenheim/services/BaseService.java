package org.hohenheim.services;

import javax.servlet.http.HttpSession;

import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/* @Service base class
 * @Last Updated: 04.07 12:15 by @Simon
 * @Description:
 *
 * Service base class
 * This class serves as superclass for all services. Services provide logic used by controllers,
 * and function as a bridge between controllers and repositorys (database).
 * Put everything that manipulates data in a service.
 * This class can not be instantiated. Work with subservices (Services for particular tasks,
 * e.g. profilservice or loginservice instead.
 */

@Service
public class BaseService {
	
	@Autowired
	private HttpSession http;
	
	@Autowired
	private UserRepository userRepository;
	
	protected BaseService() {
		
	}
	
	public UserDetails currentUser(){
		return (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public String getUsernameOfCurrentUser(){
		return this.currentUser().getUsername();
	}
	
	public User getCurrentUserObject(){
		try{
			return this.userRepository.getByUniqueAttribute("username", getUsernameOfCurrentUser());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
