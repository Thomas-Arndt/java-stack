package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	private int userID;
	private int pin;
	
	public Physician(int id) {
		this.patientNotes = new ArrayList<String>();
		this.userID = id;
	}
	
	public boolean assignPin(int pin) {
		if(pin > 999 && pin < 10000) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean accessAuthorized(Integer ID) {
		return this.userID == ID ? true : false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.userID);
		report += String.format("Patient's Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
