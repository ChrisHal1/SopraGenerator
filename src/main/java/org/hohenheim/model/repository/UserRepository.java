package org.hohenheim.model.repository;

import org.hohenheim.model.entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/* @Repository class
 * @Last Updated: 07.07 14:24 by @Simon
 * @Description:
 *
 * User Repository
 * This Repository provides methods to manage Users within the database.
 * 
 *
 */

@Transactional
@Repository
public class UserRepository extends BaseRepository<User> {

	public UserRepository() {
		super();
	}

}
