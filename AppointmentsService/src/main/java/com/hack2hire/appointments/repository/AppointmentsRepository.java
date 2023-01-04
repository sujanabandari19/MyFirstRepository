package com.hack2hire.appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack2hire.appointments.entity.Appointment;

public interface AppointmentsRepository extends JpaRepository<Appointment, Integer> {

}
