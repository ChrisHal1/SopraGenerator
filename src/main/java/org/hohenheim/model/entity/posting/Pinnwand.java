package org.hohenheim.model.entity.posting;

import java.util.Set;

import javax.persistence.*;

import org.hohenheim.model.entity.BaseEntity;

/*Entity Class*/
/**/
/*Last Updated: 23.06 10:30 @Simon*/


@Entity
public class Pinnwand extends BaseEntity {
	
	@OneToMany(mappedBy="AufPinnwand")
	Set<Pinnwandeintrag> Eintraege;
	
	//methods to be implemented...
}
