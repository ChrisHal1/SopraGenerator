package org.hohenheim.model.entity.posting;

import javax.persistence.*;

/*Entity Class*/
/**/
/*Last Updated: 23.06 10:46 @Simon*/


@Entity
public class Kommentar extends Eintrag {

	@ManyToOne
	public Eintrag ZuEintrag;
	
	//methods to be implemented...
}
