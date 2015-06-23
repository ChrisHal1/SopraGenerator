package org.hohenheim.model.entity.posting;

import javax.persistence.*;

/*Entity Class*/
/**/
/*Last Updated: 23.06 10:30 @Simon*/


@Entity
public class Pinnwandeintrag extends Eintrag {

	@ManyToOne
	public Pinnwand AufPinnwand;
}
