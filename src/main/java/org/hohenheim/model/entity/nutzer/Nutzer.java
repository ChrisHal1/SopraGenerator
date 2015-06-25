package org.hohenheim.model.entity.nutzer;

import java.util.*;

import javax.persistence.*;

import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.kommunikation.Nachricht;
import org.hohenheim.model.entity.lernen.Lerngruppe;
import org.hohenheim.model.entity.posting.Eintrag;
import org.hohenheim.model.entity.posting.Pinnwandeintrag;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Nutzer-Entity-Class.
 */


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Nutzer extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(nullable=false)
	public String Name;
	public int Alter;
	@Column(unique=true, nullable=false)
	public String Email;
	@Column(nullable=false)
	public String Passwort;
	@Column(length=2048)
	public String Beschreibung;
	public ArrayList<String> Lerninteressen;
	public boolean Gesperrt;
	

	/*
	 * Constructor
	 *******************/
	public Nutzer(String Name,String Email, String Passwort){
		super();
		this.Lerninteressen = new ArrayList<String>();
		this.Name = Name;
		this.Email = Email;
		this.Passwort = Passwort;
		
		/*Instantiate Relations*/
		this.ErstellteEintraege = new TreeSet<Eintrag>();
		this.Freunde = new TreeSet<Nutzer>();
		this.FreundVon = new TreeSet<Nutzer>();
		this.Empfangen = new ArrayList<Nachricht>();
		this.Gesendet = new ArrayList<Nachricht>();
		this.Gruppen = new TreeSet<Lerngruppe>();
		this.Eintraege = new ArrayList<Pinnwandeintrag>();
	}


	/*
	 * Relation mapping
	 *******************/
	@OneToMany(mappedBy="ErstelltVon")
	public Set<Eintrag> ErstellteEintraege;

	@ManyToMany
	@JoinTable(name="FREUNDE",
	joinColumns=@JoinColumn(name="NutzerID"),
	inverseJoinColumns=@JoinColumn(name="FreundID"))
	public Set<Nutzer> Freunde;
	
	@ManyToMany
	@JoinTable(name="FREUNDE",
	joinColumns=@JoinColumn(name="freundID"),
	inverseJoinColumns=@JoinColumn(name="NutzerID"))
	public Set<Nutzer> FreundVon;
	
	@OneToMany(mappedBy="Empfaenger")
	public List<Nachricht> Empfangen;
	
	@OneToMany(mappedBy="Absender")
	public List<Nachricht> Gesendet;
	
	@ManyToMany
	public Set<Lerngruppe> Gruppen;
	
	@OneToMany(mappedBy="EmpfaengerNutzer")
	List<Pinnwandeintrag> Eintraege;

	
	/*
	 * Methods
	 *******************/
	public void setZusatzinformationen(int Alter, String Beschreibung, ArrayList<String> Lerninteressen){
		this.Alter = Alter;
		this.Beschreibung = Beschreibung;
		this.Lerninteressen = Lerninteressen;
	}
	
	public void addLerninteresse(String Interesse){
		if(this.Lerninteressen == null)
			this.Lerninteressen = new ArrayList<String>();
		
		this.Lerninteressen.add(Interesse);
	}
}
