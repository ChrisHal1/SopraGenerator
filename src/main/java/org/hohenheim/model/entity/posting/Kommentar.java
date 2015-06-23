package org.hohenheim.model.entity.posting;

import javax.persistence.*;
import org.hohenheim.model.entity.nutzer.Nutzer;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Kommentar-Entity-Class.
 */


@Entity
public class Kommentar extends Eintrag {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public Kommentar(Nutzer ErstelltVon, Eintrag ZuEintrag){
		super(ErstelltVon);
		
		/*Instantiate Relations*/
		this.ZuEintrag = ZuEintrag;
	}
	

	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Eintrag ZuEintrag;

	
	/*
	 * Methods
	 *******************/
}
