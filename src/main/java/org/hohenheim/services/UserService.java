package org.hohenheim.services;

import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.*;
import org.hohenheim.util.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

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
	
	public User getUserByUsername(String name){
		return this.userRepository.getByUniqueAttribute("username", name);
	}
	
	public void blockUser(String name){
		this.userRepository.getByUniqueAttribute("username", name).block();
	}
}
