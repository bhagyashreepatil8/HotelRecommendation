package org.hotel.rec.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hotel.rec.config.DBHelper;
import org.hotel.rec.model.AdminUserModel;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.ArticalModel;
import org.hotel.rec.model.ArticalReviewModel;
import org.hotel.rec.model.reviewModel;

public class AdminUserRepositiory extends DBHelper
{ 
	private List<AdminUserModel> list=new ArrayList<AdminUserModel>();
  public boolean isAddUSer(AdminUserModel model)
  {
	  try
	  {
		  stmt=conn.prepareStatement("insert into user values('0',?,?,?,?,?)");
		  stmt.setString(1, model.getAdminname());
		  stmt.setString(2, model.getEmail());
		  stmt.setString(3, model.getMobilenum());
		  stmt.setString(4, model.getPassword());
		  stmt.setString(5, model.getStatus());
		  int value=stmt.executeUpdate();
		  return value>0?true:false;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("error is "+ex);
		  return false;
	  }
	  
  }

public boolean authenticatoruser(String email, String password) {
	 int value=0;
	   try {
		stmt=conn.prepareStatement("select email,password from user where email=? and password=?");
		  stmt.setString(1, email);
		  stmt.setString(2, password);
		  rs=stmt.executeQuery();
		  while(rs.next()) {
			  String emil;
			  String pass;
			  emil=rs.getString(1);
			  pass=rs.getString(2);
	          
			  if(emil.equals(email) && pass.equals(password)) {
				  value=1;
			  }
		  }
		 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	   
	return value>0?true:false;
}

public List<AdminUserModel> getAllUser()
{  
	  try
	  {
		 stmt=conn.prepareStatement("select *from user");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 AdminUserModel model=new AdminUserModel();
			 model.setAdminid(rs.getInt(1));
			 model.setAdminname(rs.getString(2));
			 model.setEmail(rs.getString(3));
			 model.setMobilenum(rs.getString(4));
			 model.setPassword(rs.getString(5));
			 model.setStatus(rs.getString(6));
			 list.add(model);
		 }
//		 conn.close();
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

public boolean getUpdateStatus(String mobile,String name)
{
int value=0;
try
{
	stmt=conn.prepareStatement("update user set adminName=? where mobilenum=?");
	stmt.setString(1, name);
	stmt.setString(2, mobile);
	
	 value=stmt.executeUpdate();
	 if(value>0)
	 {
		 System.out.println("user updated successfully");
	 }
	 else
	 {
		 System.out.println("no user found with a given mobile num");
	 }
}
catch(Exception ex)
{
	System.out.println("error is "+ex);
}
return value>0?true:false;
}

public List<AreaMasterModel> getCityByName(String cname) 
{
	int value=0;
	
	 List<AreaMasterModel> amml= new ArrayList<AreaMasterModel>();
	try {
		String cityname=null;
		 
		stmt=conn.prepareStatement("select cityName from citymaster where cityName=?");
		stmt.setString(1, cname);
		rs=stmt.executeQuery();
		while(rs.next()) 
		{
			
			cityname=rs.getString(1);
		}
			if(cityname.equals(cname)) 
			{
				stmt=conn.prepareStatement("select a.area_name from area_master a join citymaster c on c.cityId=a.cityId where cityName=?");
				stmt.setString(1, cityname);
				rs=stmt.executeQuery();
				while(rs.next()) {
					AreaMasterModel model=new AreaMasterModel();
				model.setAreaName(rs.getString(1));
				amml.add(model);
				}	
			}
			else 
			{
				System.out.println("No City With Such Name found");
			}		
	}
	catch(Exception ex) {
		System.out.println("Error is "+ex);
	}
	return amml.size()>0?amml: null;
}
public List<ArticalModel> getArticalByArea(String aname) 
{
	int value=0;
	List<ArticalModel> artm= new ArrayList<ArticalModel>();
//	List<reviewModel>rmod=new ArrayList<reviewModel>();
	try
	{
		String areaname=null;
		 
		stmt=conn.prepareStatement("select area_name from area_master where area_name=?");
		stmt.setString(1, aname);
		rs=stmt.executeQuery();
		while(rs.next()) 
		{
			
			areaname=rs.getString(1);
		}
		if(areaname.equals(aname)) 
		{
			stmt=conn.prepareStatement("select a.artName from artical a join area_master m on a.aid=m.aid where area_name=?");
//			stmt=conn.prepareStatement("select a.artName ,avg(r.rating),r.rev_desc from area_master area join artical a on area.aid=a.aid join rating_master r on r.artId=a.artId where area_name=? group by artName order by avg(r.rating ) desc");
			stmt.setString(1, areaname);
			rs=stmt.executeQuery();
			while(rs.next()) {
				ArticalModel model=new ArticalModel();
//				reviewModel model1=new reviewModel();
			model.setAname(rs.getString(1));
//			model1.setRating(rs.getInt(2));
//			model1.setRevDesc(rs.getString(3));
			artm.add(model);
//			rmod.add(model1);
			}	
		}
		else 
		{
			System.out.println("No Hotel Found In Given Area");
		}		
	}
	catch(Exception ex)
	{
		System.out.println("Error is "+ex);
	}
	return artm.size()>0?artm: null;
}
 
 private List<ArticalReviewModel>rmod=new ArrayList<ArticalReviewModel>();
public List<ArticalReviewModel> getArticalByRating(String aname) 
{    
	int value=0;
	List<ArticalReviewModel>rmod=new ArrayList<ArticalReviewModel>();
	try
	{
		
		stmt=conn.prepareStatement("select area.area_name, a.artName,avg(r.rating),r.rev_desc from area_master area join artical a on area.aid=a.aid join rating_master r on r.artId=a.artId where area_name=? group by artName order by avg(r.rating )desc limit 2");
		stmt.setString(1,aname );
		rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 ArticalReviewModel model=new ArticalReviewModel();
			 model.setAreaName(rs.getString(1));
			 model.setArticalName(rs.getString(2));
			 model.setRating(rs.getFloat(3));
			 model.setReview(rs.getString(4));
			 
//			 System.err.println(model);
//			 System.out.println("Area Name"+rs.getString(1)+"\t"+"Name"+rs.getString(2)+"Avg Rate"+rs.getInt(3)+"Rev"+rs.getString(4));
			 rmod.add(model);
		 }
		 
//		 System.err.println(rmod);
		 return rmod.size()>0?rmod:null;
	}
	catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return null;
	}
	
}

//public List<Object[]> getArticalByRating()
//{
//	try
//	{
//		
//	}
//	catch(Exception ex)
//	{
//		System.out.println("Error is "+ex);
//	}
//}
}
	
	
//	String checkCityQuery = "SELECT cityName FROM citymaster WHERE cityName=?";
//    String getAreasQuery = "SELECT a.area_name FROM area_master a inner join citymaster c ON c.cityId=a.cityId WHERE c.cityName=cname";
//    
//    try {
//    		    stmt = conn.prepareStatement("SELECT cityName FROM citymaster WHERE cityName=?"); 
//     stmt.setString(1, cname);
//	
//        try 
//	        {
//	           rs = stmt.executeQuery()) {
//             if (rs.next()) 
//	           {
//                try 
//	                 { 
//	                   stmt = conn.prepareStatement("SELECT a.area_name FROM area_master a inner join citymaster c ON c.cityId=a.cityId WHERE c.cityName=cname");                      stmt.setString(1, cname);
//	              
//                   try
//	                  {   
//	                      rs = stmt.executeQuery() 
//	                     {
//                        if (rs.next()) 
//	                      {
//                            return true;  // Areas found for the given city name
//                        } else 
//	                      {
//                            System.out.println("No areas found for the city: " + cname);
//                            return false; // No areas found
//                        }
//                    }
//                }
//            } 
//	         else 
//	         {
//                System.out.println("No City With Such Name found");
//                return false; // City not found
//            }
//        }
//    } catch (Exception ex) 
//	   {
//        System.out.println("Error is " + ex);
//        return false; // Indicate error occurred
//    }
//}
//}
//select a.artName ,avg(r.rating),r.rev_desc from area_master area join artical a on area.aid=a.aid join rating_master r on r.artId=a.artId where area_name="kothrud
//" group by artName order by avg(r.rating ) desc ;
