package com.nmit;

import java.io.Serializable;

public class Users implements Serializable{
	String Name;
	String Password;
	String Intcom;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getIntcom() {
		return Intcom;
	}
	public void setIntcom(String intcom) {
		Intcom = intcom;
	}
	
}
