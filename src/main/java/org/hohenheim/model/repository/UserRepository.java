package org.hohenheim.model.repository;

import org.hohenheim.model.entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {

	public UserRepository(){
		super();
	}
}
