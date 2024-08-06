package org.hotel.rec.model;

public class reviewModel 
{
   private int rid;
   private int artid;
   private String revDesc;
   private String date;
   private int userid;
   private int rating;
   private String hotelName;
   private String UserName;
   
   public reviewModel()
   {
	   
   }
   public reviewModel(int rid,int artid,String revDesc,String date,int userid,int rating,String hotelName,String UserName)
   {
	   this.rid=rid;
	   this.artid=artid;
	   this.revDesc=revDesc;
	   this.date=date;
	   this.userid=userid;
	   this.rating=rating;
	   this.hotelName=hotelName;
	   this.UserName=UserName;
   }
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getArtid() {
	return artid;
}
public void setArtid(int artid) {
	this.artid = artid;
}
public String getRevDesc() {
	return revDesc;
}
public void setRevDesc(String revDesc) {
	this.revDesc = revDesc;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}

}
