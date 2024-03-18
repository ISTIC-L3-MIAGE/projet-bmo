package com.bah.tahi.bmoonlinebet.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Regle extends Identifiable {

	private Sport sport;

	@Column(length = 100)
	@Required
	String description;

}
