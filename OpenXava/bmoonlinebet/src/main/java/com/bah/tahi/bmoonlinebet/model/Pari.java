package com.bah.tahi.bmoonlinebet.model;

import java.math.*;

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
public class Pari extends Identifiable {

	private Parieur parieur;
	private Sport sport;

// revoir boolean gagne
	// @Column(false)
	@Required
	boolean gagne;

	@Required
	@Min(0)
	BigDecimal montant;

	@Required
	@Min(0)
	BigDecimal cote;
}
