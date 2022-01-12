package com.sk.projekat2.userservice.dto;

import java.util.Date;

public class ManagerCreateDto extends UserCreateDto{
	
	private String hotelName;
	private Date dateOfEmployment;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
	

}
