package com.hack2hire.appointments.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Timeslot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer providerId;
	
	@Column
	private Date date;
	
	@Column
	private String time;
	
	@Column
	private String status;
	
	
}
