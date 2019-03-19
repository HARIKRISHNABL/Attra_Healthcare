package com.attra.DaoClassImpl;

import java.util.List;

import com.attra.Model.Appointmentdetail;

public interface PatientListInterface {
public List<Appointmentdetail> getPatientList(String email);
}
