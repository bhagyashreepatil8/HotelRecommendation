package org.hotel.rec.repository;

import java.util.ArrayList;
import java.util.List;

import org.hotel.rec.config.DBHelper;
import org.hotel.rec.model.AdminUserModel;
import org.hotel.rec.model.CityMasterModel;

public class CityMasterRepositiory extends DBHelper 
{
   private List<CityMasterModel> list=new ArrayList<CityMasterModel>();
   
   public boolean isAddCity(CityMasterModel model)
   {
	   try
	   {
		   stmt=conn.prepareStatement("insert into citymaster values('0',?)");
		   stmt.setString(1, model.getCityName());
		   int value=stmt.executeUpdate();
		   return value>0?true:false;
	   }
	   catch(Exception ex)
	   {
		   System.out.println("Error is "+ex);
		   return false;
	   }
   }
   public List<CityMasterModel> getAllCities()
   {  
 	  try
 	  {
 		 stmt=conn.prepareStatement("select *from citymaster");
 		 rs=stmt.executeQuery();
 		 while(rs.next())
 		 {
 			CityMasterModel model=new CityMasterModel();
 			 model.setCityId(rs.getInt(1));
 			 model.setCityName(rs.getString(2));
 			 
 			 list.add(model);
 		 }
// 		 conn.close();
//		 stmt.close();
//		 rs.close();
 		 return list.size()>0?list:null;
 	  }
 	  catch(Exception ex)
 	  {
 		  System.out.println("error is "+ex);
 		  return null;
 	  }
 	 
   }
   
   public boolean getUpdateCity(int cityid,String cityname)
   {
	   int val=0;
	   try
	   {
		  stmt=conn.prepareStatement("update citymaster set cityName=? where cityId=?");
		  stmt.setString(1, cityname);
		  stmt.setInt(2, cityid);
		  
		  val=stmt.executeUpdate();
		  if(val>0)
		  {
			  System.out.println("cityname updated successfully");
		  }
		  else
		  {
			  System.out.println("city name is not updated");
		  }
	   }
	   catch(Exception ex)
	   {
		   System.out.println("error is "+ex);
	   }
	   return val>0?true:false;
   }
  
}
