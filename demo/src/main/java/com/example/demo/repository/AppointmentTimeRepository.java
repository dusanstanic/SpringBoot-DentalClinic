package com.example.demo.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AppointmentTime;

@Transactional
@Repository
public class AppointmentTimeRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<AppointmentTime> getAppointmentTimesForDateAndHour(Date appointmentDate, Time fromTime) {
		Query q = em.createQuery("from AppointmentTime at where at.appointmentDate = :appointmentDate and extract(hour from fromTime) = extract(hour from :fromTime)");
		q.setParameter("appointmentDate", appointmentDate);
		q.setParameter("fromTime", fromTime);
		return q.getResultList();
	}

	public AppointmentTime update(AppointmentTime appointmentTime) {
		AppointmentTime updatedAppointmentTime = em.merge(appointmentTime);
		return updatedAppointmentTime;
	}
	
	public List<AppointmentTime> getAvailableAppointmentTimes() {
		Query q = em.createQuery("from AppointmentTime at where at.available = 1 and at.appointmentDate >= :currentDate");
		q.setParameter("currentDate", new Date());
		return q.getResultList();
	}
	

}

