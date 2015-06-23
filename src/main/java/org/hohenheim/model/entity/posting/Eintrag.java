package org.hohenheim.model.entity.posting;

import java.util.Set;

import javax.persistence.*;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.entity.nutzer.Nutzer;

/*Entity Class*/
/**/
/*Last Updated: 23.06 10:30 @Simon*/


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Eintrag extends BaseEntity {
	@Column(length=4096, nullable=false)
	public String Inhalt;
	@Column(length=100000)
	public Byte[] Anhang;
	
	
	@OneToMany(mappedBy="ZuEintrag")
	public Set<Kommentar> Kommentare;
	
	@ManyToOne
	public Nutzer ErstelltVon;
	//methods to be implemented...
}
