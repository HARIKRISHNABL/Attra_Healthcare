package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departmentdetails database table.
 * 
 */
@Entity
@Table(name="departmentdetails")
@NamedQuery(name="Departmentdetail.findAll", query="SELECT d FROM Departmentdetail d")
public class Departmentdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int deptId;

	private String deptName;

	//bi-directional many-to-one association to Hospitaldetail
	@ManyToOne
	@JoinColumn(name="HospitalId")
	private Hospitaldetail hospitaldetail;

	//bi-directional one-to-one association to Doctordetail
	@OneToOne(mappedBy="departmentdetail")
	private Doctordetail doctordetail;

	public Departmentdetail() {
	}

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Hospitaldetail getHospitaldetail() {
		return this.hospitaldetail;
	}

	public void setHospitaldetail(Hospitaldetail hospitaldetail) {
		this.hospitaldetail = hospitaldetail;
	}

	public Doctordetail getDoctordetail() {
		return this.doctordetail;
	}

	public void setDoctordetail(Doctordetail doctordetail) {
		this.doctordetail = doctordetail;
	}

}