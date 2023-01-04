package com.hack2hire.appointments.model;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class PatientDetails {

    private Integer patientDetailsId;
    
	private Integer patientId;

	private String patientName;
	
	@NotNull
	private String date;
	
	@NotNull
	private Integer providerId;


}
