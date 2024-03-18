package com.bah.tahi.bmoonlinebet.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

/**
 * This is an example of an entity.
 * 
 * Feel free feel to rename, modify or remove at your taste.
 */

@Entity
@Getter
@Setter
abstract public class Sport extends Identifiable {

	@Column
	@Required
	String name;
	
	@Column
	@Required
	@Min(1)
	Double coteEquipe1;
	
	@Column
	@Required
	@Min(1)
	Double coteEquipe2;
	
	@Column
	boolean termine;

	@OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
	Collection<Regle> regles;
	
	@OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
	Collection<Pari> paris;

}
