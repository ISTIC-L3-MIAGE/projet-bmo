package com.bah.tahi.bmoonlinebet.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Regle extends Identifiable {

	@Column(length = 255)
	@Required
	String description;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Sport sport;

}
