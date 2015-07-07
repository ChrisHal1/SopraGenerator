package org.hohenheim.services;

import java.util.*;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.*;
import org.hohenheim.util.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

/* @Service class
 * @Last Updated: 07.07 14:15 by @Simon
 * @Description:
 *
 * User Service class
 * This service provides methods to manage users. It uses the UserRepository to interact with the database.
 */

@Service
public class UserService extends BaseService {

	@Autowired
	UserRepository userRepository;
	
	UserService(){
		super();
	}
	
	public boolean createUser(String username, String email, String password, boolean isAdmin){
		try{
			User user = new User(username, email, password, (isAdmin ? ROLE.ROLE_ADMIN : ROLE.ROLE_USER));
			return this.userRepository.save(user);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean addInfoToUser(User user, int age, String description, ArrayList<String> interests){
		if(interests == null)
			interests = user.interests;
		if(description.length() > 2048)
			return false;
		if(age < 14 || age > 99)
			return false;
		
		user.setAdditionalInfo(age, description, interests);
		return true;
	}
	
	public User getUserByUsername(String name){
		try {
			return this.userRepository.getByUniqueAttribute("username", name);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void blockUser(String name){
		try {
			this.userRepository.getByUniqueAttribute("username", name).block();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
