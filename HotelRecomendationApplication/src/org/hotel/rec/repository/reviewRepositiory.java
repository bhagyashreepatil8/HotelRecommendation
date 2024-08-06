package org.hotel.rec.repository;

import java.util.ArrayList;
import java.util.List;

import org.hotel.rec.config.DBHelper;
import org.hotel.rec.model.CityMasterModel;
import org.hotel.rec.model.reviewModel;

public class reviewRepositiory extends DBHelper
{
  private List<reviewModel> list=new ArrayList<reviewModel>();
  
  public boolean isAddRev( reviewModel model)
  {
	  try
	  {
		  stmt=conn.prepareStatement("insert into rating_master values(?,?,?,?,?,?)");
		  stmt.setInt(1,model.getRid());
		  stmt.setInt(2,model.getArtid() );
		  stmt.setString(3, model.getRevDesc());
		  stmt.setString(4,model.getDate());
		  stmt.setInt(5, model.getUserid());
		  stmt.setInt(6, model.getRating());
		  int val=stmt.executeUpdate();
		  return val>0?true:false;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("error is "+ex);
		  return false;
	  }
  }

public List<reviewModel> getAllReviews() {
	try
	  {
		 stmt=conn.prepareStatement("select r.rId , a.artId ,a.artName, r.rev_desc,r.rev_date,u.adminId,u.adminName,r.rating from rating_master r join artical a on r.artId=a.artId join user u on u.adminId=r.adminId ");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			reviewModel model=new reviewModel();
			 model.setRid(rs.getInt(1));
			 model.setArtid(rs.getInt(2));
			 model.setHotelName(rs.getString(3));
			 model.setRevDesc(rs.getString(4));
			 model.setDate(rs.getString(5));
			 model.setUserid(rs.getInt(6));
			 model.setUserName(rs.getString(7));
			 model.setRating(rs.getInt(8));
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
}
