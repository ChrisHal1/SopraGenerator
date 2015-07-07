package org.hohenheim.model.repository;

import org.hohenheim.model.entity.posting.GroupPost;
import org.springframework.stereotype.Repository;

@Repository
public class GroupPostRepository extends BaseRepository<GroupPost> {

	public GroupPostRepository(){
		super(); 
	}
}
