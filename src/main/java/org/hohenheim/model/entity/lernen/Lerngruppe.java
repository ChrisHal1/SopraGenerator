package org.hohenheim.model.entity.lernen;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.nutzer.*;
import org.hohenheim.model.entity.posting.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Lerngruppe-Entity-Class.
 */

@Entity
public class Lerngruppe extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(nullable=false, unique=true, length=64)
	public String Name;
	@Column(length=1024)
	public String Beschreibung;
	@Column(length=512)
	public String Schwerpunkt;
	public final boolean Oeffentlich = true;
	
	
	/*
	 * Constructor
	 *******************/
	public Lerngruppe(Nutzer Ersteller){
		super();
		this.Name = "Unbenannte Gruppe";
		this.Beschreibung = "";
		this.Schwerpunkt = "Keiner";
		
		/*Instantiate Relations*/
		this.Mitglieder = new TreeSet<Nutzer>();
		this.Eintraege = new TreeSet<Gruppeneintrag>();
		this.Tests = new TreeSet<Test>();
		this.MitgliedHinzufuegen(Ersteller);
	}
	
	
	/*
	 * Relation mapping
	 *******************/
	@ManyToMany
	public Set<Nutzer> Mitglieder;
	
	@OneToMany(mappedBy="Gruppe")
	public Set<Gruppeneintrag> Eintraege;

	@OneToMany(mappedBy="Gruppe")
	public Set<Test> Tests;
	
	
	/*
	 * Methods
	 *******************/
	public void MitgliedHinzufuegen(Nutzer Mitglied){
		if(this.Mitglieder == null)
			this.Mitglieder = new TreeSet<Nutzer>();
		this.Mitglieder.add(Mitglied);
	}
	public void MitgliedEntfernen(Nutzer Mitglied){
		if(this.Mitglieder == null){
			this.Mitglieder = new TreeSet<Nutzer>();
			return;
		}
		else
			this.Mitglieder.remove(Mitglied);
	}

}
