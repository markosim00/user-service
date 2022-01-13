package com.sk.projekat2.userservice.domain;

import javax.persistence.Entity;

@Entity
public class Client extends User{
	
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
