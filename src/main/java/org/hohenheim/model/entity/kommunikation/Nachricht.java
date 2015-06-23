package org.hohenheim.model.entity.kommunikation;

import java.util.Date;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.nutzer.Nutzer;

import javax.persistence.*;

/*Entity Class*/
/**/
/*Last Updated: 23.06 11:03 @Simon*/


@Entity
public class Nachricht extends BaseEntity {

	public String Inhalt;
	public Byte[] Anhang;
	
	/*created is already saved in baseclass,so...*/
	public Date Versendet(){ return this.Created; }

	/*Relations*/
	@ManyToOne
	public Nutzer Empfaenger;
	
	@ManyToOne
	public Nutzer Absender;
}
