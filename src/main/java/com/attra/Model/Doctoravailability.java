package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctoravailability database table.
 * 
 */
@Entity
@Table(name="doctoravailability")
@NamedQuery(name="Doctoravailability.findAll", query="SELECT d FROM Doctoravailability d")
public class Doctoravailability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int doctorId;

	private int attendingPatient;

	private String availableDay;

	private int consultationFee;

	private String doctorName;

	private String timeSlot;

	//bi-directional one-to-one association to Doctordetail
	@OneToOne
	@JoinColumn(name="DoctorId")
	private Doctordetail doctordetail;

	public Doctoravailability() {
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getAttendingPatient() {
		return this.attendingPatient;
	}

	public void setAttendingPatient(int attendingPatient) {
		this.attendingPatient = attendingPatient;
	}

	public String getAvailableDay() {
		return this.availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public int getConsultationFee() {
		return this.consultationFee;
	}

	public void setConsultationFee(int consultationFee) {
		this.consultationFee = consultationFee;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTimeSlot() {
		return this.timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Doctordetail getDoctordetail() {
		return this.doctordetail;
	}

	public void setDoctordetail(Doctordetail doctordetail) {
		this.doctordetail = doctordetail;
	}

}
