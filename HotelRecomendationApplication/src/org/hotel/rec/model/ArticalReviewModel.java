package org.hotel.rec.model;

public class ArticalReviewModel 
{
  private String articalName;
  private float rating;
  private String review;
  private String areaName;
  @Override
public String toString() {
	return "ArticalReviewModel [articalName=" + articalName + ", rating=" + rating + ", review=" + review
			+ ", areaName=" + areaName + "]";
}
public ArticalReviewModel ()
  {
	  
  }
  public ArticalReviewModel (String articalName,float rating,String review,String areaName)
  {
	  this.articalName=articalName;
	  this.rating=rating;
	  this.review=review;
	  this.areaName=areaName;
  }
  
public String getAreaName() {
	return areaName;
}
public void setAreaName(String areaName) {
	this.areaName = areaName;
}
public String getArticalName() {
	return articalName;
}
public void setArticalName(String articalName) {
	this.articalName = articalName;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
}
