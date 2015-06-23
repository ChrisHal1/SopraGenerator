package org.hohenheim.model.entity.posting;

import javax.persistence.*;
import org.hohenheim.model.entity.nutzer.Nutzer;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Pinnwandeintrag-Entity-Class.
 */


@Entity
public class Pinnwandeintrag extends Eintrag {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public Pinnwandeintrag(Nutzer ErstelltVon, Nutzer EmpfaengerNutzer){
		super(ErstelltVon);
		
		/*Instantiate Relations*/
		this.EmpfaengerNutzer = EmpfaengerNutzer;
	}


	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Nutzer EmpfaengerNutzer;
	

	/*
	 * Methods
	 *******************/

}
