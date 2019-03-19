package com.attra.DaoClassImpl;

import java.util.List;

import com.attra.Model.Adminlogin;
import com.attra.Model.Userregistration;

public interface PatientNameRetrieval {
	public String patientName(String email);
	public int patientIdRetrieval(String email);
}
