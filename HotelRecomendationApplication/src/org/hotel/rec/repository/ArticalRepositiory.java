package org.hotel.rec.repository;

import java.util.ArrayList;
import java.util.List;

import org.hotel.rec.config.DBHelper;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.ArticalModel;

public class ArticalRepositiory extends DBHelper
{
  private List<ArticalModel> lis=new ArrayList<ArticalModel>();
  
  public boolean isAddArtical(ArticalModel mo)
  {
	  try
	  {
		  stmt=conn.prepareStatement("insert into artical values(?,?,?,?,?)");
		  stmt.setInt(1, mo.getAid());
		  stmt.setString(2, mo.getAname());
		  stmt.setInt(3, mo.getCityid());
		  stmt.setInt(4, mo.getAreaid());
		  stmt.setInt(5, mo.getAvgrating());
		  
		  int val=stmt.executeUpdate();
		  return val>0?true:false;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("error is "+ex);
		  return false;
	  }
	
  }
  public List<ArticalModel> getAllArtical()
  {  
	  try
	  {
		 stmt=conn.prepareStatement("select a.artId,a.artName,c.cityId,c.cityName,area.aid,area.area_name,a.avg_rating from artical a join citymaster c on a.cityId=c.cityId join area_master area on a.aid=area.aid");
		 rs=stmt.executeQuery();
		
		 while(rs.next())
		 {
			 ArticalModel model=new ArticalModel();
			 model.setAid(rs.getInt(1));
			 model.setAname(rs.getString(2));
			 model.setCityid(rs.getInt(3));
			 model.setCityName(rs.getString(4));
			 model.setAreaid(rs.getInt(5));
			 model.setAreaName(rs.getString(6));
			 model.setAvgrating(rs.getInt(7));
			 lis.add(model);
			 
		 }
//		 conn.close();
//		 stmt.close();
//		 rs.close();
			/*
			 * for(ArticalModel m:lis) {
			 * 
			 * System.out.println(m); System.out.println("hi"); }
			 * 
			 */		 return lis.size()>0?lis:null;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("error is "+ex);
		  return null;
	  }
  }

public boolean updateHotelById(int ad,String artname)
{
	int val=0;
	try
	{
		stmt=conn.prepareStatement("update artical set artName=? where artid=?");
		stmt.setString(1, artname);
		stmt.setInt(2, ad);
		
		val=stmt.executeUpdate();
		if(val>0)
		{
			System.out.println("article name updated successfully");
		}
		else
		{
			System.out.println("article name is not updated");
		}
	}
	catch(Exception ex)
	{
		System.out.println("error is "+ex);
	}
	return val>0?true:false;
}
}
