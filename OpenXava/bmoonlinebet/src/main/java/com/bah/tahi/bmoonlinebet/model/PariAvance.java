package com.bah.tahi.bmoonlinebet.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
public class PariAvance extends Pari {

	@Column
	Integer scoreMin;
	
	@Column
	Integer scoreMax;
	
	@Column
	Integer ecartScore;
	
	@Column
	Integer scoreExactGauche;
	
	@Column
	Integer scoreExactDroit;
	
}