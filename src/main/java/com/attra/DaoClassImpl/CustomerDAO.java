package com.attra.DaoClassImpl;

import java.util.List;

import com.attra.Model.Departmentdetail;
import com.attra.Model.Hospitaldetail;

public interface CustomerDAO {
	
	/*public List<Hospitaldetail> getCustomers();
	
	public List<Departmentdetail> getDepartmentdetail(int id);*/

	public boolean saveData(int hospId, int depId, int docId, String schDelId, String doctorAvail,String patientname,int patientid);
}
