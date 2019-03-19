package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospitaldetails database table.
 * 
 */
@Entity
@Table(name="hospitaldetails")
@NamedQuery(name="Hospitaldetail.findAll", query="SELECT h FROM Hospitaldetail h")
public class Hospitaldetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int hospitalId;

	private String emergencyNumber;

	private String hospitalName;

	private String location;

	//bi-directional many-to-one association to Departmentdetail
	@OneToMany(mappedBy="hospitaldetail")
	private List<Departmentdetail> departmentdetails;

	public Hospitaldetail() {
	}

	public int getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getEmergencyNumber() {
		return this.emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Departmentdetail> getDepartmentdetails() {
		return this.departmentdetails;
	}

	public void setDepartmentdetails(List<Departmentdetail> departmentdetails) {
		this.departmentdetails = departmentdetails;
	}

	public Departmentdetail addDepartmentdetail(Departmentdetail departmentdetail) {
		getDepartmentdetails().add(departmentdetail);
		departmentdetail.setHospitaldetail(this);

		return departmentdetail;
	}

	public Departmentdetail removeDepartmentdetail(Departmentdetail departmentdetail) {
		getDepartmentdetails().remove(departmentdetail);
		departmentdetail.setHospitaldetail(null);

		return departmentdetail;
	}

}