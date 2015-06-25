package org.hohenheim.model.entity.lernen;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Test-Entity-Class.
 */

@Entity
public class Test extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	public boolean Bestanden;
	public boolean Abgelegt;
	@Column(nullable=false)
	public int Punktestand;
	@Column(nullable=false)
	public int Punktegrenze;
	/*date: When was Test taken. this differs from created/updated timestampes.*/
	public Date Zeitpunkt;

	
	/*
	 * Constructor
	 *******************/
	public Test(Lerngruppe Gruppe){
		super();
		this.Bestanden = false;
		this.Abgelegt = false;
		this.Punktestand = 0;
		
		/*Instantiate Relations*/
		this.Gruppe = Gruppe;
		this.Fragen = new ArrayList<Frage>();
	}


	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Lerngruppe Gruppe;
	
	@OneToMany(mappedBy="AusTest")
	public List<Frage> Fragen;
	

	/*
	 * Methods
	 *******************/
	public void TestAbsolviert(){
		this.Zeitpunkt = new Date();
		this.Abgelegt = true;
	}
	
	public int getMaximalePunktzahl(){
		int xPunktzahl = 0;
		for(int i = 0; i < this.Fragen.size(); i++){
			xPunktzahl += this.Fragen.get(i).Punktzahl;
		}
		
		return xPunktzahl;
	}
	
	public void addFrage(Frage nFrage){
		if(this.Fragen == null)
			this.Fragen = new ArrayList<Frage>();
		
		this.Fragen.add(nFrage);
	}
	
	public void removeFrage(Frage nFrage){
		if(this.Fragen == null){
			this.Fragen = new ArrayList<Frage>();
			return;
		}
		else
		this.Fragen.remove(nFrage);
	}
}
