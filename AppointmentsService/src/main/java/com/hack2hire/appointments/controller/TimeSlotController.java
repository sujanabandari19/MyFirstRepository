package com.hack2hire.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack2hire.appointments.model.Timeslot;
import com.hack2hire.appointments.repository.TimeslotRepository;
import com.hack2hire.appointments.utils.Utils;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

	@Autowired
	TimeslotRepository timeslotRepository;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTimeslot(@RequestBody @Validated Timeslot timeslot) {
		
		com.hack2hire.appointments.entity.Timeslot dbTimeslot = new com.hack2hire.appointments.entity.Timeslot();
		dbTimeslot.setTime(timeslot.getTime());
		dbTimeslot.setDate(Utils.getDBDate(timeslot.getDate()));
		dbTimeslot.setProviderId(timeslot.getProviderId());
		dbTimeslot.setStatus(timeslot.getStatus());	
		timeslotRepository.save(dbTimeslot);
		
		return new ResponseEntity<>("Timeslot saved", HttpStatus.OK);
		
	}
	
}
