package org.hohenheim.model.entity.user;

import java.util.*;

import javax.persistence.*;

import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.communication.Message;
import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.posting.*;
import org.hohenheim.util.ROLE;
import org.hohenheim.util.helper;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * User-Entity-Class.
 */


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(nullable=false)
	public String username;
	public int age;
	@Column(unique=true, nullable=false)
	public String email;
	@Column(nullable=false)
	public String password;
	@Column(length=2048)
	public String description;
	public ArrayList<String> interests;
	@Column(nullable=false)
	public boolean blocked;
	@Column(nullable=false)
	public String rolename;
	

	/*
	 * Constructor
	 *******************/
	public User(){
		super();
	}
	public User(String username, String email, String password, ROLE role){
		super();
		this.interests = new ArrayList<String>();
		this.username = username;
		this.email = email;
		this.password = password;
		this.blocked = false;
		this.rolename = role.toString();
		
		/*Instantiate Relations*/
		this.createdPosts = new ArrayList<Post>();
		this.friends = new ArrayList<User>();
		this.friendOf = new ArrayList<User>();
		this.received = new ArrayList<Message>();
		this.send = new ArrayList<Message>();
		this.groups = new ArrayList<LGroup>();
		this.posts = new ArrayList<UserPost>();
	}


	/*
	 * Relation mapping
	 *******************/
	@OneToMany(mappedBy="createdBy")
	public List<Post> createdPosts;

	@ManyToMany
	@JoinTable(name="FRIENDS",
	joinColumns=@JoinColumn(name="UserID"),
	inverseJoinColumns=@JoinColumn(name="FriendID"))
	public List<User> friends;
	
	@ManyToMany
	@JoinTable(name="FRIENDS",
	joinColumns=@JoinColumn(name="FriendID"),
	inverseJoinColumns=@JoinColumn(name="UserID"))
	public List<User> friendOf;
	
	@OneToMany(mappedBy="recipient")
	public List<Message> received;
	
	@OneToMany(mappedBy="sender")
	public List<Message> send;
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<LGroup> groups;
	
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
		helper.checkList(this.interests);
		
		this.interests.add(interest);
	}
	
	public void block(){
		this.blocked = true;
	}
	public void unblock(){
		this.blocked = false;
	}
	public boolean isAdmin(){
		return (this.rolename.compareTo(ROLE.ROLE_ADMIN.toString()) == 0);
	}
}
