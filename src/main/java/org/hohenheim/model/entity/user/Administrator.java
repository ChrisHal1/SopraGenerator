package org.hohenheim.model.entity.user;

import javax.persistence.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Administrator-Entity-Class.
 */

@Entity
public class Administrator extends User {

	/*
	 * Fields
	 *******************/
	public boolean isAdmin = true;
	

	/*
	 * Constructor
	 *******************/
	public Administrator(String name, String email, String password){
		super(name, email, password);
	}


	/*
	 * Relation mapping
	 *******************/


	/*
	 * Methods
	 *******************/

}
