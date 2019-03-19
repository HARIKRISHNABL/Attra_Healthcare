package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doctordetails database table.
 * 
 */
@Entity
@Table(name="doctordetails")
@NamedQuery(name="Doctordetail.findAll", query="SELECT d FROM Doctordetail d")
public class Doctordetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int doctorId;

	private int deptId;

	private String doctorEmail;

	private String doctorName;

	private String specialization;

	//bi-directional many-to-one association to Appointmentdetail
	@OneToMany(mappedBy="doctordetail")
	private List<Appointmentdetail> appointmentdetails;

	//bi-directional one-to-one association to Doctoravailability
	@OneToOne(mappedBy="doctordetail")
	private Doctoravailability doctoravailability;

	//bi-directional one-to-one association to Departmentdetail
	@OneToOne
	@JoinColumn(name="DoctorId")
	private Departmentdetail departmentdetail;

	public Doctordetail() {
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDoctorEmail() {
		return this.doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Appointmentdetail> getAppointmentdetails() {
		return this.appointmentdetails;
	}

	public void setAppointmentdetails(List<Appointmentdetail> appointmentdetails) {
		this.appointmentdetails = appointmentdetails;
	}

	public Appointmentdetail addAppointmentdetail(Appointmentdetail appointmentdetail) {
		getAppointmentdetails().add(appointmentdetail);
		appointmentdetail.setDoctordetail(this);

		return appointmentdetail;
	}

	public Appointmentdetail removeAppointmentdetail(Appointmentdetail appointmentdetail) {
		getAppointmentdetails().remove(appointmentdetail);
		appointmentdetail.setDoctordetail(null);

		return appointmentdetail;
	}

	public Doctoravailability getDoctoravailability() {
		return this.doctoravailability;
	}

	public void setDoctoravailability(Doctoravailability doctoravailability) {
		this.doctoravailability = doctoravailability;
	}

	public Departmentdetail getDepartmentdetail() {
		return this.departmentdetail;
	}

	public void setDepartmentdetail(Departmentdetail departmentdetail) {
		this.departmentdetail = departmentdetail;
	}

}