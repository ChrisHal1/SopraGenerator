package org.hohenheim.services;

import java.util.*;

import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.UserRepository;
import org.hohenheim.util.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* @Service class
 * @Last Updated: 07.07 14:15 by @Simon
 * @Description:
 *
 * Game Service class
 * This service provides methods to manage all game-related things. It uses several Repositories to interact with the database.
 */

@Service
public class GameService extends BaseService {

	@Autowired
	UserRepository userRepository;
	
	public GameService() {
		super();
	}
	
	/*
	 * Get the leaderboard (List of Users ordered by their points, beginning with the highest one.
	 */

	public List<User> Leaderboard(){
		try{
			return this.userRepository.getAllObjectsFromTable(ORDER.POINTS);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ArrayList<User>();
		}
	}
}
