package com.bah.tahi.bmoonlinebet.model;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class PariSimple extends Pari {

	@Column
	@Required
	String vainqueur;

	@Required
	@Min(0)
	BigDecimal ecartScore;

}
