package com.bah.tahi.bmoonlinebet.generator.models;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.bah.tahi.bmoonlinebet.model.*;

import lombok.*;

@Entity
@Getter
@Setter
public class PariSimple extends Pari {

	@Column(length = 50)
	@Required
	String vainqueur;

	@Required
	@Min(0)
	BigDecimal ecartScore;

}
