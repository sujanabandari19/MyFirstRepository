package com.hack2hire.appointments.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AvailableAppointments {

	private List<Timeslot> appointmentSlots = new ArrayList<>();
	
}
