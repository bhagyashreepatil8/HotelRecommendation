package org.hotel.rec.client;
import java.util.*;

import org.hotel.rec.model.AdminUserModel;
import org.hotel.rec.model.AreaMasterModel;
import org.hotel.rec.model.ArticalModel;
import org.hotel.rec.model.ArticalReviewModel;
import org.hotel.rec.model.CityMasterModel;
import org.hotel.rec.model.reviewModel;
import org.hotel.rec.service.AdminService;
import org.hotel.rec.service.AdminUserService;
import org.hotel.rec.service.AreaMasterService;
import org.hotel.rec.service.ArticalService;
import org.hotel.rec.service.CityMasteService;
import org.hotel.rec.service.reviewService;

public class HotelRecomendationApplication {

	public static void main(String[] args) 
	{   
		AdminUserService  aus=new AdminUserService ();
		CityMasteService cms=new CityMasteService();
		AreaMasterService ams=new AreaMasterService();
		ArticalService as=new ArticalService ();
		AdminService ads=new AdminService();
		reviewService rs=new reviewService();
		
		do
		{
			Scanner xyz=new Scanner(System.in);
			int choice;
//			System.out.println("************************************************************************************************************************************************************************");
			System.out.println("Case1--> Admin Login");
     		System.out.println("Case2--> User Login");
     		System.out.println("--------------------------------------------------------------------");
//			System.out.println("3--> Add And View Area Details Update AreaName");
//			System.out.println("4--> Add & View Artical");
//			System.out.println("5--> Login Admin");
			System.out.println("Enter your choice");
			System.out.println("--------------------------------------------------------------------");
			choice=xyz.nextInt();
			
			switch(choice)
			{  
			case 1:
			{
			
				
				do {
					System.out.println("Case1---> Admin Login");
					
					System.out.println("--------------------------------------------------------------------");
					System.out.println("Enter Your Choice...!!!");
					System.out.println("--------------------------------------------------------------------");
					choice=xyz.nextInt();
					switch(choice) {
					case 1:
					{   xyz.nextLine();
						System.out.println("Enter Your Email");
						String email=xyz.nextLine();
						xyz.nextLine();
						System.out.println("Enter Your Password");
						String pass=xyz.nextLine();
						boolean login= ads.authenticateadmin(email,pass);
						if(login) {
							System.out.println("Login Succesfully...!!!");
							do {
								System.out.println("Case1---> Add Cities");
								System.out.println("Case2---> Add Areas");
								System.out.println("Case3---> Add Hotels");
								//System.out.println("Case4--->Recommend hotel to customer");
								switch(ch) {
								case 1:
								{
									do {
										System.out.println("Case1--->Add Cities");
										System.out.println("Case2--->View Cities");
										System.out.println("Case3--->Update City by id");
										System.out.println("--------------------------------------------------------------------");
										System.out.println("Enter Your Choice");
										System.out.println("--------------------------------------------------------------------");
										choice=xyz.nextInt();
										switch(choice) {
										case 1:
										{
											System.out.println("Enter cityname");
											xyz.nextLine();
											String city=xyz.nextLine();
											CityMasterModel model=new CityMasterModel();
											model.setCityName(city);
											boolean b=cms.isAddCity(model);
											if(b)
											{
												System.out.println("City added successfully");
											}
											else
											{
												System.out.println("City not added");
											}
											
										}
										break;
										case 2:
										{
											List<CityMasterModel> list=cms.getAllCities();
											if(list!=null)
											{
												list.forEach((m)->System.out.println(m.getCityId()+"\t"+m.getCityName()));
//												list.forEach((m)->System.out.println(m.getCityId()+"\t"+m.getCityName()));
											}
											else
											{
												System.out.println("No City Present...!!");
											}
											
										}
										break;
										case 3:
										{
											System.out.println("Enter city id ");
											int id=xyz.nextInt();
											System.out.println("Enter city name for updation");
											xyz.nextLine();
											String name=xyz.nextLine();
											cms.getUpdateCity(id, name);
										}
										break;
										}
										
									}while(choice<=3);
								}
								break;
								case 2:
								{
									do {
										System.out.println("Case1---> Add Areas");
										System.out.println("Case2---> View Areas");
										System.out.println("Case3---> Update Areas");
										System.out.println("--------------------------------------------------------------------");;
										System.out.println("Enter Your Choice");
										System.out.println("--------------------------------------------------------------------");
										choice=xyz.nextInt();
										switch(choice) {
										case 1:
										{
											System.out.println("Enter Area ID");
											int id=xyz.nextInt();
											System.out.println("Enter Area Name");
											xyz.nextLine();
											String area=xyz.nextLine();
											System.out.println("Enter City Id");
											int cid=xyz.nextInt();
											AreaMasterModel model=new AreaMasterModel();
											model.setAreaId(id);
											model.setAreaName(area);
											model.setCityId(cid);
											boolean b=ams.isAddArea(model);
											if(b)
											{
												System.out.println("Area added successfully");
											}
											else
											{
												System.out.println("Area not added");
											}
											
										}
										break;
										case 2:
										{
											List<AreaMasterModel> list=ams.getAllAreas();
											if(list!=null)
											{
												list.forEach((m)->System.out.println(String.format("%-5s %-15s %-5s %-10s",m.getAreaId(),m.getAreaName(),m.getCityId(),m.getCityname())));
											}
											else
											{
												System.out.println("No Areas Present...!!");
											}
											
										}
										break;
										case 3:
										{
											System.out.println("Enter area id");
											int arid=xyz.nextInt();
											System.out.println("Enter area name for updation");
											xyz.nextLine();
											String arname=xyz.nextLine();
											ams.isUpdateArea(arid, arname);
											
										}
										break;
										}
										
									}while(choice<=3);
									
									 
								}
								break;
								case 3:
								{
									do {
										System.out.println("Case1---> Add Hotels");
										System.out.println("Case2---> View Hotels");
										System.out.println("Case3---> Update Hotels");
										System.out.println("--------------------------------------------------------------------");
										System.out.println("Enter Your Choice");
										System.out.println("--------------------------------------------------------------------");
										choice=xyz.nextInt();
										switch(choice) {
										case 1:
										{
											System.out.println("Enter artical id");
											int aid=xyz.nextInt();
											System.out.println("Enter artical name");
											xyz.nextLine();
											String artname = xyz.nextLine();
											System.out.println("Enter city id");
											int cid=xyz.nextInt();
											System.out.println("Enter area id");
											int arid=xyz.nextInt();
											System.out.println("Avarage rating");
											int avrating=xyz.nextInt();
											
											ArticalModel model=new ArticalModel();
											model.setAid(aid);
											model.setAname(artname);
											model.setCityid(cid);
											model.setAreaid(arid);
											model.setAvgrating(avrating);
											boolean b=as.isAddArtical(model);
											if(b)
											{
												System.out.println("Artical Added Succsesfully");
											}
											else
											{
												System.out.println("Artical Not Added");
											}
											
										}
										break;
										case 2:
										{
											List<ArticalModel> list= null; //as.getAllArticle();
											list=as.getAllArticle();
												if(list!=null)
												{
													list.forEach((m)->System.out.println(String.format("%-4s %-20s %-4s %-15s %-4s %-4s %-10s",m.getAid(),m.getAname(),m.getAreaid(),m.getAreaName(),m.getCityid(),m.getAvgrating(),m.getCityName())));
												}
												else
												{
													System.out.println("No Hotel Present...!!");
												}
											
										}
										break;
										case 3:
										{
											System.out.println("Enter article id");
											int ad=xyz.nextInt();
											System.out.println("Enter Hotel Name for updation");
											xyz.nextLine();
											String artname=xyz.nextLine();
											as.updateHotelById(ad,artname);
											
										}
										break;
										 case 4:
											   {
												   List<reviewModel> list=rs.getAllReviews();
													if(list!=null)
													{
														list.forEach((m)->System.out.println(String.format("%-8s %-8s %-30s %-50s %-15s %-8s %-15s %-8s",m.getRid(),m.getArtid(),m.getHotelName(),m.getRevDesc(),m.getDate(),m.getUserid(),m.getUserName(),m.getRating())));
													}
													else
													{
														System.out.println("No Reviews Added...!!");
													}
												   
											   }
											   break;
										}
									}while(choice!=5);
								}
								}
							
							
						 }
						}while(choice<=4);
					}else {
						System.out.println("Invalid Email password...!!!");
					}
//					break;
					
//					case 5:
//					{
//						List<AreaMasterModel> amml= new ArrayList<AreaMasterModel>();
//						 List<ArticalModel> artm=new ArrayList<ArticalModel>();
//						 List<ArticalReviewModel> rmod=new ArrayList<ArticalReviewModel>();
//						 
//					   System.out.println("Enter City Name In Which You Want to Explore Hotel");
//					   System.out.println("--------------------------------------------------------------------");
//					   xyz.nextLine();
//					   String Cname=xyz.next();
//					   amml=aus.getCityByName(Cname);
////					   System.out.println("Welcome To "+Cname+"\n"+"Area List As Below: ");
//					   System.out.println("--------------------------------------------------------------------");
//					   if(amml!=null)
//						{
//						   System.out.println("Welcome To "+Cname+"\n"+"Area List As Below: ");
//						   System.out.println("--------------------------------------------------------------------");
//						   amml.forEach((m)->System.out.println(m.getAreaName()));
//						   System.out.println("--------------------------------------------------------------------");
//						   
//						}
//					   System.out.println("Select prefarable area");
//					   System.out.println("--------------------------------------------------------------------");
//					   xyz.nextLine();
//					   String aname=xyz.next();
//					   artm=aus.getArticalByArea(aname);
//					  // System.out.println("Welcome To "+aname+"\n"+"Hotel List As Below: ");
//					   System.out.println("--------------------------------------------------------------------");
//					   if(artm!=null)
//						{
//						   System.out.println("Welcome To "+aname+"\n"+"Hotel List As Below: ");
//						   System.out.println("--------------------------------------------------------------------");
//						   artm.forEach((m)->System.out.println(m.getAname()));
//						   System.out.println("--------------------------------------------------------------------");
//						   
//						}
//					   
//					   System.out.println("Top 2 Hotels In Specific Area You Selected Based On Rating Provided By Visited User:");
//					   System.out.println("--------------------------------------------------------------------");
//					   rmod=new ArrayList<ArticalReviewModel>();
//					   List<ArticalReviewModel> alist=aus.getArticalByRating(aname);
//					   
//					   if(alist!=null)
//					   {
//						  // alist=aus.getArticalByRating();
//						   
//						   alist.forEach((m)->System.out.println(m.getAreaName()+"\t\t"+m.getArticalName()+"\t\t\t"+m.getRating()+"\t\t"+m.getReview()));
//					   }
//					}
//					break;
					}
				
//				}
//				while(choice<=5);
//		}
			break;
			case 2:
			{   
				do
				{  	System.out.println("--------------------------------------------------------------------");
					System.out.println("1--> Ragister User");
					System.out.println("2--> Login User");
//					System.out.println("3--> Display user details");
					System.out.println("4--> Submit Reviews");
//					System.out.println("5--> Display Reviews");
      				System.out.println("6--> Recommend Hotel To user");
					System.out.println("--------------------------------------------------------------------");
//					System.out.println("4--> Update user details by name");
				    System.out.println("enter your choice");
				    System.out.println("--------------------------------------------------------------------");
				    choice=xyz.nextInt();
				   switch(choice) 
				   
				   {
				   case 1: 
				   {
					   System.out.println("enter user name");
						xyz.nextLine();
						String name=xyz.nextLine();
						System.out.println("enter user email");
						String email=xyz.nextLine();
						System.out.println("Enter user mobile number");
						String mobile=xyz.nextLine();
						System.out.println("Enter user password");
						String pass=xyz.nextLine();
						System.out.println("enter user status");
						String status=xyz.nextLine();
						
						AdminUserModel model=new AdminUserModel ();
						model.setAdminname(name);
						model.setEmail(email);
						model.setMobilenum(mobile);
						model.setPassword(pass);
						model.setStatus(status);
						boolean b=aus.isAddUser(model);
						if(b)
						{
							System.out.println("User Ragistered Successfully");
						}
						else
						{
							System.out.println("User ragistration failed");
						} 
				   }
				   break;
				   
				   case 2:
				   {
					   System.out.println("Enter Your Email:");
						 String email=xyz.next();
						 System.out.println("Enter Your Password:");
						 String password=xyz.next();
						boolean isauthenticated=aus.authenticatoruser(email,password);
						if(isauthenticated)
						{
							System.out.println("user authenticated scussfully");
						}
						else
						{
							System.out.println("authentication falisd");
						}
				   }
				   break;
				   
				   //case 3:
//				   {
//					   List<AdminUserModel> list=aus.getAllUser();
//						if(list!=null)
//						{
//							list.forEach((m)->System.out.println(m.getAdminid()+"\t"+m.getAdminname()+"\t"+m.getEmail()+"\t"+m.getMobilenum()+"\t"+m.getPassword()+"\t"+m.getStatus()));
//						}
//						else
//						{
//							System.out.println("there is no user present");
//						}
//				   }
				  // break;
				  
//				   case 4:
//				   {
//					   System.out.println("enter user mobile number");
//					   xyz.nextLine();
//					   String mobile=xyz.nextLine();
//					   System.out.println("enter user name for updation");
//					   String name=xyz.nextLine();
//					   aus.getUpdateStatus(mobile, name);
//				   }
//				   break;
				   
				   case 3:
				   {
					   System.out.println("Enter revid");
					   int revid=xyz.nextInt();
					   System.out.println("Enter articalid");
					   int artid=xyz.nextInt();
					   System.out.println("Give your valuable review");
					   xyz.nextLine();
					   String revdesc=xyz.nextLine();
					   System.out.println("Enter rev date");
					   String date=xyz.nextLine();
					   System.out.println("Enter userid");
					   int uid=xyz.nextInt();
					   System.out.println("Give your valuable rating");
					   int ratint=xyz.nextInt();
					   
					   reviewModel rmodel=new reviewModel ();
					   rmodel.setRid(revid);
					   rmodel.setArtid(artid);
					   rmodel.setRevDesc(revdesc);
					   rmodel.setDate(date);
					   rmodel.setUserid(uid);
					   rmodel.setRating(ratint);
					   rmodel.setHotelName(date);
					   boolean r=rs.isAddRev(rmodel);
					   if(r)
					   {
						   System.out.println("Review added succsessfully....");
					   }
					   else
					   {
						   System.out.println("Rev not added.....");
					   }
							   
				   }
				   break;
//				   case 5:
//				   {
//					   List<reviewModel> list=rs.getAllReviews();
//						if(list!=null)
//						{
//							list.forEach((m)->System.out.println(String.format("%-8s %-8s %-30s %-50s %-15s %-8s %-15s %-8s",m.getRid(),m.getArtid(),m.getHotelName(),m.getRevDesc(),m.getDate(),m.getUserid(),m.getUserName(),m.getRating())));
//						}
//						else
//						{
//							System.out.println("No Reviews Added...!!");
//						}
//					   
//				   }
//				   break;
				   
				   case 4:
				   {
						 List<AreaMasterModel> amml= new ArrayList<AreaMasterModel>();
						 List<ArticalModel> artm=new ArrayList<ArticalModel>();
						 List<ArticalReviewModel> rmod=new ArrayList<ArticalReviewModel>();
						 
					   System.out.println("Enter City Name In Which You Want to Explore Hotel");
					   System.out.println("--------------------------------------------------------------------");
					   xyz.nextLine();
					   String Cname=xyz.next();
					   amml=aus.getCityByName(Cname);
//					   System.out.println("Welcome To "+Cname+"\n"+"Area List As Below: ");
					   System.out.println("--------------------------------------------------------------------");
					   if(amml!=null)
						{
						   System.out.println("Welcome To "+Cname+"\n"+"Area List As Below: ");
						   System.out.println("--------------------------------------------------------------------");
						   amml.forEach((m)->System.out.println(m.getAreaName()));
						   System.out.println("--------------------------------------------------------------------");
						   
						}
					   System.out.println("Select prefarable area");
					   System.out.println("--------------------------------------------------------------------");
					   xyz.nextLine();
					   String aname=xyz.next();
					   artm=aus.getArticalByArea(aname);
					  // System.out.println("Welcome To "+aname+"\n"+"Hotel List As Below: ");
					   System.out.println("--------------------------------------------------------------------");
					   if(artm!=null)
						{
						   System.out.println("Welcome To "+aname+"\n"+"Hotel List As Below: ");
						   System.out.println("--------------------------------------------------------------------");
						   artm.forEach((m)->System.out.println(m.getAname()));
						   System.out.println("--------------------------------------------------------------------");
						   
						}
					   
					   System.out.println("Top 3 Hotels In Specific Area You Selected Based On Rating Provided By Visited User:");
					   System.out.println("--------------------------------------------------------------------");
					   rmod=new ArrayList<ArticalReviewModel>();
					   List<ArticalReviewModel> alist=aus.getArticalByRating(aname);
					   
					   if(alist!=null)
					   {
						  // alist=aus.getArticalByRating();
						   
						   alist.forEach((m)->System.out.println(m.getAreaName()+"\t\t"+m.getArticalName()+"\t\t\t"+m.getRating()+"\t\t"+m.getReview()));
					   }
				   }
				   break;
				}
				}
				while(choice<=4);
				
			}
//			case 2:
//			{	
//				do
//				{
//				System.out.println("Case 1---> Add City Details");
//				System.out.println("Case 2---> View City Details");
//				System.out.println("case 3---> Update City Name");
//				System.out.println("Enter Your Choice...!!!");
//				choice=xyz.nextInt();
//				switch(choice) {
//				case 1:
//				{
//
//					System.out.println("enter cityname");
//					xyz.nextLine();
//					String city=xyz.nextLine();
//					CityMasterModel model=new CityMasterModel();
//					model.setCityName(city);
//					boolean b=cms.isAddCity(model);
//					if(b)
//					{
//						System.out.println("city added successfully");
//					}
//					else
//					{
//						System.out.println("city not added");
//					}
//				}
//				break;
//				case 2:
//				{
//					List<CityMasterModel> list=cms.getAllCities();
//					if(list!=null)
//					{
//						list.forEach((m)->System.out.println(m.getCityId()+"\t"+m.getCityName()));
//					}
//					else
//					{
//						System.out.println("No City Present...!!");
//					}
//				}
//				break;
//				case 3:
//				{
//					System.out.println("enter city id ");
//					int id=xyz.nextInt();
//					System.out.println("enter city name for updation");
//					xyz.nextLine();
//					String name=xyz.nextLine();
//					cms.getUpdateCity(id, name);
//				}
//				break;
//				}
//			}
//			while(choice<=2);
//			}
//			case 3:
//			{
//				do {
//					System.out.println("Case 1---> Add Areas");
//					System.out.println("Case 2---> View Areas");
//					System.out.println("case 3---> Update AreaName");
//					System.out.println("Enter Your Choice");
//					choice=xyz.nextInt();
//					switch(choice) {
//					case 1:
//					{
//						System.out.println("Enter Area ID");
//						int id=xyz.nextInt();
//						System.out.println("Enter Area Name");
//						xyz.nextLine();
//						String area=xyz.nextLine();
//						System.out.println("Enter City Id");
//						int cid=xyz.nextInt();
//						AreaMasterModel model=new AreaMasterModel();
//						model.setAreaId(id);
//						model.setAreaName(area);
//						model.setCityId(cid);
//						boolean b=ams.isAddArea(model);
//						if(b)
//						{
//							System.out.println("Area added successfully");
//						}
//						else
//						{
//							System.out.println("Area not added");
//						}
//						
//					}
//					break;
//					case 2:
//					{
//						List<AreaMasterModel> list=ams.getAllAreas();
//						if(list!=null)
//						{
//							list.forEach((m)->System.out.println(m.getAreaId()+"\t"+m.getAreaName()+"\t"+m.getCityId()));
//						}
//						else
//						{
//							System.out.println("No Areas Present...!!");
//						}
//					}
//					break;
//					case 3:
//					{
//						System.out.println("enter area id");
//						int arid=xyz.nextInt();
//						System.out.println("enter area name for updation");
//						xyz.nextLine();
//						String arname=xyz.nextLine();
//						ams.isUpdateArea(arid, arname);
//					}
//					break;
//					}
//					
//				}while(choice<=2);
//			}
//			case 4:
//			{
//				do 
//				{
//					System.out.println("case 1---> Add Artical");
//					System.out.println("case 2---> View Articles");
//					System.out.println("case 3---> Update Hotel By Id");
//					System.out.println("enter your choice");
//					choice=xyz.nextInt();
//					switch(choice)
//					{
//					case 1:
//					{
//						System.out.println("enter artical id");
//						int aid=xyz.nextInt();
//						System.out.println("enter artical name");
//						xyz.nextLine();
//						String artname = xyz.nextLine();
//						System.out.println("enter city id");
//						int cid=xyz.nextInt();
//						System.out.println("enter area id");
//						int arid=xyz.nextInt();
//						System.out.println("avrage rating");
//						int avrating=xyz.nextInt();
//						
//						ArticalModel model=new ArticalModel();
//						model.setAid(aid);
//						model.setAname(artname);
//						model.setCityid(cid);
//						model.setAreaid(arid);
//						model.setAvgrating(avrating);
//						boolean b=as.isAddArtical(model);
//						if(b)
//						{
//							System.out.println("Artical Added Succsesfully");
//						}
//						else
//						{
//							System.out.println("Artical Not Added");
//						}
//					}
//					break;
//					case 2:
//					{
//						List<ArticalModel> list=as.getAllArticle();
//						if(list!=null)
//						{
//							if(list!=null)
//							{
//								list.forEach((m)->System.out.println(m.getAid()+"\t"+m.getAname()+"\t"+m.getAreaid()+"\t"+m.getAvgrating()+"\t"+m.getCityid()));
//							}
//							else
//							{
//								System.out.println("No Hotel Present...!!");
//							}
//							
//						}
//						else
//						{
//							System.out.println("No Hotel Present...!!");
//						}
//					}
//					break;
//					case 3:
//					{
//						System.out.println("enter article id");
//						int ad=xyz.nextInt();
//						System.out.println("enter Hotel Name for updation");
//						xyz.nextLine();
//						String artname=xyz.nextLine();
//						as.updateHotelById(ad,artname);
//						
//					}
//					break;
//					}
//					
//				}
//				while(choice<=3);
//			}
//			case 5:
//			{    
//				do
//				{   
//					System.out.println("case 1 ---> LogIn Admin");
//					System.out.println("enter your choice");
//				    choice=xyz.nextInt();
//					switch(choice)
//					{
//					case 1:
//				{	
//						System.out.println("Enter Your Email");
//						String email=xyz.nextLine();
//						xyz.nextLine();
//						System.out.println("Enter Your Password");
//						String pass=xyz.nextLine();
//						boolean login= ads.authenticateadmin(email,pass);
//						if(login) {
//							System.out.println("Login Succesfully...!!!");
//						}else {
//							System.out.println("Invalid Email password...!!!");
//						}
//							
//					}
//					break;
//					}
//				}
//				while(choice<=1);
//			}
			default:
			    System.out.println("wrong choice");
			}
		}
        while(true);
	}

}
	}
	
