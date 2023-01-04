package com.hack2hire.appointments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack2hire.appointments.entity.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

	/** 
	 * Returning Available timeslots based on the providerId and status
	 * @param providerId
	 * @param status
	 * @return
	 */

	List<Timeslot> findTimeslotByProviderIdAndStatus(Integer providerId, String status);
	
}
