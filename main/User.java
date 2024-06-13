//User.java

import java.io.*;

public abstract class User implements Serializable{
	String fName;
	String lName;
	String userName;
	String password;
/*
 * Main and constructor used for testing purposes
	public static void main(String[] args){
		User u = new User("Beth","Caruana","bcaruana","swimming");
		System.out.println(u.getfName()+" "+u.getlName()+" "+u.getUserName()+" "+u.getPassword());
	}//end main

	public User(String fName, String lName, String userName, String password){
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}//end constructor
*/
	public abstract void menu();

	public void setfName(String fName){
		this.fName = fName;
	}//end setfName

	public String getfName(){
		return this.fName;
	}//end getfName

	public void setlName(String lName){
		this.lName = lName;
	}//end setlName

	public String getlName(){
		return this.lName;
	}//end getlName

	public void setUserName(String userName){
		this.userName = userName;
	}//end setUserName

	public String getUserName(){
		return this.userName;
	}//end getUserName

	public void setPassword(String password){
		this.password = password;
	}//end setPassword

	public String getPassword(){
		return this.password;
	}//end getPassword
}//end class def
