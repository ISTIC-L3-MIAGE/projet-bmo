package com.bah.tahi.bmoonlinebet.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Regle extends Identifiable {

	@Column
	@Required
	String nom;
	
	@Column
	@Required
	@TextArea
	String description;

	@ManyToOne(optional = false)
	Sport sport;

}
