package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "phone_number")
	private int phoneNumber;

	@ManyToOne
	private Type type;

	@OneToOne
	@JoinColumn(name = "appointment_time_id")
	private AppointmentTime appointmentTime;

	public Appointment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public AppointmentTime getAppointmentTime() {
		return this.appointmentTime;
	}

	public void setAppointmentTime(AppointmentTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	

}