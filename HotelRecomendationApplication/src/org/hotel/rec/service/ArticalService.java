package org.hotel.rec.service;

import java.util.List;

import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.ArticalModel;
import org.hotel.rec.repository.ArticalRepositiory;

public class ArticalService 
{
	ArticalRepositiory artrepo=new ArticalRepositiory();
	
	public boolean isAddArtical(ArticalModel model)
	{
		boolean a=artrepo.isAddArtical(model);
		return a;
	}
	
	public List<ArticalModel> getAllArticle()
	{  
		return artrepo.getAllArtical();
	}

	public boolean updateHotelById(int ad, String artname) {
		return artrepo.updateHotelById(ad,artname);
	}
	
}
