package com.sk.projekat2.userservice.dto;

public class ClientCreateDto extends UserCreateDto{
	
	private String passportNumber;
	private String numberOfReservations;
	
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNumberOfReservations() {
		return numberOfReservations;
	}
	public void setNumberOfReservations(String numberOfReservations) {
		this.numberOfReservations = numberOfReservations;
	}
	
	

}
