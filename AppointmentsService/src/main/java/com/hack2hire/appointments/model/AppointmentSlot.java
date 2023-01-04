package com.hack2hire.appointments.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AppointmentSlot {

	private Integer providerId;
	private Date appointmentDate;
	
	List<Timeslot> timeSlots = new ArrayList<>();
}
