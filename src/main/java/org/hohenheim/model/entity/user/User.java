package org.hohenheim.model.entity.user;

import java.util.*;

import javax.persistence.*;

import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.communication.Message;
import org.hohenheim.model.entity.education.Group;
import org.hohenheim.model.entity.posting.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Nutzer-Entity-Class.
 */


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(nullable=false)
	public String name;
	public int age;
	@Column(unique=true, nullable=false)
	public String email;
	@Column(nullable=false)
	public String password;
	@Column(length=2048)
	public String description;
	public ArrayList<String> interests;
	public boolean blocked;
	

	/*
	 * Constructor
	 *******************/
	public User(String name,String email, String password){
		super();
		this.interests = new ArrayList<String>();
		this.name = name;
		this.email = email;
		this.password = password;
		
		/*Instantiate Relations*/
		this.createdPosts = new TreeSet<Post>();
		this.friends = new TreeSet<User>();
		this.friendOf = new TreeSet<User>();
		this.received = new ArrayList<Message>();
		this.send = new ArrayList<Message>();
		this.groups = new TreeSet<Group>();
		this.posts = new ArrayList<UserPost>();
	}


	/*
	 * Relation mapping
	 *******************/
	@OneToMany(mappedBy="createdBy")
	public Set<Post> createdPosts;

	@ManyToMany
	@JoinTable(name="FRIENDS",
	joinColumns=@JoinColumn(name="UserID"),
	inverseJoinColumns=@JoinColumn(name="FriendID"))
	public Set<User> friends;
	
	@ManyToMany
	@JoinTable(name="FRIENDS",
	joinColumns=@JoinColumn(name="FriendID"),
	inverseJoinColumns=@JoinColumn(name="UserID"))
	public Set<User> friendOf;
	
	@OneToMany(mappedBy="recipient")
	public List<Message> received;
	
	@OneToMany(mappedBy="sender")
	public List<Message> send;
	
	@ManyToMany
	public Set<Group> groups;
	
	@OneToMany(mappedBy="recipient")
	List<UserPost> posts;

	
	/*
	 * Methods
	 *******************/
	public void setAdditionalInfo(int age, String description, ArrayList<String> interests){
		this.age = age;
		this.description = description;
		this.interests = interests;
	}
	
	public void addInterest(String interest){
		if(this.interests == null)
			this.interests = new ArrayList<String>();
		
		this.interests.add(interest);
	}
}
