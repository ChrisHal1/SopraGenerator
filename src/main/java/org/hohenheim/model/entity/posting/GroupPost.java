package org.hohenheim.model.entity.posting;

import javax.persistence.*;

import org.hohenheim.model.entity.education.Group;
import org.hohenheim.model.entity.user.User;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * GroupPost-Entity-Class.
 */


@Entity
public class GroupPost extends Post {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public GroupPost(User createdBy, Group group){
		super(createdBy);
		
		/*Instantiate Relations*/
		this.inGroup = group;
	}

	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Group inGroup;
	

	/*
	 * Methods
	 *******************/
}
