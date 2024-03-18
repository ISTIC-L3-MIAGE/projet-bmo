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

	boolean gagne = false;

	@Required
	@Min(1)
	BigDecimal montantMise;

	@Required
	@Min(1)
	BigDecimal cote;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Parieur parieur;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Sport sport;
}
