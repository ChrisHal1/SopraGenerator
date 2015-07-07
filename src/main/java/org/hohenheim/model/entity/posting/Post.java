package org.hohenheim.model.entity.posting;

import java.util.*;

import javax.persistence.*;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.util.helper;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Eintrag-Entity-Class. This class is abstract because you cannot create a post,
 * only group posts, user posts and comments!
 */


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Post extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(length=4096, nullable=false)
	public String content;
	@Column(length=100000)
	public Byte[] file;

	
	/*
	 * Constructor
	 *******************/
	public Post(User createdBy){
		super();
		this.content = "";
		
		/*Instantiate Relations*/
		this.comments = new ArrayList<Comment>();
		this.createdBy = createdBy;
	}


	/*
	 * Relation mapping
	 *******************/	
	@OneToMany(mappedBy="ofPost", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Comment> comments;
	
	@ManyToOne
	public User createdBy;


	/*
	 * Methods
	 *******************/
	public void addComment(Comment nComment){
		helper.checkList(this.comments);
		
		this.comments.add(nComment);
	}

}
