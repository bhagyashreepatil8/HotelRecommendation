package org.hotel.rec.service;

import java.util.List;

import org.hotel.rec.model.AdminUserModel;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.CityMasterModel;
import org.hotel.rec.repository.CityMasterRepositiory;

public class CityMasteService 
{
	CityMasterRepositiory cmrepo=new CityMasterRepositiory();
	
	public boolean isAddCity(CityMasterModel model)
	{
		boolean a=cmrepo.isAddCity(model);
		return a;
	}
	public List<CityMasterModel> getAllCities()
	{  
		return cmrepo.getAllCities();
	}
	public boolean getUpdateCity(int cityid,String cityname)
	{
		return cmrepo.getUpdateCity(cityid, cityname);
	}
	
}
