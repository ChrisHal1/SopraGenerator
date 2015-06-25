package org.hohenheim.model.repository;

import org.hohenheim.model.entity.education.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository extends BaseRepository<Group> {

	public GroupRepository(){
		super();
	}
}
