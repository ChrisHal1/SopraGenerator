package org.hohenheim.model.entity.posting;

import javax.persistence.*;

import org.hohenheim.model.entity.BaseEntity;

/*Entity Class*/
/*Last Updated: 23.06 00:42 @Simon*/


@Entity
public class Kommentar extends BaseEntity {
	@Column(length=1024, nullable=false)
	public String Inhalt;
	@Column(length=100000)
	public Byte[] Anhang;
	
	//methods to be implemented...
}
