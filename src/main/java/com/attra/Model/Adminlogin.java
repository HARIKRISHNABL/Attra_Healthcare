package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the adminlogin database table.
 * 
 */
@Entity
@Table(name="adminlogin")
@NamedQuery(name="Adminlogin.findAll", query="SELECT a FROM Adminlogin a")
public class Adminlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String doctorEmail;

	private String password;

	public Adminlogin() {
	}

	public String getDoctorEmail() {
		return this.doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
