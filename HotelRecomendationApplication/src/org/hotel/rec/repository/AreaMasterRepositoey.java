package org.hotel.rec.repository;

import java.util.ArrayList;
import java.util.List;

import org.hotel.rec.config.DBHelper;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.CityMasterModel;

public class AreaMasterRepositoey extends DBHelper {
	private List<AreaMasterModel> list=new ArrayList<AreaMasterModel>();
	public boolean isAddArea(AreaMasterModel model) {
		try
		   {
			   stmt=conn.prepareStatement("insert into Area_Master values(?,?,?)");
			   stmt.setInt(1, model.getAreaId());
			   stmt.setString(2, model.getAreaName());
			   stmt.setInt(3, model.getCityId());
			   int value=stmt.executeUpdate();
			   return value>0?true:false;
		   }
		   catch(Exception ex)
		   {
			   System.out.println("Error is "+ex);
			   return false;
		   }
		
	}
	public List<AreaMasterModel> getAllAreas()
	   {  
	 	  try
	 	  {
	 		 stmt=conn.prepareStatement("select a.aid,a.area_name ,c.cityId ,c.cityName from area_master a join citymaster c on a.cityId=c.cityId ");
	 		 rs=stmt.executeQuery();
	 		 while(rs.next())
	 		 {
	 			AreaMasterModel model=new AreaMasterModel();
	 			 model.setAreaId(rs.getInt(1));
	 			 model.setAreaName(rs.getString(2));
	 			 model.setCityId(rs.getInt(3));
	 			model.setCityname(rs.getString(4));
	 			 list.add(model);
	 		 }
//	 		 conn.close();
//			 stmt.close();
//			 rs.close();
	 		 return list.size()>0?list:null;
	 	  }
	 	  catch(Exception ex)
	 	  {
	 		  System.out.println("error is "+ex);
	 		  return null;
	 	  }
	 	 
	   }
	public boolean isUpdateArea(int id,String areaname)
	{
		int val=0;
		try
		{
			stmt=conn.prepareStatement("update area_master set area_name=? where aid=?");
			stmt.setString(1, areaname);
			stmt.setInt(2, id);
			
			val=stmt.executeUpdate();
			if(val>0)
			{
				System.out.println("area name updated successfully");
			}
			else
			{
				System.out.println("area name is not updated");
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
		}
		return val>0?true:false;
	}
	 
	
}
