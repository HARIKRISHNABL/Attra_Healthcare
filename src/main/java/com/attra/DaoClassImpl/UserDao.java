package com.attra.DaoClassImpl;

import com.attra.Model.Userlogin;
import com.attra.Model.Userregistration;

public interface UserDao {
	public boolean register(Userregistration userReg);
	public boolean UserLoginCheck(Userlogin userlogin);
}
