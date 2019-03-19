package com.attra.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userlogin database table.
 * 
 */
@Entity
@Table(name="userlogin")
@NamedQuery(name="Userlogin.findAll", query="SELECT u FROM Userlogin u")
public class Userlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	public Userlogin() {
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

}
