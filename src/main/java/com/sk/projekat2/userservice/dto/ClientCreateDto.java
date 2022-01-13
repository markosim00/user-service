package com.sk.projekat2.userservice.dto;

public class ClientCreateDto extends UserCreateDto{
	
	private String passportNumber;
	private int numberOfReservations;
	
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public int getNumberOfReservations() {
		return numberOfReservations;
	}
	public void setNumberOfReservations(int numberOfReservations) {
		this.numberOfReservations = numberOfReservations;
	}
	
	
	

}
