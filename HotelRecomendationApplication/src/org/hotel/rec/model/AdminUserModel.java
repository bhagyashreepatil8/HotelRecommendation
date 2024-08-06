package org.hotel.rec.model;

public class AdminUserModel 
{
  private int adminid;
  private String adminname;
  private String email;
  private String mobilenum;
  
  public AdminUserModel()
  {
	  
  }
  public AdminUserModel(int adminid,String adminname,String email,String mobilenum,String password,String status)
  {
	  this.adminid=adminid;
	  this.adminname=adminname;
	  this.email=email;
	  this.mobilenum=mobilenum;
	  this.password=password;
	  this.status=status;
  }
  public int getAdminid() {
	return adminid;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobilenum() {
	return mobilenum;
}
public void setMobilenum(String mobilenum) {
	this.mobilenum = mobilenum;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String password;
  private String status;
}
