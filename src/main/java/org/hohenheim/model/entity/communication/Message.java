package org.hohenheim.model.entity.communication;

import java.util.Date;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.user.User;

import javax.persistence.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Nachrichten-Entity-Class.
 */


@Entity
public class Message extends BaseEntity {

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
	public Message(User recipient, User sender){
		super();
		this.content = "";
		
		/*Instantiate Relations*/
		this.recipient = recipient;
		this.sender = sender;
	}

	
	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public User recipient;
	
	@ManyToOne
	public User sender;
	
	
	/*
	 * Methods
	 *******************/
	/*created is already saved in baseclass,so this is just to capsule...*/
	public Date sendDate(){
		return this.Created;
	}

}
