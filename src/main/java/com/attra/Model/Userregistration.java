package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userregistration database table.
 * 
 */
@Entity
@Table(name="userregistration")
@NamedQuery(name="Userregistration.findAll", query="SELECT u FROM Userregistration u")
public class Userregistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int patientId;

	private String email;

	private String password;

	private String patientName;

	private String phone;

	//bi-directional many-to-one association to Appointmentdetail
	@OneToMany(mappedBy="userregistration")
	private List<Appointmentdetail> appointmentdetails;

	public Userregistration() {
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Appointmentdetail> getAppointmentdetails() {
		return this.appointmentdetails;
	}

	public void setAppointmentdetails(List<Appointmentdetail> appointmentdetails) {
		this.appointmentdetails = appointmentdetails;
	}

	public Appointmentdetail addAppointmentdetail(Appointmentdetail appointmentdetail) {
		getAppointmentdetails().add(appointmentdetail);
		appointmentdetail.setUserregistration(this);

		return appointmentdetail;
	}

	public Appointmentdetail removeAppointmentdetail(Appointmentdetail appointmentdetail) {
		getAppointmentdetails().remove(appointmentdetail);
		appointmentdetail.setUserregistration(null);

		return appointmentdetail;
	}

}
