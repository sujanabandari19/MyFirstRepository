package com.hack2hire.appointments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack2hire.appointments.entity.Appointment;
import com.hack2hire.appointments.exception.AppException;
import com.hack2hire.appointments.model.AvailableAppointments;
import com.hack2hire.appointments.model.Timeslot;
import com.hack2hire.appointments.repository.AppointmentsRepository;
import com.hack2hire.appointments.repository.PatientDetailsRepository;
import com.hack2hire.appointments.repository.TimeslotRepository;
import com.hack2hire.appointments.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppointmentService {
	
	@Autowired
	TimeslotRepository timeslotRepository;
	
	@Autowired
	AppointmentsRepository appointmentRepo;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;

	public AvailableAppointments fetchAppointments(Integer providerId) throws AppException {
		
		try {
			AvailableAppointments appointments = new AvailableAppointments();
			
		
			
			List<com.hack2hire.appointments.entity.Timeslot> timeSlots 
					= timeslotRepository.findTimeslotByProviderIdAndStatus(providerId, "Available");
			List<Timeslot> appointmentSlots = composeAppointmentSlots(timeSlots);
			
			
			appointments.getAppointmentSlots().addAll(appointmentSlots);
			return appointments;
		}
		catch(Exception e) {
			log.error("Error in fething appointments");
			throw new AppException("FETCH_APPOINTMENTS_ERROR", "Unable to retrieve available timeslots");
		}
	}

	/**
	 * Converting DB timeslots into DTOs 
	 * @param timeSlots
	 * @return
	 */
	private List<Timeslot> composeAppointmentSlots(List<com.hack2hire.appointments.entity.Timeslot> timeSlots) {
		
		List<Timeslot> appointmentSlots = new ArrayList<>();
		
		for(com.hack2hire.appointments.entity.Timeslot timeslotDB: timeSlots) {
			Timeslot timeslot = new Timeslot();
			timeslot.setDate(Utils.getUIDate(timeslotDB.getDate()));
			timeslot.setTime(timeslotDB.getTime());
			timeslot.setProviderId(timeslotDB.getProviderId());
			timeslot.setStatus(timeslotDB.getStatus());
			timeslot.setTimeSlotId(timeslotDB.getId());
			appointmentSlots.add(timeslot);
		}
	
		return appointmentSlots;
	}

	public void saveAppointment(Integer providerId, Integer patientId, Integer timeSlotId) throws AppException {
		
		com.hack2hire.appointments.entity.Timeslot timeSlotDB = timeslotRepository.findById(timeSlotId).get();
		if(timeSlotDB == null ) {
			throw new AppException("TIMESLOT_ERROR", "Timeslot not available");
		}
		
		Appointment appointment = new Appointment();
		appointment.setPatientId(patientId);
		appointment.setProviderId(providerId);
		appointment.setTimeslotId(timeSlotId);
		appointment.setStatus("Booked");
		appointmentRepo.save(appointment);
		
		//updating timeslot status
		timeSlotDB.setStatus("Booked");
		timeslotRepository.save(timeSlotDB);
		
	}
	//public void savePatientDetails(Integer patientId, String patientName, String providerId,Integer patientDetailsId) throws AppException {
		
	//	com.hack2hire.appointments.entity.PatientDetails patientDetailsDB = patientDetailsRepository.findById(patientDetailsId).get();
	//	if(patientDetailsDB == null ) {
	//		throw new AppException("TIMESLOT_ERROR", "Timeslot not available");
	//	}
	//	
	//	Appointment appointment = new Appointment();
	//	appointment.setPatientId(patientId);
	//	appointment.setProviderId(providerId);
	//	appointment.setTimeslotId(timeSlotId);
	//	appointment.setStatus("Booked");
	//	appointmentRepo.save(appointment);
	//	
		//updating timeslot status
	//	timeSlotDB.setStatus("Booked");
	//	timeslotRepository.save(timeSlotDB);
		
	//}
	
}
