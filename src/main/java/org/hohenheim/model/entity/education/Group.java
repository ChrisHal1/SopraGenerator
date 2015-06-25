package org.hohenheim.model.entity.education;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.user.*;
import org.hohenheim.model.entity.posting.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Lerngruppe-Entity-Class.
 */

@Entity
public class Group extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(nullable=false, unique=true, length=64)
	public String name;
	@Column(length=1024)
	public String description;
	@Column(length=512)
	public String focus;
	public final boolean is_public = true;
	
	
	/*
	 * Constructor
	 *******************/
	public Group(User createdBy){
		super();
		this.name = "Unbenannte Gruppe";
		this.description = "";
		this.focus = "Keiner";
		
		/*Instantiate Relations*/
		this.members = new TreeSet<User>();
		this.posts = new TreeSet<GroupPost>();
		this.tests = new TreeSet<Test>();
		this.addMember(createdBy);
	}
	
	
	/*
	 * Relation mapping
	 *******************/
	@ManyToMany
	public Set<User> members;
	
	@OneToMany(mappedBy="inGroup")
	public Set<GroupPost> posts;

	@OneToMany(mappedBy="inGroup")
	public Set<Test> tests;
	
	
	/*
	 * Methods
	 *******************/
	public void addMember(User _member){
		if(this.members == null)
			this.members = new TreeSet<User>();
		this.members.add(_member);
	}
	public void removeMember(User _member){
		if(this.members == null){
			this.members = new TreeSet<User>();
			return;
		}
		else
			this.members.remove(_member);
	}

}
