package org.hohenheim.model.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hohenheim.model.entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository extends BaseRepository<User> {

	public UserRepository() {
		super();
	}

}
