package com.bah.tahi.bmoonlinebet.model;

import java.math.*;
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
public class Parieur extends Identifiable {

	@Column(length = 50)
	@Required
	String nom;

	@Column(length = 50)
	@Required
	String prenom;

	@Column(length = 50)
	@Required
	String email;

	@Column(length = 255)
	@Required
	@Password
	String motDePasse;

	@Required
	@Min(0)
	BigDecimal solde;

	@OneToMany(mappedBy = "parieur")
	private Collection<Pari> paris;

	public Collection<Pari> getParis() {
		return this.paris;
	}

	public void setParis(Collection<Pari> paris) {
		this.paris = paris;
	}

	public void placerPari(Sport evenement, Pari type, BigDecimal montant, String pronostic) {
		// Pari pari = new Pari();
	}

	public void crediter(BigDecimal montant) {
		this.solde.add(montant);
	}

	public boolean debiter(BigDecimal montant) {
		if (this.solde.compareTo(montant) >= 0) {
			this.solde.subtract(montant);
			return true;
		}

		return false;
	}
}
