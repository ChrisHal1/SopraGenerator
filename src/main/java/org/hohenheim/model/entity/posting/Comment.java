package org.hohenheim.model.entity.posting;

import javax.persistence.*;
import org.hohenheim.model.entity.user.User;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Comment-Entity-Class.
 */


@Entity
public class Comment extends Post {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public Comment(User createdBy, Post ofPost){
		super(createdBy);
		
		/*Instantiate Relations*/
		this.ofPost = ofPost;
	}
	

	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Post ofPost;

	
	/*
	 * Methods
	 *******************/
}
