package com.hack2hire.appointments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Provider {

	@Id
	private String providerId;
	
	@Column
	private String providerName;
	
	@Column
	private String providerCity;
	
	@Column
	private String providerState;
	
	@Column
	private String spciality;
	
	
	
}
