package org.hohenheim.model.entity.education;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.user.*;
import org.hohenheim.model.entity.posting.*;
import org.hohenheim.util.helper;

/* @Entity Class
 * @Last Updated: 28 01:54 by @Simon
 * @Description:
 * LLGroup-Entity-Class.
 */

@Entity
public class LGroup extends BaseEntity {
	
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
	public LGroup(User createdBy){
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
		helper.checkSet(this.members);
		this.members.add(_member);
	}
	public void removeMember(User _member){
		if(!helper.checkSet(this.members))
			return;
		else
			this.members.remove(_member);
	}

}
