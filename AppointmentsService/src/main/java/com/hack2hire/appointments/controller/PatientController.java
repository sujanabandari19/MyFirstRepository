package com.hack2hire.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack2hire.appointments.entity.PatientDetails;
import com.hack2hire.appointments.model.Timeslot;
import com.hack2hire.appointments.repository.PatientDetailsRepository;
import com.hack2hire.appointments.repository.TimeslotRepository;
import com.hack2hire.appointments.utils.Utils;

@RestController
@RequestMapping("/patientdetails")
public class PatientController {
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTimeslot(@RequestBody @Validated PatientDetails patientDetails) {
		
		com.hack2hire.appointments.entity.PatientDetails dbpatientDetails = new com.hack2hire.appointments.entity.PatientDetails();
		dbpatientDetails.setDate(patientDetails.getDate());
		dbpatientDetails.setPatientId(patientDetails.getPatientId());
		dbpatientDetails.setProviderId(patientDetails.getProviderId());
		dbpatientDetails.setPatientName(patientDetails.getPatientName());	
		//patientDetailsRepository.save(dbpatientDetails);
		
		return new ResponseEntity<>("patientDetails saved", HttpStatus.OK);
		
	}
}
