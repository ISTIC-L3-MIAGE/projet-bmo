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

	@Column(length = 50)
	@Required
	String name;

	boolean termine = false;

	@OneToMany(mappedBy = "sport")
	private Collection<Regle> regles;

	public Collection<Regle> getRegles() {
		return this.regles;
	}

	public void setRegles(Collection<Regle> regles) {
		this.regles = regles;
	}

	@OneToMany(mappedBy = "sport")
	private Collection<Pari> paris;

	public Collection<Pari> getParis() {
		return this.paris;
	}

	public void setParis(Collection<Pari> paris) {
		this.paris = paris;
	}

}
