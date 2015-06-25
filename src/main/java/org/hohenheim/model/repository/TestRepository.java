package org.hohenheim.model.repository;

import org.hohenheim.model.entity.education.Test;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends BaseRepository<Test> {

	public TestRepository(){
		super();
	}
}
