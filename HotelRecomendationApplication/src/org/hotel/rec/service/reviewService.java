package org.hotel.rec.service;

import java.util.List;

import org.hotel.rec.model.CityMasterModel;
import org.hotel.rec.model.reviewModel;
import org.hotel.rec.repository.reviewRepositiory;

public class reviewService 
{
	reviewRepositiory rrepo=new reviewRepositiory();
	
	public boolean isAddRev( reviewModel model)
	{
		boolean a=rrepo.isAddRev(model);
		return a;
	}

	public List<reviewModel> getAllReviews() {
		return rrepo.getAllReviews();
	}
}
