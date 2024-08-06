package org.hotel.rec.model;

public class ArticalModel 
{
  @Override
	public String toString() {
		return "ArticalModel [aid=" + aid + ", aname=" + aname + ", cityid=" + cityid + ", areaid=" + areaid
				+ ", AreaName=" + AreaName + ", CityName=" + CityName + ", avgrating=" + avgrating + "]";
	}
private int aid;
  private String aname;
  private int cityid;
  private int areaid;
  private String AreaName;
  private String CityName;
  public ArticalModel()
  {
	  
  }
  public ArticalModel(int aid,String aname,int cityid,int areaid,String AreaName,String CityName)
  {
	  this.aid=aid;
	  this.aname=aname;
	  this.cityid=cityid;
	  this.areaid=areaid;
	  this.AreaName=AreaName;
	  this.CityName=CityName;
  }
  
  
  public String getAreaName() {
	return AreaName;
}
public void setAreaName(String areaName) {
	AreaName = areaName;
}
public String getCityName() {
	return CityName;
}
public void setCityName(String cityName) {
	CityName = cityName;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public int getCityid() {
	return cityid;
}
public void setCityid(int cityid) {
	this.cityid = cityid;
}
public int getAreaid() {
	return areaid;
}
public void setAreaid(int areaid) {
	this.areaid = areaid;
}
public int getAvgrating() {
	return avgrating;
}
public void setAvgrating(int avgrating) {
	this.avgrating = avgrating;
}
private int avgrating;
}
