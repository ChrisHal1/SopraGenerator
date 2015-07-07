package org.hohenheim.model.entity.posting;

import javax.persistence.*;
import org.hohenheim.model.entity.user.User;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * UserPost-Entity-Class.
 */


@Entity
public class UserPost extends Post {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public UserPost(User createdBy, User recipient){
		super(createdBy);
		
		/*Instantiate Relations*/
		this.recipient = recipient;
	}


	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public User recipient;
	

	/*
	 * Methods 
	 *******************/

}
