package org.hotel.rec.service;

import java.util.List;

import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.CityMasterModel;
import org.hotel.rec.repository.AreaMasterRepositoey;
import org.hotel.rec.repository.CityMasterRepositiory;

public class AreaMasterService {
	 AreaMasterRepositoey arrepo=new AreaMasterRepositoey();
	
	public boolean isAddArea(AreaMasterModel model)
	{
		boolean a=arrepo.isAddArea(model);
		return a;
	}
	public List<AreaMasterModel> getAllAreas()
	{  
		return arrepo.getAllAreas();
	}
	public boolean isUpdateArea(int id,String areaname)
	{
		return arrepo.isUpdateArea(id, areaname);
	}
}
