package org.hohenheim.model.entity.kommunikation;

import java.util.Date;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.nutzer.Nutzer;

import javax.persistence.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Nachrichten-Entity-Class.
 */


@Entity
public class Nachricht extends BaseEntity {

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
	public Nachricht(Nutzer Empfaenger, Nutzer Absender){
		super();
		this.Inhalt = "";
		
		/*Instantiate Relations*/
		this.Empfaenger = Empfaenger;
		this.Absender = Absender;
	}

	
	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Nutzer Empfaenger;
	
	@ManyToOne
	public Nutzer Absender;
	
	
	/*
	 * Methods
	 *******************/
	/*created is already saved in baseclass,so this is just to capsule...*/
	public Date Versendet(){
		return this.Created;
	}

}
