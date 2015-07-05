package org.hohenheim.model.repository;

import org.hohenheim.model.entity.posting.UserPost;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostRepository extends BaseRepository<UserPost> {

	public UserPostRepository(){
		super();
	}
}
