package com.hack2hire.appointments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class PatientDetails {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
        @Column
		private Integer patientId;
		@Column
		private String patientName;
		
		@Column
		private String date;
		
		@Column
		private Integer providerId;
	
	

}
