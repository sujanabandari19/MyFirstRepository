package com.hack2hire.appointments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Appointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appointmentId;
	
	@Column
	private Integer patientId;
	
	@Column
	private Integer providerId;
	
	@Column
	private Integer timeslotId;
	
	@Column
	private String reasonForVisit;
	
	@Column
	private String status;
		
}
