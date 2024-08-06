package org.hotel.rec.service;

import java.util.List;

import org.hotel.rec.model.AdminUserModel;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.ArticalModel;
import org.hotel.rec.model.ArticalReviewModel;
import org.hotel.rec.model.reviewModel;
import org.hotel.rec.repository.AdminUserRepositiory;

public class AdminUserService 
{
	AdminUserRepositiory adminrepo=new AdminUserRepositiory();
	
	public boolean isAddUser(AdminUserModel model)
	{
		boolean b=adminrepo.isAddUSer(model);
		return b;
	}
//	public boolean authenticatoruser(String email,String password)
//	{
//		boolean c=adminrepo.authenticatoruser(email, password);
//		return c;
//	}
    public boolean authenticatoruser(String email, String password) {
		
		return adminrepo.authenticatoruser(email,password);
	}
	public List<AdminUserModel> getAllUser()
	{  
		return adminrepo.getAllUser();
	}
	
	public boolean  getUpdateStatus(String mobile,String name)
	{
		return adminrepo.getUpdateStatus(mobile, name);
	}
	
	public List<AreaMasterModel> getCityByName(String cname) {
		return adminrepo.getCityByName(cname);		
	}
	public List<ArticalModel> getArticalByArea(String aname)
	{
		return adminrepo.getArticalByArea(aname);
	}
    public List<ArticalReviewModel> getArticalByRating(String aname)
    {
    	return adminrepo.getArticalByRating(aname);
    }
}
