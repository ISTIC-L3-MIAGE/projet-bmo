package com.bah.tahi.bmoonlinebet.model;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class PariAvance extends Pari {

	@Column
	@Stereotype("ARRAY")
	private String[] intervalScore;

	@Column
	@Stereotype("ARRAY")
	private String[] scoreExact;

	@Required
	@Min(0)
	BigDecimal ecartScore;

}