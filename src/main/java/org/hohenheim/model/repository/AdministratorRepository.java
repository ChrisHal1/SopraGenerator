package org.hohenheim.model.repository;

import org.hohenheim.model.entity.user.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorRepository extends BaseRepository<Administrator> {

	public AdministratorRepository(){
		super();
	}
}
