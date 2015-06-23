package org.hohenheim.model.entity.nutzer;

import javax.persistence.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Administrator-Entity-Class.
 */

@Entity
public class Administrator extends Nutzer {

	/*
	 * Fields
	 *******************/
	public boolean isAdmin = true;
	

	/*
	 * Constructor
	 *******************/
	public Administrator(String Name, String Email, String Passwort){
		super(Name, Email, Passwort);
	}


	/*
	 * Relation mapping
	 *******************/


	/*
	 * Methods
	 *******************/

}
