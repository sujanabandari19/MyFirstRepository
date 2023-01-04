package com.hack2hire.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack2hire.appointments.exception.AppException;
import com.hack2hire.appointments.model.AvailableAppointments;
import com.hack2hire.appointments.service.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/appointments")
@Slf4j
public class AppointmentsController {

	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping(path="/available/{providerId}")
	public ResponseEntity<?> fetchAppointments(@PathVariable Integer providerId) {
		try {
			log.info("---- fetch Appointments  ---");
			AvailableAppointments appointments = appointmentService.fetchAppointments(providerId);
			return new ResponseEntity<>(appointments, HttpStatus.OK);
		}
		catch(AppException exception) {
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(path="/schedule/{providerId}/{patientId}/{timeSlotId}")
	public ResponseEntity<?> scheduleAppointment(@PathVariable Integer providerId, @PathVariable Integer patientId,
			@PathVariable Integer timeSlotId) {
		try {
			log.info("---- schedule Appointments  ---");
			appointmentService.saveAppointment(providerId, patientId, timeSlotId);
			return new ResponseEntity<>("Appointment is scheduled", HttpStatus.OK);
		}
		catch(AppException exception) {
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
