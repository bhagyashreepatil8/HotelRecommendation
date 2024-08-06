package org.hotel.rec.model;

public class AreaMasterModel {
	private int areaId;
	private String areaName;
	private int cityId;
	private String cityname;
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public AreaMasterModel(){
		
	}
	AreaMasterModel(int areaId,String areaName,int cityId,String cityname){
		this.areaId=areaId;
		this.areaName=areaName;
		this.cityId=cityId;
		this.cityname=cityname;
	}
}
