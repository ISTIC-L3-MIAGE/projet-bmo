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
abstract public class Pari extends Identifiable {

	@Column
	boolean gagne;

	@Column
	@Required
	@Min(1)
	BigDecimal montantMise;

	@ManyToOne(optional = false)
	Parieur parieur;

	@ManyToOne(optional = false)
	Sport sport;
}
