package com.hack2hire.appointments.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class Timeslot {

	private Integer timeSlotId;
	private String time;
	
	@NotNull
	private String date;
	
	@NotNull
	private Integer providerId;
	private String status;
	
}
