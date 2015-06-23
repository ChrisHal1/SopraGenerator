package org.hohenheim.model.entity.lernen;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Frage-Entity-Class.
 */

@Entity
public class Frage extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(length=4096, nullable=false)
	public String Text;
	public ArrayList<String> Antworten;
	@Column(nullable=false)
	public int Richtig;
	@Column(nullable=false)
	public int Punktzahl;

	
	/*
	 * Constructor
	 *******************/
	public Frage(Test AusTest){
		super();
		this.Text = "";
		this.Antworten = new ArrayList<String>();
		
		/*Instantiate Relations*/
		this.AusTest = AusTest;
	}
	
	
	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Test AusTest;

	
	/*
	 * Methods
	 *******************/
	public void setProperties(int Richtig, int Punktzahl){
		this.Richtig = Richtig;
		this.Punktzahl = Punktzahl;
	}
	public void addFrage(String Frage){
		if(this.Antworten == null)
			this.Antworten = new ArrayList<String>();
		
		this.Antworten.add(Frage);
	}
	public void deleteFrage(int index){
		if(this.Antworten == null)
			this.Antworten = new ArrayList<String>();
		
		this.Antworten.remove(index);
	}
	public void setRichtigeAntwort(int Richtig){
		if(Richtig < 0 || Richtig >= this.Antworten.size())
			Richtig = 0;
		this.Richtig = Richtig;
	}

}
