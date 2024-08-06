package org.hotel.rec.service;

import org.hotel.rec.repository.AdminRepositiory;

public class AdminService 
{  
	AdminRepositiory arepo=new AdminRepositiory();
	public boolean authenticateadmin(String email,String pass)
	{
		return arepo.authenticateadmin(email,pass);
	}
}
