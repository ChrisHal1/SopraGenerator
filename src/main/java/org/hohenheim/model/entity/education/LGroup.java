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
 * LGroup-Entity-Class.
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
	public boolean is_public = true;
	public int maxMembers;
	
	
	/*
	 * Constructor
	 *******************/
	public LGroup(){
		
	}
	
	public LGroup(User createdBy, String name){
		super();
		this.name = name;
		this.description = "";
		this.focus = "Allgemein";
		this.is_public = true;
		this.maxMembers = 10;
		
		/*Instantiate Relations*/
		this.members = new ArrayList<User>();
		this.posts = new ArrayList<GroupPost>();
		this.tests = new ArrayList<Test>();
		this.addMember(createdBy);
	}
	
	
	/*
	 * Relation mapping
	 *******************/
	@ManyToMany(fetch = FetchType.EAGER)
	public List<User> members;
	
	@OneToMany(mappedBy="inGroup", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	public List<GroupPost> posts;

	@OneToMany(mappedBy="inGroup", fetch = FetchType.EAGER, cascade=CascadeType.REFRESH)
	public List<Test> tests;
	
	
	/*
	 * Methods
	 *******************/
	public void addMember(User _member){
		helper.checkList(this.members);
		this.members.add(_member);
	}
	public void removeMember(User _member){
		if(!helper.checkList(this.members))
			return;
		else
			this.members.remove(_member);
	}

	public int getMemberCount(){
		return this.members.size();
	}
	public boolean isFull(){
		return (this.getMemberCount() >= this.maxMembers);
	}
}
