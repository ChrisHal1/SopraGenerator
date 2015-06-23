package org.hohenheim.model.entity.nutzer;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;
import org.hohenheim.model.entity.kommunikation.Nachricht;
import org.hohenheim.model.entity.posting.Eintrag;

/*Entity Class*/
/**/
/*Last Updated: 23.06 10:51 @Simon*/


@Entity
public class Nutzer extends BaseEntity {

	public String Name;
	public int Alter;
	public String Email;
	public String Passwort;
	public String Beschreibung;
	public Set<String> Lerninteressen;
	public boolean Gesperrt;
	
	/*Relations*/
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
}
