package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.model.AppointmentTime;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.AppointmentTimeRepository;
import com.example.demo.service.AppointmentService;

@RestController
@CrossOrigin
@RequestMapping(value = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private AppointmentTimeRepository appointmentTimeRepo;
	
	@GetMapping("/today")
	public ResponseEntity<List<Appointment>> getTodaysAppointments() {
		List<Appointment> appointments = appointmentService.findAllWithAppointmentDate(new Date());
		return ResponseEntity.ok(appointments);
	}
	
	@GetMapping("/availabletimes")
	public ResponseEntity<List<AppointmentTime>> getAvailableAppointmentTime() {
		List<AppointmentTime> appointmentTimes = appointmentTimeRepo.getAvailableAppointmentTimes();
		return ResponseEntity.ok(appointmentTimes);
	}
	/*
	@GetMapping()
	public ResponseEntity<List<Appointment>> getValidAppointments(@RequestParam int page, @RequestParam int size) {
		List<Appointment> appointments = appointmentService.findAllValid(PageRequest.of(page, size));
		return ResponseEntity.ok(appointments);
	}
	*/
	@GetMapping()
	public ResponseEntity<List<Appointment>> getValidAppointments(@RequestParam int page, @RequestParam int size) {
		List<Appointment> appointments = appointmentService.findAllValid(PageRequest.of(page, size, Sort.by("appointmentTime.appointmentDate").ascending().and(Sort.by("appointmentTime.fromTime").ascending())));
		return ResponseEntity.ok(appointments);
	}
	
	@PostMapping
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
		Appointment savedAppointment = appointmentService.save(appointment);
		return ResponseEntity.ok(savedAppointment);
	}
	
	@DeleteMapping("/{phoneNumber}")
	public ResponseEntity<Void> deleteAppointment(@PathVariable Integer phoneNumber) { 
		appointmentService.deleteByPhoneNumber(phoneNumber);
		return ResponseEntity.noContent().build();
	}
	

}
