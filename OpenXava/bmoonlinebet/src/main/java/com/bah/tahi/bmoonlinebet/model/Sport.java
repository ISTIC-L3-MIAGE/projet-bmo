package com.bah.tahi.bmoonlinebet.model;

import java.util.*;

import javax.persistence.*;

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
public class Sport extends Identifiable {

	private Collection<Pari> paris;
	private Collection<Regle> regles;

	@Column(length = 50)
	@Required
	String name;

	// revoir boolean termine
	// @Column(false)
	@Required
	boolean termine;

}
