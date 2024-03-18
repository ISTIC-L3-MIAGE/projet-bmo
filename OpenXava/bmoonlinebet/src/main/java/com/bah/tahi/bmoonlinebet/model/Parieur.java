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

	@Column
	@Required
	String nom;

	@Column
	@Required
	String prenom;

	@Column
	@Required
	@Email
	String email;

	@Column
	@Required
	@Password
	String motDePasse;

	@Column
	@Required
	@Min(0)
	BigDecimal solde;

	@OneToMany(mappedBy = "parieur", cascade = CascadeType.ALL)
	Collection<Pari> paris;


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
