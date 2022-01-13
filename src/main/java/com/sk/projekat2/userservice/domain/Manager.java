package com.sk.projekat2.userservice.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Manager extends User{
	
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
