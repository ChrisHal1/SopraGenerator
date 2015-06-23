package org.hohenheim.model.entity.posting;

import javax.persistence.*;

import org.hohenheim.model.entity.lernen.Lerngruppe;
import org.hohenheim.model.entity.nutzer.Nutzer;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Gruppeneintrag-Entity-Class.
 */


@Entity
public class Gruppeneintrag extends Eintrag {

	/*
	 * Fields
	 *******************/


	/*
	 * Constructor
	 *******************/
	public Gruppeneintrag(Nutzer ErstelltVon, Lerngruppe Gruppe){
		super(ErstelltVon);
		
		/*Instantiate Relations*/
		this.Gruppe = Gruppe;
	}

	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Lerngruppe Gruppe;
	

	/*
	 * Methods
	 *******************/
}
