package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the appointmentdetails database table.
 * 
 */
@Entity
@Table(name="appointmentdetails")
@NamedQuery(name="Appointmentdetail.findAll", query="SELECT a FROM Appointmentdetail a")
public class Appointmentdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int appointmentId;

	//@Temporal(TemporalType.DATE)
	private String appointmentDate;

	private int consultationFee;

	private String doctorName;

	private String hospitalName;

	private String patientName;

	private String status;

	private String timeSlot;

	//bi-directional many-to-one association to Userregistration
	@ManyToOne
	@JoinColumn(name="PatientId")
	private Userregistration userregistration;

	//bi-directional many-to-one association to Doctordetail
	@ManyToOne
	@JoinColumn(name="DoctorId")
	private Doctordetail doctordetail;

	public Appointmentdetail() {
	}

	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
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

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeSlot() {
		return this.timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Userregistration getUserregistration() {
		return this.userregistration;
	}

	public void setUserregistration(Userregistration userregistration) {
		this.userregistration = userregistration;
	}

	public Doctordetail getDoctordetail() {
		return this.doctordetail;
	}

	public void setDoctordetail(Doctordetail doctordetail) {
		this.doctordetail = doctordetail;
	}

}