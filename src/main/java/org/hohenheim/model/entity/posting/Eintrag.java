package org.hohenheim.model.entity.posting;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.nutzer.Nutzer;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Eintrag-Entity-Class. This class is abstract because you cannot create an Eintrag,
 * only Gruppeneintraege, Kommentare and Pinnwandeintraege!
 */


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Eintrag extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(length=4096, nullable=false)
	public String Inhalt;
	@Column(length=100000)
	public Byte[] Anhang;

	
	/*
	 * Constructor
	 *******************/
	public Eintrag(Nutzer ErstelltVon){
		super();
		this.Inhalt = "";
		
		/*Instantiate Relations*/
		this.Kommentare = new TreeSet<Kommentar>();
		this.ErstelltVon = ErstelltVon;
	}


	/*
	 * Relation mapping
	 *******************/	
	@OneToMany(mappedBy="ZuEintrag")
	public Set<Kommentar> Kommentare;
	
	@ManyToOne
	public Nutzer ErstelltVon;


	/*
	 * Methods
	 *******************/
	public void KommentarHinzufuegen(Kommentar nKommentar){
		if(this.Kommentare == null)
			this.Kommentare = new TreeSet<Kommentar>();
		
		this.Kommentare.add(nKommentar);
	}

}
