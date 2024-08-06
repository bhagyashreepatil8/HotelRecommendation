package org.hotel.rec.model;

public class AdminModel {
	private int admin_id;
	private String admin_name;
	private String admin_email;
	private String admin_contact;
	private String admin_password;
	
	AdminModel(){
		
	}
	AdminModel(int admin_id,String admin_name,String admin_email,String admin_contact,String admin_password){
		this.admin_id=admin_id;
		this.admin_name=admin_name;
		this.admin_email=admin_email;
		this.admin_contact=admin_contact;
		this.admin_password=admin_password;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

}
