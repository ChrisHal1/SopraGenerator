package org.hohenheim.model.entity.posting;

import javax.persistence.*;

import org.hohenheim.model.entity.education.LGroup;
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
	public GroupPost(User createdBy, LGroup group){
		super(createdBy);
		
		/*Instantiate Relations*/
		this.inGroup = group;
	}

	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public LGroup inGroup;
	

	/*
	 * Methods
	 *******************/
}
