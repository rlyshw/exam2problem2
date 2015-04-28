package com.rlyshw.customer.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
	private final StringProperty FirstName;
	private final StringProperty MiddleInitial;
	private final StringProperty LastName;
	private final StringProperty Gender;
	private final StringProperty Address;
	private final StringProperty city;
	private final StringProperty State;
	private StringProperty zip;
	
	public StringProperty getFirstName() {
		return FirstName;
	}

	public StringProperty getMiddleInitial() {
		return MiddleInitial;
	}

	public StringProperty getLastName() {
		return LastName;
	}

	public StringProperty getGender() {
		return Gender;
	}

	public StringProperty getAddress() {
		return Address;
	}

	public StringProperty getCity() {
		return city;
	}

	public StringProperty getState() {
		return State;
	}

	public StringProperty getZip() {
		return zip;
	}
	public String toString(){
		return this.LastName.get()+", "+this.FirstName.get()+" "+this.MiddleInitial.get()+", "+this.Gender.get()+"\n"+
				this.Address.get()+", "+this.city.get()+", "+this.State.get()+" "+this.zip.get();
	}

	public Customer(String firstName, String lastName, String middleInitial, String gender, String address, String state, String z, String city){
		this.FirstName = new SimpleStringProperty(firstName);
		this.LastName = new SimpleStringProperty(lastName);
		this.MiddleInitial = new SimpleStringProperty(middleInitial);
		this.Gender = new SimpleStringProperty(gender);
		this.Address = new SimpleStringProperty(address);
		this.city = new SimpleStringProperty(city);
		this.State = new SimpleStringProperty(state);
		if(z.length()==5 || z.length()==9){
			for(char c : z.toCharArray()){
				if(Character.isLetter(c)){
					this.zip = null;
					break;
				}
			}
			this.zip = new SimpleStringProperty(z);
		}
		else this.zip = null;
		
	}
}
