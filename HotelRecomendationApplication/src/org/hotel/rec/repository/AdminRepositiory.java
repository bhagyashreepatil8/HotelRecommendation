package org.hotel.rec.repository;

import java.sql.SQLException;

import org.hotel.rec.config.DBHelper;

public class AdminRepositiory extends DBHelper
{
   public boolean authenticateadmin(String email,String pass)
   {
	int value = 0;
  try
  {
	  stmt=conn.prepareStatement("select ademail,pass from admin where ademail=? and pass=?");
	  stmt.setString(1, email);
	  stmt.setString(2, pass);
	  rs=stmt.executeQuery();
	  while(rs.next())
	  {
		  String mail;
		  String password;
		  mail=rs.getString(1);
		  password=rs.getString(2);
		  
		  if(mail.equals(email) && password.equals(pass)) {
			  value=1;
		  }
	  }
  }
  catch(SQLException e)
  {
	  e.printStackTrace();
  }
  return value>0?true:false;
   }
}
