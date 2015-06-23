package org.hohenheim.model.entity;

import java.util.Date;

import javax.persistence.*;

/*superclass for all entitys. this class can not be instantiated. add code here to make it available to all entitys.
 *last updated: 23.06 00:18 @Simon*/

@MappedSuperclass
public abstract class BaseEntity {
	
	//every entity will have an id... you can still ignore this in entity classes if you want
	@Basic @Id @GeneratedValue
	public long ID;
	
	//timestamps
	@Basic
	public Date LastUpdate;
	@Basic
	public Date Created;
	
}
