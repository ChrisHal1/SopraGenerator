package org.hohenheim.model.entity;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

import javax.persistence.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Superclass for all entitys. This class can not be instantiated. Add code here to make it available to all entitys.
 */

@MappedSuperclass
public abstract class BaseEntity {
	
	/*
	 * Fields
	 *******************/
	/*every entity will have an id...
	 * you can still ignore this in entity classes if you want
	 */
	@Basic @Id @GeneratedValue(strategy = GenerationType.TABLE)
	public long ID;
	/*Timestamps*/
	@Basic
	public Date lastUpdate;
	@Basic
	@Column(updatable=false)
	public Date created;
		
	
	/*
	 * Constructor
	 *******************/
	protected BaseEntity(){
		this.created = new Date();
		this.Updated();
	}

	/*
	 * Relation mapping
	 *******************/


	/*
	 * Methods
	 *******************/
	protected void Updated(){
		this.lastUpdate = new Date();
	}

}
